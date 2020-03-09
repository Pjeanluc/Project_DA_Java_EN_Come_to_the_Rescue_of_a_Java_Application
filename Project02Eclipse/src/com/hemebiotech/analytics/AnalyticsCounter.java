package com.hemebiotech.analytics;

/**
 * 
 * @author jl Protois
 *
 */
public class AnalyticsCounter {
	
			
	public static void main(String args[]) throws Exception {
		
			
		//Read entry file
		ISymptomReader symptoms = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		
		//Count symptoms
		ISymptomsCount listesCount = new CountSymptomFromList(symptoms.getSymptoms());
		
		//Write the list of symptoms with count
		IWriteCountSymptoms writeSymptoms = new PrintListSymptoms(listesCount.GetMap(), "Project02Eclipse/result2.out");
		writeSymptoms.writeResult ();
		
	}
		
}
