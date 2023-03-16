public class Controller {

    public static void main(String[] args) {
        FileRead read = new FileRead();

        GenericPredictor test = new GenericPredictor();
        
        test.predict(read.earlyDataMin());
        test.predict(read.earlyDataMax());

    }
}
