package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// 1. Read data from symptoms.txt
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> data = reader.GetSymptoms();

		// 2. Order data in map <String, Integer>
		Map<String, String> map = reader.OrderSymptoms(data);


		// 3. Write ordered data into result.out
		// create new HashMap
		HashMap<String, String> test = new HashMap<>();

		// key-value pairs
		map.put("rohit", "one");
		map.put("Sam", "two");
		map.put("jainie", "three");
		reader.SetSymptoms(test);

		

	}
}
