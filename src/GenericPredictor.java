//*********************************************************
// Class: GenericPredictor
// Author: Simardeep Khinda
// Created: 03/21/2023
// Modified: 
//
// Purpose: GenericPredictor is used as a base class for other prediction models. It is not called.
// Attributes: 
//			#inputData: double[]
//	        #predictedData: double[]
// 
// Methods: #train(): void
//	        #predict(): double[]
//
//*********************************************************

public class GenericPredictor {
    protected double[] inputData;
    protected double[] predictedData;

    public GenericPredictor(double[] inputData, double[] predictedData) {
        this.inputData = inputData;
        this.predictedData = predictedData;
    }

    protected void train() {

    }

    protected double[] predict() {
        return predictedData;
    }

    // Getters and Setters

    public double[] getInputData() {
        return this.inputData;
    }

    public void setInputData(double[] inputData) {
        this.inputData = inputData;
    }

    public double[] getPredictedData() {
        return this.predictedData;
    }

    public void setPredictedData(double[] predictedData) {
        this.predictedData = predictedData;
    }

}
