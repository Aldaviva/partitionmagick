package vc.bjn.partitionmagick.ui.controller;

import vc.bjn.partitionmagick.api.resource.EventEndpoint;
import vc.bjn.partitionmagick.data.entity.Partition;
import vc.bjn.partitionmagick.data.repository.PartitionRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class EditorController {

	@Autowired private PartitionRepository partitionRepository;

	@RequestMapping
	public String index(final ModelMap model){

		final EditorFormData formData = new EditorFormData();
		formData.setPartitions(partitionRepository.findAll(new Sort("sort")));
		model.addAttribute("formData", formData);
		return "editor";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String save(@ModelAttribute("formData") final EditorFormData formData){
		partitionRepository.save(formData.getPartitions());
		EventEndpoint.broadcast("update");

		return "redirect:/admin";
	}

	public static final class EditorFormData {
		private List<Partition> partitions;

		public List<Partition> getPartitions() {
			return partitions;
		}
		public void setPartitions(final List<Partition> partitions) {
			this.partitions = partitions;
		}
	}

}
