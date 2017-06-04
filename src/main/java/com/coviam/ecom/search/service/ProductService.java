package com.coviam.ecom.search.service;

import java.util.ArrayList;
import java.util.HashSet;

public interface ProductService {

	ArrayList<Product> findByName(String query);

	HashSet<String> getBrands();

}
