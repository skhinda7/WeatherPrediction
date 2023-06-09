//*********************************************************
// Class: GenericPredictor
// Author: Simardeep Khinda
// Created: 03/21/2023
// Modified:
//
// Purpose: GenericPredictor is used as a base class for other prediction models. It is not called.
// Attributes: 
//			#oldData: ArrayList<Double>
//          #smoothData: ArrayList<Double>
// 
// Methods: #train(): void
//	        #predict(): ArrayList<Double>
//          #smallDouble(double): double
//
//*********************************************************

import java.util.ArrayList;
import java.text.*;

public class GenericPredictor {
    protected ArrayList<Double> oldData = new ArrayList<Double>();
    protected ArrayList<Double> smoothData = new ArrayList<Double>();
    protected AverageCalc avg = new AverageCalc();
    private DecimalFormat df = new DecimalFormat("#.##");


    public GenericPredictor(ArrayList<Double> oldData) {
        this.oldData = oldData;
    }

    // The train() method is initialized.
    protected void train() {

    }

    // The predict() method is initialized.
    protected ArrayList<Double> predict() {
        ArrayList<Double> predictedData = new ArrayList<Double>();

        return predictedData;
    }

    // This method returns a double with only two decimal places from the passed double value.
    protected double smallDouble(double data) {
        return Double.parseDouble(df.format(data));
    }

    // Getters and Setters

    public ArrayList<Double> getOldData() {
        return this.oldData;
    }

    public void setOldData(ArrayList<Double> oldData) {
        this.oldData = oldData;
    }

}
