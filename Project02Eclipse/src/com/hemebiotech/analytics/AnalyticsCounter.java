package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		final String inputPath = "Project02Eclipse/symptoms.txt";
		final String outputPath = "Project02Eclipse/result.out";

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(inputPath, outputPath);
		// 1. Read data from symptoms.txt and create a map
		Map<String, Integer> data = reader.GetSymptoms();

		// 2. Order data in map
		Map<String, Integer> map = reader.OrderSymptoms(data);
		System.out.println("result: " + map);

		// 3. Write into result.out
		reader.SetSymptoms(map);


	}
}
