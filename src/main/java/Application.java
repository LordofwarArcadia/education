import base.OldPhone;
import base.Phone;
import base.PhoneIn;
import base.SmartPhone;

public class Application {

    public static void main(String[] args) {

        boolean b = true;
        boolean b2 = false;

        int i = 1;
        char c = 'a';
        byte bt;

        String hello = "Hello, Marina!";


        System.out.println(hello);

        System.out.println("int var: " + i);

        System.out.println(c);


        PhoneIn oldPhone = new OldPhone();
        PhoneIn ussrPhone = new Phone();
        PhoneIn smartPhone = new SmartPhone();
        SmartPhone smartPhone1 = new SmartPhone();
        SmartPhone iPhone = new SmartPhone("iOS");
        Phone smart = new SmartPhone();
        oldPhone.call();
        ussrPhone.call();
        smartPhone.call();

        String operator =  ((SmartPhone) smartPhone).operator;
        String OS =  ((SmartPhone) smartPhone).OS;
    }
}
