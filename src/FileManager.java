//*********************************************************
// Class: FileManager
// Author: Simardeep Khinda
// Created: 03/21/2023
// Modified: 
//
// Purpose: FileManager is responsible for reading and writing to and from a file.
//
// Attributes: 
//			-names: String[]
//          -input: File
// 
// Methods: +names(): String[]
//          +readData(int): ArrayList<Double>
//          +writeData(ArrayList<Double>, ArrayList<Double>, ArrayList<Double>, ArrayList<Double>): void
//
//*********************************************************
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {
    private File input = new File("input.csv");
    public String[] names;

    public String[] names() {
        // Method reads the header of the CSV file and stores the names as choices for what can be predicted.
        try {
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);

            String header = br.readLine();
            names = header.split(",");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return names;
    }
    
    public ArrayList<Double> readData(int lineCount) {
        
        ArrayList<Double> temp = new ArrayList<Double>();

        String line;

        // The data is stored in an ArrayList.
        try {
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                temp.add(Double.parseDouble(values[lineCount]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void writeData(ArrayList<Double> oldData, ArrayList<Double> lrData, ArrayList<Double> prData, ArrayList<Double> avgData) {
    File output = new File("prediction.txt");
    
    // The passed data is written to prediction.txt.
    try {
        FileWriter fw = new FileWriter(output);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for(int i = 0; i < oldData.size(); i++) {
            bw.write("Day: " + (i + 1) + " | " + oldData.get(i));
            bw.newLine();
        }

        for(int i = 0; i < lrData.size(); i++) {
            bw.write("Day: " + ((i + 1) + oldData.size()) + " | LR: " + lrData.get(i) + " | PR: " + prData.get(i) + " | AVG: " + avgData.get(i));
            bw.newLine();
        }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Getters and Setters

    public File getInput() {
        return this.input;
    }

    public void setInput(File input) {
        this.input = input;
    }

    public String[] getNames() {
        return this.names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
    
}
