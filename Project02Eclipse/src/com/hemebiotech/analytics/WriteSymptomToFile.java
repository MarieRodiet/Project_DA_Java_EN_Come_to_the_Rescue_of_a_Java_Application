package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomToFile implements ISymptomWriter{
    private String outputPath;
    public WriteSymptomToFile(String outputPath){
        this.outputPath = outputPath;
    }

    /**
     *
     * @param map
     * of symptoms and their number of occurrences
     * written in file to be created at the
     * location of outputPath
     */
    public void writeSymptoms(Map<String, Integer> map){
        //Create a new File
        File file = new File (this.outputPath);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                //write key/value pairs to each line of file
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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
