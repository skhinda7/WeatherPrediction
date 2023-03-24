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

    protected void train() {

    }

    protected double[] predict() {
        return predictedData;
    }

}
