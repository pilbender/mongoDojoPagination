package net.raescott.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public @ResponseBody List<Part> examplePaging() {
        List<Part> partList = new LinkedList<Part>();
        Iterable<Part> partIterable = partMongoRepositoryGenerated.findAll();
        for (Part part : partIterable) {
            partList.add(part);
        }
        return partList;
    }
}