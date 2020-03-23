package com.hemebiotech.analytics.fileFactory.writer;

import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Print in a file a map 
 * 
 * @author JL Protois
 */

public class ListSymptomsWriterOut extends ListSymptomsWritergeneric implements ISymptomsWriterGeneric {

	
	/**
	 * Print symptoms and count in a file
	 * 
	 * @author JL Protois
	 */
	
	
	@Override
	public Boolean writeResult (Map<String, Long> listCountingSymptoms, String filePath) {
						
		try {
			
			FileWriter writer = new FileWriter(filePath);
		
			for (Map.Entry<String, Long> mapentry : listCountingSymptoms.entrySet()) {
					writer.write(String.join("=", mapentry.getKey(), mapentry.getValue().toString()));
					writer.write("\n");
			}  
	  
	        writer.close();
	        return true;
		
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}


