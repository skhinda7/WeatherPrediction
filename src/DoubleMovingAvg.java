public class DoubleMovingAvg {
    public void predict() {
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
    }
}
