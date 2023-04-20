//*********************************************************
// Class: PolynomialRegression 
// Author: Simardeep Khinda
// Created: 04/10/2023
// Modified: 
//
// Purpose: This class uses Polynomial Regression to predict the next 10 days of data. It is similar to linear regression but the prediction line is not linear, it is a curve.
// Attributes: 
//			-coefficients: double[]
//          #oldData: ArrayList<double>
// 
// Methods: #train(): void
//	        #predict(): ArrayList<Double>
//
//*********************************************************

import java.util.ArrayList;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class PolynomialRegression extends GenericPredictor {
    private double[] coefficients;
    
    public PolynomialRegression(ArrayList<Double> oldData) {
        super(oldData);
    }

    protected void train() {

        smoothData = avg.movingAverage(oldData);
        
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < smoothData.size(); i++) {
            points.add(i, smoothData.get(i));
        }

        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2);
        coefficients = fitter.fit(points.toList());
    }


    protected ArrayList<Double> predict() {
        
        train();
        
        int dayCount = smoothData.size();
        
        ArrayList<Double> predictedData = new ArrayList<Double>();
                
        for (int i = dayCount; i < dayCount + 10; i++) {
            double data = coefficients[0] + coefficients[1] * i + coefficients[2] * Math.pow(i, 2);
            predictedData.add(super.smallDouble(data));
        }

        return predictedData;
    }

    
    // Getters and Setters
    public double[] getCoefficients() {
        return this.coefficients;
    }

    public void setCoefficients(double[] coefficients) {
        this.coefficients = coefficients;
    }

}