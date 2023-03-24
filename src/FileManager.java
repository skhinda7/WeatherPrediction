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

public class FileManager {
    private String fileName;
    private double[] fileReadData;

    private double[] readTemp(boolean dataIsMin) {

        return fileReadData;
    }

    private double[] readData() {

        return fileReadData;
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
