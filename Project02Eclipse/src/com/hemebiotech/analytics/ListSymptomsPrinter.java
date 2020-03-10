package com.hemebiotech.analytics;

import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Print in a file a map 
 * 
 * @author JL Protois
 */

public class ListSymptomsPrinter implements ISymptomsWriter {

	private Map<String, Long> listCountingSymptoms;
	private String filePath; 

	/**
	 * Constructor
	 * 
	 * @param listCountingSymptoms map with symptom and count
	 * @param filePath name of the output
	 *
	 * @author JL Protois
	 */
	
	public  ListSymptomsPrinter (Map<String, Long> listCountingSymptoms, String filePath) {
		this.listCountingSymptoms = listCountingSymptoms;
		this.filePath = filePath;
	}

		
	/**
	 * Print symptoms and count in a file
	 * 
	 * @author JL Protois
	 */
	
	@Override
	public void writeResult () {
						
		try {
			
			FileWriter writer = new FileWriter(filePath);
		
			for (Map.Entry<String, Long> mapentry : listCountingSymptoms.entrySet()) {
					writer.write(String.join("=", mapentry.getKey(), mapentry.getValue().toString()));
					writer.write("\n");
			}  
	  
	        writer.close();
		
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
				
	}
}


