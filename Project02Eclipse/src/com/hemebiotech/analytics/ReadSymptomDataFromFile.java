package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String inputPath;
	private String outputPath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String inputPath, String outputPath) {

		this.inputPath = inputPath;
		this.outputPath = outputPath;
	}
	
	@Override
	public Map<String, Integer> GetSymptoms() {
		Map<String, Integer> result = new HashMap<>();
		
		if (this.inputPath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.inputPath));
				String line = reader.readLine();
				
				while (line != null) {
					if(result.containsKey(line)){
						//increment the index of that symptom
						result.put(line, result.get(line) + 1);
					}
					else {
						result.put(line, 1);
					}
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Map<String, Integer> OrderSymptoms(Map<String, Integer> data) {
		Map<String, Integer> sorted = new TreeMap<>(data);
		return sorted;
	}

	@Override
	public void SetSymptoms(Map<String, Integer> map) throws IOException {
		File file = new File (this.outputPath);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			for(Map.Entry<String, Integer> entry : map.entrySet()){
				bw.write(entry.getKey() + " : " + entry.getValue());

				bw.newLine();
			}
			bw.flush();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				bw.close();
			}
			catch (Exception e){
			}
		}

	}
}
