package com.hemebiotech.analytics.reader;

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
public class SymptomDataFromFileReader implements ISymptomReader {

	private String filepath;
	
	
	
	@Override
	public Either<Boolean, List<String>> getSymptoms(String filepath) {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				return Either.left(false);
			}
		}
		
		return Either.right(result);
	}

}
