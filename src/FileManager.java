
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

public class FileManager {
    private String fileName;
    private File input = new File("input.csv");
    private double[] fileReadData;

    private double[] readTemp(boolean dataIsMin) {

        return fileReadData;
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

    public double[] getFileReadData() {
        return this.fileReadData;
    }

    public void setFileReadData(double[] fileReadData) {
        this.fileReadData = fileReadData;
    }

}
