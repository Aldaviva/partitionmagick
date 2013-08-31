package vc.bjn.partitionmagick.data.entity;

import com.google.api.services.calendar.model.Event;
import org.joda.time.DateTime;

public class CalendarEvent {

	private DateTime start;
	private String name;
	private String description;

	public CalendarEvent(){

	}

	public CalendarEvent(final Event googleCalendarEvent){
		name = googleCalendarEvent.getSummary();
		description = googleCalendarEvent.getDescription();

		com.google.api.client.util.DateTime googleStartDate = googleCalendarEvent.getStart().getDateTime();
		if(googleStartDate == null){
			googleStartDate = googleCalendarEvent.getStart().getDate();
		}
		start = new DateTime(googleStartDate.getValue());
	}

	public DateTime getStart() {
		return start;
	}
	public void setStart(final DateTime start) {
		this.start = start;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CalendarEvent other = (CalendarEvent) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (start == null) {
			if (other.start != null) {
				return false;
			}
		} else if (!start.equals(other.start)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("CalendarEvent [start=%s, name=%s, description=%s]", start, name, description);
	}

}
