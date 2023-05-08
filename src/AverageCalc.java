//*********************************************************
// Class: AverageCalc
// Author: Simardeep Khinda
// Created: 03/22/2023
// Modified: 
//
// Purpose: AverageCalc is a class that uses methods to calculate the average of given arrays of doubles.   
//
// Attributes: -df: DecimalFormat
// 
// Methods: +averageOfPrediction(ArrayList<double>, ArrayList<double>): ArrayList<double>
//	        +calcAverage(double, double): double
//          +movingAverage(ArrayList<double>): ArrayList<double>): ArrayList<double>
//
//*********************************************************

import java.util.ArrayList;
import java.text.*;


public class AverageCalc {
    private DecimalFormat df = new DecimalFormat("#.##");
    
    public ArrayList<Double> averageOfPrediction(ArrayList<Double> lrData, ArrayList<Double> prData) {
        ArrayList<Double> averageData = new ArrayList<Double>();

        double dayAverage;
        for (int i = 0; i < lrData.size(); i++) {
            // An average is created between each respective element of LR and PR.
            dayAverage = calcAverage(lrData.get(i), prData.get(i));
            // The average is added to an ArrayList.
            averageData.add(Double.parseDouble(df.format(dayAverage)));
        }

        return averageData;
    }

    public double calcAverage(double dataOne, double dataTwo) {
        // An average is calculated between two double values.
        return (dataOne + dataTwo) / 2;
    }

    public ArrayList<Double> movingAverage(ArrayList<Double> data) {
        ArrayList<Double> result = new ArrayList<>();
        double sum = 0;
        // Window size is calculated by taking the length of the data and creating windows of 5.
        int windowSize = data.size() / 5;
        // Moving average is calculated and added to a new ArrayList.
        for (int i = 0; i < data.size(); i++) {
            if (i >= windowSize) {
                sum -= data.get(i - windowSize);
            }
            sum += data.get(i);
            if (i >= windowSize - 1) {
                double currentMA = Double.parseDouble(df.format(sum / windowSize));
                result.add(currentMA);
            }
        }
        return result;
    }

}
