package vc.bjn.partitionmagick.ui.controller;

import vc.bjn.partitionmagick.data.repository.PartitionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wiki")
public class WikiController {

	@Autowired private PartitionRepository partitionRepository;

	@RequestMapping
	public String index(final ModelMap model){
		model.addAttribute("partitions", partitionRepository.findAll(new Sort("sort")));
		return "wiki";
	}

}
