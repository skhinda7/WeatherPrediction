import java.text.*;

public class testLinear {
    public double[] earlyData = { 10.4, 8.7, 7.3, 5.4, 1, 34, 54, 64, 6, 10.5, 2, 4, 5, 2 };

    // x is the day, y is the temperature.
    public static void main(String[] args) {
        testLinear test = new testLinear();

        test.predict();
    }

    public void predict() {
        DecimalFormat df = new DecimalFormat("#.##");
        double length = earlyData.length;
        double[] xSquared = new double[(int) length];
        double[] ySquared = new double[(int) length];
        double[] productXY = new double[(int) length];
        double sigmaX = 0;
        double sigmaY = 0;
        double sigmaXY = 0;
        double sigmaXSquared = 0;
        double slope = 0;
        double intercept = 0;
        double[] predictedData = new double[(int) length];

        for (int i = 0; i < earlyData.length; i++) {
            xSquared[i] = Math.pow((i + 1), 2);
            // 1, 4, 9, 16, 25
            ySquared[i] = Math.pow(earlyData[i], 2);
            // 4.84, 12.96, 42.25, 53.29, 94.09
            productXY[i] = (i + 1) * earlyData[i];
            // 2.2, 7.2, 19.5, 29.2, 48.5
            sigmaX += (i + 1);
            // 15
            sigmaY += earlyData[i];
            // 29.3
            sigmaXY += productXY[i];
            // 106.6
            sigmaXSquared += xSquared[i];
            // 55
        }

        System.out.println(sigmaX);
        System.out.println(sigmaY);
        System.out.println(sigmaXY);
        System.out.println(sigmaXSquared);

        slope = (((length * sigmaXY) - (sigmaX * sigmaY)) / ((length * sigmaXSquared) - (Math.pow(sigmaX, 2))));
        System.out.println("Slope: " + slope);

        intercept = ((sigmaY - (slope * sigmaX)) / length);
        System.out.println("Intercept: " + intercept);

        for (int i = 0; i < earlyData.length; i++) {
            int newDay = (i + 5);
            predictedData[i] = (slope * newDay) + intercept;
            System.out.println("Predicted Temperature for Day #" + newDay + " is: " + df.format(predictedData[i]));
        }

    }
    // This is also a test.

}
