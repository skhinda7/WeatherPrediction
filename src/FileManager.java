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
// 
// Methods: +names(): String[]
//          +readData(int): ArrayList<Double>
//          +writeData(ArrayList<Double>): void
//
//*********************************************************
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {
    File input = new File("input.csv");
    public String[] names;

    public String[] names() {
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

    public void writeData(ArrayList<Double> data) {
        File output = new File("prediction.txt");
        try {
            FileWriter fw = new FileWriter(output);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Hi");
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
