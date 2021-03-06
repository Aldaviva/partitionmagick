package vc.bjn.partitionmagick.remote.calendar;

import vc.bjn.partitionmagick.data.entity.CalendarEvent;

import java.util.List;

public interface CalendarService {

	List<CalendarEvent> updateEvents();
	List<CalendarEvent> getCachedEvents();
}
