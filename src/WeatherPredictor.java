import java.util.Scanner;
// Hello World
public class WeatherPredictor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the last 5 days' maximum and minimum temperatures from the user
        double[] maxTemperatures = new double[5];
        double[] minTemperatures = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the maximum temperature for day " + (i + 1) + ": ");
            maxTemperatures[i] = scanner.nextDouble();
            System.out.print("Enter the minimum temperature for day " + (i + 1) + ": ");
            minTemperatures[i] = scanner.nextDouble();
        }

        // Use linear regression to predict the next 10 days' maximum and minimum
        // temperatures
        double[] predictedMaxTemperatures = predict(maxTemperatures);
        double[] predictedMinTemperatures = predict(minTemperatures);

        // Print the predicted temperatures for the next 10 days
        System.out.println("Predicted temperatures for the next 10 days:");
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    "Day " + (i + 1) + ": max=" + predictedMaxTemperatures[i] + ", min=" + predictedMinTemperatures[i]);
        }
    }

    // Method to predict the next 10 days' temperatures using linear regression
    public static double[] predict(double[] temperatures) {
        int n = temperatures.length;
        double[] predictedTemperatures = new double[10];

        // Compute the slope and intercept of the regression line using the last 5 days'
        // temperatures
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;
        for (int i = 0; i < n; i++) {
            sumX += i + 1;
            sumY += temperatures[i];
            sumXY += (i + 1) * temperatures[i];
            sumX2 += (i + 1) * (i + 1);
        }
        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        // Predict the next 10 days' temperatures using the regression line
        for (int i = 0; i < 10; i++) {
            predictedTemperatures[i] = slope * (n + i + 1) + intercept;
        }
        return predictedTemperatures;
    }
}
