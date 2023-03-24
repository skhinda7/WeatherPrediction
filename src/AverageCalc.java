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
// Methods: -calculateAverage(double[], double[]): double[]
//
//*********************************************************

public class AverageCalc {
    private double sum;
    private double[] average;

    private double[] calculateAverage(double[] LRData, double[] DMData) {
        double dataSum;
        average = new double[LRData.length];

        for (int i = 0; i < LRData.length; i++) {
            dataSum = LRData[i] + DMData[i];

            average[i] = dataSum / 2;
        }

        return average;
    }

    // Getters and Setters
    public double getSum() {
        return this.sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double[] getAverage() {
        return this.average;
    }

    public void setAverage(double[] average) {
        this.average = average;
    }
}
