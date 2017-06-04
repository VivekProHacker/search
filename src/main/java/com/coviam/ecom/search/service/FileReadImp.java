package com.coviam.ecom.search.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class FileReadImp implements FileRead {

	@Override
	public HashSet<String> read(String filepath) {
		// TODO Auto-generated method stub
		HashSet<String> doc = new HashSet<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String line = null;
			try {
				while ((line = br.readLine()) != null) {
					doc.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return doc;
	}

}
