import java.util.ArrayList;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class PolynomialRegression extends GenericPredictor {
    private double[] coefficients;
    public PolynomialRegression(ArrayList<Double> oldData) {
        super(oldData);
    }

    protected void train() {
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < oldData.size(); i++) {
            points.add(i, oldData.get(i));
        }

        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3);
        coefficients = fitter.fit(points.toList());
    }


    protected ArrayList<Double> predict() {
        System.out.println("PR Data: " + oldData);
        train();
        ArrayList<Double> predictedData = new ArrayList<Double>();

        for (int i = oldData.size(); i < oldData.size() + 10; i++) {
            double data = coefficients[0] + coefficients[1] * i + coefficients[2] * Math.pow(i, 2);
            predictedData.add(super.smallDouble(data));
        }
        System.out.println("Polynomial: " + predictedData);

        return predictedData;
    }

}
