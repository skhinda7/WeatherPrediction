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
//	        #predict(): ArrayList<Double>
//
//*********************************************************

import java.util.ArrayList;

public class LinearRegression extends GenericPredictor {
    private double slope;
    private double intercept;

    public LinearRegression(ArrayList<Double> oldData) {
        super(oldData);
        slope = getSlope();
        intercept = getIntercept();
    }

    protected void train() {
        
        // The data is smoothened using moving average.
        smoothData = avg.movingAverage(oldData);

        double n = smoothData.size();
        double sigmaXY = 0;
        double sigmaX = 0;
        double sigmaY = 0;
        double sigmaXsquared = 0;

        // Variables are calculated that will be used to calculate the slope and intercept.
        for (int i = 0; i < n; i++) {
            sigmaXY += (i * smoothData.get(i)); // sigmaXY
            sigmaX += i;
            sigmaY += smoothData.get(i);
            sigmaXsquared += (Math.pow(i, 2));
        }
        // The slope is calculated.
        slope = ((n * sigmaXY) - (sigmaX * sigmaY)) / (n * sigmaXsquared - Math.pow(sigmaX, 2));
        // The intercept is calculated.
        intercept = (sigmaY - (slope * sigmaX)) / n;
    }

    public ArrayList<Double> predict() {
        train();
        int dayCount = smoothData.size();
        double data = 0;
        
        ArrayList<Double> predictedData = new ArrayList<Double>();

        for (int i = dayCount; i < dayCount + 10; i++) {
            // The following formula is created to calculate the predicted data: y = mx + b.
            data = (slope * i) + intercept;
            // Predicted data is added to an ArrayList.
            predictedData.add(super.smallDouble(data));
        }

        return predictedData;
    }
    // Getters and Setters

    public double getSlope() {
        return this.slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getIntercept() {
        return this.intercept;
    }

    public void setIntercept(double intercept) {
        this.intercept = intercept;
    }

}
