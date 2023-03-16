public class Controller {

    public static void main(String[] args) {
        FileRead read = new FileRead();

        LinearRegression test = new LinearRegression();

        test.predict(read.earlyDataMin());
        test.predict(read.earlyDataMax());

    }
}
