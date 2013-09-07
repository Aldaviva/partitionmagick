package vc.bjn.partitionmagick.remote.calendar;

import vc.bjn.partitionmagick.data.entity.CalendarEvent;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalendarServiceImpl implements CalendarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarServiceImpl.class);
	private static final String ORDERBY_STARTTIME = "startTime";

	@Value("${calendar.id}") private String calendarId;
	@Autowired private Calendar calendar;

	private List<CalendarEvent> cachedEvents;

	public CalendarServiceImpl() {
		/*final CacheLoader<String, List<CalendarEvent>> cacheLoader = new CacheLoader<String, List<CalendarEvent>>(){

			@Override
			public List<CalendarEvent> load(final String key) throws Exception {
				return _downloadEvents(key);
			}
		};
		eventListCache = CacheBuilder.newBuilder().expireAfterWrite(CACHE_LIFE_MINUTES, TimeUnit.MINUTES).build(cacheLoader);*/
	}

	@PostConstruct
	private void init(){
		updateEvents();
	}

	private List<CalendarEvent> downloadEvents(final String calId) {
		LOGGER.debug("Downloading calendar {}", calId);
		final List<CalendarEvent> results = new ArrayList<>();
		String pageToken = null;

		try {
			do {
				final Events response = calendar.events().list(calId)
					.setSingleEvents(true)
					.setOrderBy(ORDERBY_STARTTIME)
					.setPageToken(pageToken)
					.setTimeMin(new DateTime(new Date()))
					.execute();

				final List<Event> items = response.getItems();
				if(items != null){
					for (final Event event : items) {
						results.add(new CalendarEvent(event));
					}
					pageToken = response.getNextPageToken();
				}

			} while(pageToken != null);

			LOGGER.debug("downloaded calendar events:");
			for(final CalendarEvent event : results){
				LOGGER.debug(event.toString());
			}

			return results;

		} catch (final IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<CalendarEvent> updateEvents() {
		cachedEvents = downloadEvents(calendarId);
		return getCachedEvents();
	}

	@Override
	public List<CalendarEvent> getCachedEvents() {
		return cachedEvents;
	}

}
