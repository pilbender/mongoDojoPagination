package net.raescott.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.raescott.dto.Part;
import net.raescott.repository.mongo.PartMongoRepositoryGenerated;

@Controller
@RequestMapping("ajax")
public class AjaxController {
    @Autowired PartMongoRepositoryGenerated partMongoRepositoryGenerated;

	@RequestMapping(method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("message", "Page content");
        Part part = partMongoRepositoryGenerated.findByPartNumber("10000");
        model.addAttribute("mongo", part);
		return "ajax";
	}

	@RequestMapping(value = "example-data", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> exampleJson() {
		Map<String, String> response = new TreeMap<String, String>();
		response.put("status", "true");
		return response;
	}

    @RequestMapping(value = "example-paging", method = RequestMethod.GET)
    public @ResponseBody List<Part> examplePaging(@RequestHeader(required = false) String range
			, @RequestParam(required = false) String attribute) {
	     	List<Part> partList = new LinkedList<Part>();
				Part partPageable = new Part();

		    if( range != null){
					range = range.substring("items=".length());
					int from = Integer.valueOf(range.substring(0, range.indexOf('-')));
					int to = Integer.valueOf(range.substring(0, range.indexOf('-') + 1 ));

					partPageable.setPageSize(to - from + 1);
					partPageable.setOffset(from);
					partPageable.setSort("asc");
				}

				partList = partMongoRepositoryGenerated.findAll(partPageable).getContent();
			
        return partList;
    }
}
