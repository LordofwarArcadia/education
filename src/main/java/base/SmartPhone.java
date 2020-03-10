package base;
                        // наследование = возможность совершить "эволюцию" от класса к классу
public class SmartPhone extends Phone {

    public String OS = "Android";

    public SmartPhone(String OS) {
        this.OS = OS;
    }

    public SmartPhone(){

    }

    private void prepareConnection(){}

    private void connectToMobileOperator(){}

    private void sendOurDescriptor(){};

    private void sendAbonentDescriptor(){};

    private void establishPhoneCall(){};

    //Переопределение = возможность изменить поведение
    // описанное в родительском классе
    @Override
    public void call() {
        System.out.println("Натапать на экране номер");

        //Инкапсюляция = сокрытие реализации от внешних пользователей
        prepareConnection();

        connectToMobileOperator();

        sendOurDescriptor();

        sendAbonentDescriptor();

        establishPhoneCall();
    }
}
