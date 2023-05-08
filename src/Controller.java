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
    private ArrayList<Double> fileData = new ArrayList<Double>();
    private ArrayList<Double> lrData = new ArrayList<Double>();
    private ArrayList<Double> prData = new ArrayList<Double>();
    private FileManager file = new FileManager();

    public static void main(String[] args) {
        Controller control = new Controller();
        control.controller();
    }

    private void controller() {
        Scanner in = new Scanner(System.in);

        // An introduction of the program is provided.
        System.out.print("\nHello! I am a weather predictor. Provide me with data in \"input.csv.\"");
        System.out.print(" I will use linear regression (LR), polynomial regression (PR), and the average between LR and PR (AVG) to predict the next 10 days of the data type.");
        System.out.print(" If you would like to insert new data, you must restart the program to update the values.");
        
        readHeader();
        askUser();

        // If checkValidAmount() is true, then the data will be predicted.
        if(checkValidAmount()) {
            // fileData is passed to be predicted.
            predictData(fileData);
            // A graph is created based on the predictions.
            createGraph();

            // The program asks to save the data.
            System.out.println("Would you like to save the data to a file? (Y/N)");
            writeToFile(in.next().charAt(0));

            // The program asks to predict other data (Re-run the program).
            System.out.println("Would you like to predict other data? (Y/N)");
            repeatPredict(in.next().charAt(0));
        } else {
            System.out.println("\nERROR: Please make sure the data has 5 or more values.");
        }
    }

    private void askUser() {
        Scanner in = new Scanner(System.in);
        String[] menu = file.getNames();
        int selection = 0;
        boolean validAmount = false;

        while(!validAmount) {
            // User is asked which data they would like to predict.
            System.out.println("\n\nPlease enter the data you would like to predict using the list below: ");
        
            // The menu is displayed.
            for( int i = 0; i < menu.length; i++) {
                System.out.println ((i + 1) + " | " + menu[i]);
            }
        
            // The selected choice is passed to be read from file.
            selection = in.nextInt() - 1;

            if((selection + 1) <= menu.length) {
                readFile(selection);
                validAmount = true;
            }
            else {
                System.out.println("\nERROR: The selection must be less than or equal to " + menu.length);
            }
        }        

    }

    private void readHeader() {
        // The program calls this method from FileManager to read the header and save it.
        file.names();
    }

    private void readFile(int index) {
        // The "index" data is read from the CSV file. 
        fileData = file.readData(index);

        System.out.println("\nData that was read: " + fileData);
    }

    private void predictData(ArrayList<Double> data) {
        // PR and LR models are created to predict the passed data.
        GenericPredictor pr = new PolynomialRegression(data);
        GenericPredictor lr = new LinearRegression(data);

        System.out.println("\nPredicting the data using LR and PR...");

        // The predictions are stored in an ArrayList.
        prData = pr.predict();
        lrData = lr.predict();

        System.out.println("\nPR: " + prData);
        System.out.println("LR: " + lrData);
        System.out.println("Average: " + average());

    }

    private ArrayList<Double> average() {
        AverageCalc avg = new AverageCalc();
        // The average ArrayList of the ArrayLists are returned.
        return avg.averageOfPrediction(prData, lrData);
    }


    private void createGraph() {
        ArrayList<Double> avg = average();
        // The graph of the old data is created.
        System.out.println("\nOld Data: - | LR Data: + | PR Data: * | Average Data: = \n");
        for(int i = 0; i < fileData.size(); i++) {
            System.out.print("Old | Day: " + (i+1) + " | ");
            for(int j = 0; j < fileData.get(i) / 2; j++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        for(int i = 0; i < lrData.size(); i++) {
            
            // The graph of the LR data is created.
            System.out.print("LR  | Day: " + (fileData.size() + (i + 1)) + " | ");
            for(int j = 0; j < lrData.get(i) / 2; j++) {
                System.out.print("+");
            }
            System.out.print("\n");
            
            // The graph of the PR data is created.
            System.out.print("PR  | Day: " + (fileData.size() + (i + 1)) + " | ");
            for(int j = 0; j < prData.get(i) / 2; j++) {
                System.out.print("*");
            }
            System.out.print("\n");

            // The graph of the AVG data is created.
            System.out.print("AVG | Day: " + (fileData.size() + (i + 1)) + " | ");
            for(int k = 0; k < avg.get(i) / 2; k++) {
                System.out.print("=");
            }
            System.out.print("\n");
        }
    }

     private void writeToFile(char answer) {
        // If the passed char is 'Y', then the data is written to prediction.txt.
        if(answer == 'Y') {
            System.out.println("The predicted data has been saved to \"prediction.txt\"");
            file.writeData(fileData, lrData, prData, average());
        } else {
            System.out.println("The predicted data was not saved.");
        }
    }

    private void repeatPredict(char answer) {
        // If the passed char is 'Y', then the prediction model is ran again.
        if(answer == 'Y') {
            controller();
        } else {
            System.out.println("The prediction model has closed.");
        }
    }

    private boolean checkValidAmount() {
        // The method checks to see if the data has 5 or more data points to make a prediction.
        boolean validAmount = false;

        if(fileData.size() >= 5) {
            validAmount = true;
        }
        return validAmount;
    }
    // Getters and Setters

    public FileManager getFile() {
        return this.file;
    }

    public void setFile(FileManager file) {
        this.file = file;
    }
}
