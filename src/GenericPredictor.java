//*********************************************************
// Class: GenericPredictor
// Author: Simardeep Khinda
// Created: 03/21/2023
// Modified: 
//
// Purpose: GenericPredictor is used as a base class for other prediction models. It is not called.
// Attributes: 
//			#oldData: ArrayList<Double>
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
    DecimalFormat df = new DecimalFormat("#.##");


    public GenericPredictor(ArrayList<Double> oldData) {
        this.oldData = oldData;
    }

    protected void train() {

    }

    protected ArrayList<Double> predict() {
        ArrayList<Double> predictedData = new ArrayList<Double>();

        return predictedData;
    }

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
