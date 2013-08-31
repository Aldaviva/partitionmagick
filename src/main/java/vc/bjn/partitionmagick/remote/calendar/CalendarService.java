package vc.bjn.partitionmagick.remote.calendar;

import java.util.List;

import vc.bjn.partitionmagick.data.entity.CalendarEvent;

import com.google.common.base.Predicate;

public interface CalendarService {

	List<CalendarEvent> findEvents(Predicate<CalendarEvent> predicate);


}
