//*********************************************************
// Class: LinearRegression 
// Author: Simardeep Khinda
// Created: 03/21/2023
// Modified: 
//
// Purpose: LinearRegression uses linear regression to predict the weather data for the future. 
// Attributes: 
//			-slope: double
//          -intercept: double
// 
// Methods: #train(): void
//	        #predict(): double[]
//
//*********************************************************

import java.text.*;

public class LinearRegression extends GenericPredictor {

    private double slope;
    private double intercept;
    DecimalFormat df = new DecimalFormat("#.##");

    protected void train() {

    }

    public double[] predict(double[] earlyData) {

        return predictedData;

    }

}
