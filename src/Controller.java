//*********************************************************
// Class: Controller 
// Author: Simardeep Khinda
// Created: 03/22/2023
// Modified: 
//
// Purpose: Controller class calls other classes and methods to predict the weather data.
//
// Attributes: 
//			+fileData: ArrayList<Double>
//	        +lrData: ArrayList<Double>
//          +prData: ArrayList<Double>
// 
// Methods: +main(String[] args): void
//          -controller(): void
//          -askUser(): void
//          -readHeader(): void
//          -readFile(): void
//          -predictData(ArrayList<Double>): void
//          -average(): ArrayList<Double>
//          -writeToFile(): void
//          -createGraph(): void
//
//*********************************************************

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    ArrayList<Double> fileData = new ArrayList<Double>();
    ArrayList<Double> lrData = new ArrayList<Double>();
    ArrayList<Double> prData = new ArrayList<Double>();


    FileManager file = new FileManager();

    public static void main(String[] args) {
        Controller control = new Controller();
        control.controller();
    }

    private void controller() {
        readHeader();
        askUser();
        predictData(fileData);
        createGraph();
    }
    private void askUser() {
        Scanner in = new Scanner(System.in);
        String[] menu = file.getNames();

        System.out.println("Please enter the data you would like to predict using the list below: ");
        
        for( int i = 0; i < menu.length; i++) {
            System.out.println ((i + 1) + " | " + menu[i]);
        }
        
        int selection = in.nextInt() - 1;
        readFile(selection);
    }

    private void readHeader() {
        file.names();
    }

    private void readFile(int index) {
        fileData = file.readData(index);

        System.out.println("\nData that was read: " + fileData);
    }

    private void predictData(ArrayList<Double> data) {
        
        GenericPredictor pr = new PolynomialRegression(data);
        GenericPredictor lr = new LinearRegression(data);

        System.out.println("\nPredicting the data using LR and PR...");

        prData = pr.predict();
        lrData = lr.predict();

        System.out.println("\nPR: " + prData);
        System.out.println("LR: " + lrData);
        System.out.println("Average: " + average());

        writeToFile();

    }

    private ArrayList<Double> average() {
        AverageCalc avg = new AverageCalc();

        return avg.averageOfPrediction(prData, lrData);
    }

    private void writeToFile() {
    }

    private void createGraph() {
        ArrayList<Double> avg = average();
        System.out.println("\nOld Data: - | LR Data: + | PR Data: * | Average Data: = \n");
        for(int i = 0; i < fileData.size(); i++) {
            System.out.print("Old | Day: " + (i+1) + " | ");
            for(int j = 0; j < fileData.get(i) / 2; j++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }

        for(int i = 0; i < lrData.size(); i++) {
            System.out.print("LR  | Day: " + (lrData.size() + (i + 1)) + " | ");
            for(int j = 0; j < lrData.get(i) / 2; j++) {
                System.out.print("+");
            }
            System.out.print("\n");
            System.out.print("PR  | Day: " + (prData.size() + (i + 1)) + " | ");
            for(int j = 0; j < prData.get(i) / 2; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
            System.out.print("AVG | Day: " + (avg.size() + (i + 1)) + " | ");
            for(int k = 0; k < avg.get(i) / 2; k++) {
                System.out.print("=");
            }
            System.out.print("\n");
        }
    }
    // Getters and Setters

    public FileManager getFile() {
        return this.file;
    }

    public void setFile(FileManager file) {
        this.file = file;
    }
}
