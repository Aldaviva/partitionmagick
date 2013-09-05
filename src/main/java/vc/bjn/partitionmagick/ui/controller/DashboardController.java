package vc.bjn.partitionmagick.ui.controller;

import vc.bjn.partitionmagick.data.predicates.CalendarPredicates;
import vc.bjn.partitionmagick.data.repository.PartitionRepository;
import vc.bjn.partitionmagick.remote.calendar.CalendarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardController {

	@Autowired private PartitionRepository partitionRepository;
	@Autowired private CalendarService calendarService;

	@RequestMapping
	public String index(final ModelMap model){
		model.addAttribute("partitions", partitionRepository.findAll(new Sort("sort")));
		model.addAttribute("calendarEvents", calendarService.findEvents(CalendarPredicates.FUTURE_EVENTS));
		return "dashboard";
	}

}
