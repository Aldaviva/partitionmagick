package vc.bjn.partitionmagick.data.predicates;

import vc.bjn.partitionmagick.data.entity.CalendarEvent;

import com.google.common.base.Predicate;
import javax.annotation.Nullable;

public interface CalendarPredicates {

	Predicate<CalendarEvent> FUTURE_EVENTS = new Predicate<CalendarEvent>() {

		@Override
		public boolean apply(@Nullable final CalendarEvent input) {
			return input.getStart().isAfterNow();
		}

	};

}
