//*********************************************************
// Class: DoubleMovingAvg 
// Author: Simardeep Khinda
// Created: 03/21/2023
// Modified: 
//
// Purpose: DoubleMovingAvg class uses double moving average to predict the weather data for the upcoming days.
//
// Attributes: 
//			-maOne: double
//          -maTwo: double
// 
// Methods: #train(): void
//          #predict(): double[]
//
//*********************************************************

public class DoubleMovingAvg extends GenericPredictor {
    private double maOne;
    private double maTwo;

    protected void train() {

    }

    protected double[] predict() {
        double[] temp = { 55, 55, 51, 59, 44, 45, 55, 58, 60, 52 };
        double[] movingAverage = new double[temp.length];

        int windowSize = 2;

        for (int i = 0; i < temp.length; i++) {
            double sum = 0;
            for (int j = i; j < i + windowSize; j++) {
                sum += temp[j];
            }
            movingAverage[i] = sum / windowSize;
            System.out.println("Day " + (i + 1) + ": " + movingAverage[i]);
        }

        return predictedData;
    }
}
