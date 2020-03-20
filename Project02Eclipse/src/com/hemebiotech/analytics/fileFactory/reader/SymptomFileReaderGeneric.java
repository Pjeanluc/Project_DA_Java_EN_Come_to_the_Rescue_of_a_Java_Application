package com.hemebiotech.analytics.fileFactory.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.vavr.control.Either;

/**
 * Simple brute force implementation
 *
 */
public abstract class SymptomFileReaderGeneric implements ISymptomReaderGeneric {

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
