package com.coviam.ecom.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coviam.ecom.entity.SearchList;
import com.coviam.ecom.search.PathProperties;

@Component
public class SearchServiceImp implements SearchService{
	private final int RESULT_SIZE=20;
	private PathProperties paths;
	@Autowired
    public void setProduct(PathProperties paths) {
        this.paths = paths;
    }
	@Override
	public List<SearchList> search(String query) {
		
		 String uri = paths.getProduct() +"/getProductByNameIgnoreCase/"+query;
		 
		 RestTemplate restTemplate = new RestTemplate();
		// Object result = restTemplate.getForObject(uri, Object.class);
		 ResponseEntity<List<SearchList>> responseEntity = restTemplate.exchange(uri , HttpMethod.GET,
	                null, new ParameterizedTypeReference<List<SearchList>>() {});
	        List<SearchList> searchListObject = responseEntity.getBody();
	        System.out.println("===========" + searchListObject.size());
	        if(searchListObject.size() == 0){
	        	System.out.println("=====++++++++++=====\n");
	       	 	String subStringUri = paths.getProduct() +"/getProductByNameSubString/"+query;
	       	 	ResponseEntity<List<SearchList>> responseEntitySubString = restTemplate.exchange(subStringUri , HttpMethod.GET,
	       	 			null, new ParameterizedTypeReference<List<SearchList>>() {});
	       	 	List<SearchList> searchListObjectSubString = responseEntitySubString.getBody();

	       	 	System.out.println("===========" + searchListObjectSubString.size()+ " jljfas\n"
	       	 			+searchListObjectSubString.get(0).toString());
	       	 	return searchListObjectSubString;
	        }
	      
		// System.out.println(searchListObject.size()+" ss "+searchListObject.get(0).toString());
		 return searchListObject;
		
	}
	
	public Object advSearch(String query){
		//search by Name;
		String uri = paths.getProduct() +"/getProductbyNameIgnoreCase/"+query;
		 
		 RestTemplate restTemplate = new RestTemplate();
		// Object result = restTemplate.getForObject(uri, Object.class);
		 
		 ResponseEntity<List<SearchList>> responseEntity = restTemplate.exchange(uri , HttpMethod.GET,
	                null, new ParameterizedTypeReference<List<SearchList>>() {});
	        List<SearchList> searchListObject = responseEntity.getBody();
	        
	        System.out.println(searchListObject.size());
	        
	        if(searchListObject.size()<RESULT_SIZE){
	        	//split the query and remove the stop words.
	   		 String queryTerms[]=query.split(" ");
	   		 //https://stackoverflow.com/questions/38073450/searching-for-multiple-words-in-spring-data-repository
	   		 
	        }else{
	        	return searchListObject;
	        }

		 
		return null;
	}
	
}	

