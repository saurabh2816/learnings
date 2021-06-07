public class Google {

    public static void main(String[] args) {

        // myLambda is providing an implementation of the interface function: foo()
        PaymentService myLambda = () -> System.out.println("This is a lambda fx");
        myLambda.pay();

        // how we usually do it
        PaymentService payObject = new PaymentServiceImpl();
        payObject.pay();

    }
}

interface lambdaInterface {
    void foo();
}