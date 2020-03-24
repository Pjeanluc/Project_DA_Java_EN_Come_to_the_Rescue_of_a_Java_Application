package com.hemebiotech.analytics.fileFactory;

import com.hemebiotech.analytics.exceptions.PersonalExceptions;
import com.hemebiotech.analytics.fileFactory.reader.SymptomFileReaderGeneric;
import com.hemebiotech.analytics.fileFactory.reader.SymptomsFileReaderTxt;
import com.hemebiotech.analytics.fileFactory.writer.ListSymptomsWriterConsole;
import com.hemebiotech.analytics.fileFactory.writer.ListSymptomsWriterOut;
import com.hemebiotech.analytics.fileFactory.writer.ListSymptomsWriterGeneric;

public class FileFactory {
	
	/**
	 * 
	 * @param filepath
	 * @return instance of the Reader
	 * @throws PersonalExceptions
	 */
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

	/**
	 * 
	 * @param filepath
	 * @return Writer
	 */
	public ListSymptomsWriterGeneric getWriter(String filepath) {
					
		String extentionFile = "";
		
		ListSymptomsWriterGeneric fileWriter = null;

		extentionFile = filepath.substring(filepath.length() - 4); // extention file detection
		if (extentionFile.equals(".out")) {
			fileWriter = new ListSymptomsWriterOut();
		} else {
			fileWriter = new ListSymptomsWriterConsole();
		}
			return fileWriter;
	}
}
