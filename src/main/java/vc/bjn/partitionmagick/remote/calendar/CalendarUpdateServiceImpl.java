package vc.bjn.partitionmagick.remote.calendar;

import vc.bjn.partitionmagick.data.entity.CalendarEvent;
import vc.bjn.partitionmagick.service.BroadcastService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CalendarUpdateServiceImpl implements CalendarUpdateService {

	private static final int POLL_INTERVAL_MILLIS = 30*1000;

	@Autowired private CalendarService calendarService;
	@Autowired private BroadcastService broadcastService;

	@Override
	@Scheduled(fixedRate=POLL_INTERVAL_MILLIS)
	public void pollForUpdates() {
		final List<CalendarEvent> oldEvents = calendarService.getCachedEvents();
		final List<CalendarEvent> newEvents = calendarService.updateEvents();

		if(!newEvents.equals(oldEvents)){
			onUpdate(newEvents);
		}
	}

	@Override
	public void onUpdate(final List<CalendarEvent> newEvents) {
		broadcastService.broadcast("update");
	}

}
