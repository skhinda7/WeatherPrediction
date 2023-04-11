//*********************************************************
// Class: Controller 
// Author: Simardeep Khinda
// Created: 03/22/2023
// Modified: 
//
// Purpose: Controller class calls other classes and methods to predict the weather data.
//
// Attributes: 
//			+oldMinData: ArrayList<Double>
//	        +oldMaxData: ArrayList<Double>
// 
// Methods: +main(String[] args): void
//          -readTemp(): void
//          -readData(): void
//          -writeToFile(): void
//          -minMaxAverage(double[], double[]): void
//
//*********************************************************

/*
 * 1,30,40
2,32,45
3,29,37
4,30,42
5,35,49
6,40,50
7,35,51
 */
import java.util.ArrayList;

public class Controller {
    ArrayList<Double> oldMinData = new ArrayList<Double>();
    ArrayList<Double> oldMaxData = new ArrayList<Double>();
    FileManager file = new FileManager();

    public static void main(String[] args) {
        Controller control = new Controller();
        control.readTemp();
        GenericPredictor prMin = new PolynomialRegression(control.oldMinData);
        GenericPredictor prMax = new PolynomialRegression(control.oldMaxData);
        GenericPredictor lrMin = new LinearRegression(control.oldMinData);
        GenericPredictor lrMax = new LinearRegression(control.oldMaxData);

        prMin.predict();
        prMax.predict();
        lrMin.predict();
        lrMax.predict();
    }

    private void readTemp() {
        oldMinData = file.readTemp(1);
        oldMaxData = file.readTemp(2);

        System.out.println("Minimum: " + oldMinData);
        System.out.println("Maximum: " + oldMaxData);
    }

    public void readData() {
        file.readData();
    }

    private void writeToFile() {

    }

    private void minMaxAverage(ArrayList<Double> LRData, ArrayList<Double> DMData) {

    }

    // Getters and Setters

    public ArrayList<Double> getOldMinData() {
        return this.oldMinData;
    }

    public void setOldMinData(ArrayList<Double> oldMinData) {
        this.oldMinData = oldMinData;
    }

    public FileManager getFile() {
        return this.file;
    }

    public void setFile(FileManager file) {
        this.file = file;
    }
}
