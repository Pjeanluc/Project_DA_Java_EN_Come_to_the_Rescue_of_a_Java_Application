package com.hemebiotech.analytics.fileFactory.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SymptomsFileReaderTxt extends SymptomFileReaderGeneric {

	@Override
	public List<String> getSymptoms(String filepath) throws IOException {
			
		ArrayList<String> result = new ArrayList<String>();

		result.addAll(this.getLines(filepath));		

		return result;
	}

}
