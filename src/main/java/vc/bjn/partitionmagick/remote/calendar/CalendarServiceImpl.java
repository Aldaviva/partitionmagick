package vc.bjn.partitionmagick.remote.calendar;

import vc.bjn.partitionmagick.data.entity.CalendarEvent;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Collections2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalendarServiceImpl implements CalendarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarServiceImpl.class);
	private static final String ORDERBY_STARTTIME = "startTime";
	private static final int CACHE_LIFE_MINUTES = 30;

	@Value("${calendar.id}") private String calendarId;
	@Autowired private Calendar calendar;

	private final LoadingCache<String, List<CalendarEvent>> eventListCache;

	public CalendarServiceImpl() {
		final CacheLoader<String, List<CalendarEvent>> cacheLoader = new CacheLoader<String, List<CalendarEvent>>(){

			@Override
			public List<CalendarEvent> load(final String key) throws Exception {
				return _downloadEvents(key);
			}
		};
		eventListCache = CacheBuilder.newBuilder().expireAfterWrite(CACHE_LIFE_MINUTES, TimeUnit.MINUTES).build(cacheLoader);
	}

	protected List<CalendarEvent> getEvents(){
		return eventListCache.getUnchecked(calendarId);
	}

	private List<CalendarEvent> _downloadEvents(final String calId) {
		LOGGER.debug("Downloading calendar {}", calId);
		final List<CalendarEvent> results = new ArrayList<>();
		String pageToken = null;
		final int page = 0;

		try {
			do {
				final Events response = calendar.events().list(calId)
					.setSingleEvents(true)
					.setOrderBy(ORDERBY_STARTTIME)
					.setPageToken(pageToken)
					.execute();

				final List<Event> items = response.getItems();
				if(items != null){
					for (final Event event : items) {
						results.add(new CalendarEvent(event));
					}
					pageToken = response.getNextPageToken();
				}

			} while(pageToken != null);

			return results;

		} catch (final IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<CalendarEvent> findEvents(final Predicate<CalendarEvent> predicate) {
		final List<CalendarEvent> events = getEvents();
		return new ArrayList<>(Collections2.filter(events, predicate));
	}

}
