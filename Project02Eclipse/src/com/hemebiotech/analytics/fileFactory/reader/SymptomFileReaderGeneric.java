package com.hemebiotech.analytics.fileFactory.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author S053261
 *
 */
public abstract class SymptomFileReaderGeneric implements ISymptomReaderGeneric {

	/**
	 * 
	 * @param filepath input file
	 * @return lines from the file 
	 * @throws IOException
	 */
	public List<String> getLines(String filepath) throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				
		}
		
		return result;
		
	}
		
}
