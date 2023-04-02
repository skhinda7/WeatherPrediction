//*********************************************************
// Class: Controller 
// Author: Simardeep Khinda
// Created: 03/22/2023
// Modified: 
//
// Purpose: Controller class calls other classes and methods to predict the weather data.
//
// Attributes: 
//			-newMaxData: double[]
//	        -newMinData: double[]
// 
// Methods: +main(String[] args): void
//          -readTemp(): void
//          -readData(): void
//          -writeToFile(): void
//          -minMaxAverage(double[], double[]): void
//
//*********************************************************

public class Controller {
    private double[] newMaxData;
    private double[] newMinData;
    FileManager file = new FileManager();

    public static void main(String[] args) {
        Controller control = new Controller();

        control.readData();
    }

    private void readTemp() {

    }

    public void readData() {
        file.readData();
    }

    private void writeToFile() {

    }

    private void minMaxAverage(double[] LRData, double[] DMData) {

    }

    // Getters and Setters

    public double[] getNewMaxData() {
        return this.newMaxData;
    }

    public void setNewMaxData(double[] newMaxData) {
        this.newMaxData = newMaxData;
    }

    public double[] getNewMinData() {
        return this.newMinData;
    }

    public void setNewMinData(double[] newMinData) {
        this.newMinData = newMinData;
    }
}
