package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class ReadSymptomFromFile implements ISymptomReader {

	private String inputPath;

	public ReadSymptomFromFile (String inputPath) {
		this.inputPath = inputPath;
	}

	/***
	 *
	 * @return TreeMap<String, Integer> result
	 *     of each symptom and its number of occurrences
	 *     from the file located at inputPath
	 */
	@Override
	public Map<String, Integer> readSymptomsFromFile() {
		BufferedReader reader = null;
		//The use of TreeMap rearranges the key/value pairs by keys in ASC order
		Map<String, Integer> result = new TreeMap<>();
		
		if (this.inputPath != null) {
			try {
				reader = new BufferedReader (new FileReader(this.inputPath));
				String line = reader.readLine();

				//keep reading the line from file as long as line is not null
				while (line != null) {
					//if symptom found at line is already in map object
					if(result.containsKey(line)){
						// locate it by key and increment its value
						result.put(line, result.get(line) + 1);
					}
					else {
						//or add a new key/value pair with 1 for its first occurrence
						result.put(line, 1);
					}
					line = reader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try{
					reader.close();
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return result;
	}


}
