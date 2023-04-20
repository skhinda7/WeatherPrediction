//*********************************************************
// Class: AverageCalc
// Author: Simardeep Khinda
// Created: 03/22/2023
// Modified: 
//
// Purpose: AverageCalc is a class that uses methods to calculate the average of given arrays of doubles.   
//
// Attributes: 
// 
// Methods: +averageOfPrediction(ArrayList<double>, ArrayList<double>): ArrayList<double>
//	        +calcAverage(double, double): double
//          +movingAverage(ArrayList<double>): ArrayList<double>): ArrayList<double>
//
//*********************************************************

import java.util.ArrayList;
import java.text.*;


public class AverageCalc {
    DecimalFormat df = new DecimalFormat("#.##");
    
    public ArrayList<Double> averageOfPrediction(ArrayList<Double> lrData, ArrayList<Double> prData) {
        ArrayList<Double> averageData = new ArrayList<Double>();

        double dayAverage;
        for (int i = 0; i < lrData.size(); i++) {
            dayAverage = calcAverage(lrData.get(i), prData.get(i));
            averageData.add(dayAverage);
        }

        return averageData;
    }

    public double calcAverage(double dataOne, double dataTwo) {
        return (dataOne + dataTwo) / 2;
    }

    public ArrayList<Double> movingAverage(ArrayList<Double> data) {
    ArrayList<Double> result = new ArrayList<>();
    double sum = 0;
    int windowSize = data.size() / 5;


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
