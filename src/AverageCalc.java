//*********************************************************
// Class: AverageCalc
// Author: Simardeep Khinda
// Created: 03/22/2023
// Modified: 
//
// Purpose: AverageCalc is a class that uses methods to calculate the average of given arrays of doubles.   
//
// Attributes: 
//			-sum: double
//	        -average: double
// 
// Methods: +averageOfPrediction(ArrayList<double>, ArrayList<double>): ArrayList<double>
//	        +calcAverage(double, double): double
//          +averageOfList(ArrayList<double>): double
//
//*********************************************************

import java.util.ArrayList;

public class AverageCalc {
    ArrayList<Double> averageData = new ArrayList<Double>();

    public ArrayList<Double> averageOfPrediction(ArrayList<Double> lrData, ArrayList<Double> dmaData) {
        double dayAverage;

        for (int i = 0; i < lrData.size(); i++) {
            dayAverage = calcAverage(lrData.get(i), dmaData.get(i));
            averageData.add(dayAverage);
        }

        return averageData;
    }

    public double calcAverage(double dataOne, double dataTwo) {
        return (dataOne + dataTwo) / 2;
    }

    public double averageOfList(ArrayList<Double> data) {
        double dataSum = 0;
        for (int i = 0; i < data.size(); i++) {
            dataSum += data.get(i);
        }

        return (dataSum / data.size());
    }

    // Getters and Setters

    public ArrayList<Double> getAverageData() {
        return this.averageData;
    }

    public void setAverageData(ArrayList<Double> averageData) {
        this.averageData = averageData;
    }

}
