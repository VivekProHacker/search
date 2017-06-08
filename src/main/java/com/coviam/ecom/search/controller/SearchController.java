package com.coviam.ecom.search.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coviam.ecom.search.service.SearchService;


@RestController
public class SearchController {
	
	@Autowired
	SearchService searchApi;
	
	
	@RequestMapping(value = "/search/{query}", method = RequestMethod.GET)
	public Object search(@PathVariable("query") String query){
		
	return searchApi.search(query);			
	}
	
}
