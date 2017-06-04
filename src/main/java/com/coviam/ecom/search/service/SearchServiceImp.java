package com.coviam.ecom.search.service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

public class SearchServiceImp implements SearchService{
	
	@Autowired
	ProductService product;
    private final String STOPWORD_INDEX = "stopword.txt";
	
    //get stopwords.
	FileReadImp file = new FileReadImp();
	HashSet<String> stopwords=file.read(STOPWORD_INDEX);
	
	//get brand names.
	HashSet<String> brands =  product.getBrands();
	
	
	@Override
	public ArrayList<Product> search(String query) {
		// TODO Auto-generated method stub
	ArrayList<Product> searchList=new ArrayList<Product>();	
	
	//first check that the query is in the product name list or not.
	 searchList=product.findByName(query);
	 if(searchList!=null){
		 return searchList;
	 }else{
		 //If exact product is not found.
	 
		 //split the query and remove the stop words.
		 String queryTerms[]=query.split(" ");
		 
	 
	 	}
	 
	 
	 
	 
	 
	return searchList;
	 
	
		
	}

}
