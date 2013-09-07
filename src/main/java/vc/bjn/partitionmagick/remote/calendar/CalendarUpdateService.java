package vc.bjn.partitionmagick.remote.calendar;

import vc.bjn.partitionmagick.data.entity.CalendarEvent;

import java.util.List;

public interface CalendarUpdateService {

	void pollForUpdates();

	void onUpdate(List<CalendarEvent> newEvents);

}
