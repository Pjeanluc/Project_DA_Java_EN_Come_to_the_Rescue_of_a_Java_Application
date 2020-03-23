package com.hemebiotech.analytics.fileFactory.writer;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class ListSymptomsWriterConsole extends ListSymptomsWritergeneric implements ISymptomsWriterGeneric {
	
	
	
	
	@Override
	public Boolean writeResult (Map<String, Long> listCountingSymptoms, String filePath) {
						
		System.out.println("Symptom Report write in the console");
		if (!listCountingSymptoms.isEmpty())
		{	
			Set<Entry<String, Long>> entires = listCountingSymptoms.entrySet();  //mapTree.get(index) is not running. a Set class is used
			
			for(Entry<String,  Long> ent:entires){
				System.out.println(ent.getKey() +"="+ ent.getValue());
	        }
			
			System.out.println(listCountingSymptoms.size() + " symptoms found");
			return true;
		}
		else {
			System.out.println("No datas to print in the console");
			return false;
		}
		
	}

}
