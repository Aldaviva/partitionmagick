package vc.bjn.partitionmagick.api.resource;

import vc.bjn.partitionmagick.data.entity.CalendarEvent;
import vc.bjn.partitionmagick.data.predicates.CalendarPredicates;
import vc.bjn.partitionmagick.remote.calendar.CalendarService;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("calendars")
@Produces({ MediaType.APPLICATION_JSON })
public class CalendarResource {

	@Autowired private CalendarService calendarService;

	@GET
	public List<CalendarEvent> listEvents(){
		return calendarService.findEvents(CalendarPredicates.FUTURE_EVENTS);
	}

}
