package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
					System.out.println("symptom from file: " + line);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Map<String, String> OrderSymptoms(List<String> data) {
		Map<String, String> map = new HashMap<>();
		int index = 0;
		for(String symptom : data){
			map.put(symptom.toLowerCase(), new String(String.valueOf(index)));
			index++;
		}
		return map;
	}

	@Override
	public void SetSymptoms(Map<String, String> map) throws IOException {
		// next generate output
		final String outputPath = "Project02Eclipse/result.out";
		File file = new File (outputPath);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			FileWriter writer = new FileWriter(outputPath);
			for(Map.Entry<String, String> entry : map.entrySet()){
				writer.write(entry.getKey() + " : " + entry.getValue());
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
