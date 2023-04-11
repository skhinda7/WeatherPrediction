//*********************************************************
// Class: FileManager
// Author: Simardeep Khinda
// Created: 03/21/2023
// Modified: 
//
// Purpose: FileManager is responsible for reading and writing to and from a file.
//
// Attributes: 
//			-fileName: String
//          -fileReadData: double[]
// 
// Methods: -readTemp(boolean dataIsMin): double[]
//          -readData(): double[]
//          -writeData(): void
//
//*********************************************************
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileManager {
    private String fileName;
    private File input = new File("input.csv");

    public ArrayList<Double> readTemp(int lineCount) {
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

    public void readData() {
        try {
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);

            String row = br.readLine();
            System.out.println(row);

            while ((row = br.readLine()) != null) {
                String[] readData = row.split(",", 3);
                System.out.println("Day: " + readData[0] + "| Min: " + readData[1] + "| Max: " + readData[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeData(double[] data) {

    }

    // Getters and Setters

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
