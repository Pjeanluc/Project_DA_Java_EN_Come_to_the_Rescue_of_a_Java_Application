package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		
		//JLP
		ISymptomReader symptoms = new ReadSymptomDataFromFile("Project02Eclipse/symptomsvide.txt");
		List<String> listesymptom = symptoms.GetSymptoms();
		
		int i = 0;	// set i to 0
		
		String line ;
				
		
		while (i < listesymptom.size()) {
		
			line = listesymptom.get(i);
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			i++;
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("Project02Eclipse/result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
