package com.hemebiotech.analytics.fileFactory;

import com.hemebiotech.analytics.exceptions.PersonalExceptions;
import com.hemebiotech.analytics.fileFactory.reader.SymptomFileReaderGeneric;
import com.hemebiotech.analytics.fileFactory.reader.SymptomsFileReaderTxt;

public class FileFactory {
	
	public SymptomFileReaderGeneric getReader(String filepath) throws PersonalExceptions {
		
		SymptomFileReaderGeneric fileReader = null;
		String extentionFile = "";
			
			extentionFile = filepath.substring(filepath.length() - 4); // extention file detection
			switch (extentionFile) {
			case ".txt":
				fileReader = new SymptomsFileReaderTxt();
				break;
			default: // extention file is not .txt
				throw new PersonalExceptions("Exception : " + extentionFile + " is an unknown file extension");
			}
			return fileReader;
				
	}

}
