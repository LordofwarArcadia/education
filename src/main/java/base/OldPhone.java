package base;

public class OldPhone implements PhoneIn {

    public String manufacturer = "Ericsson";

    public String operator = "Барышня!";

    public void call() {
        System.out.println("Крутим ручку!");
        System.out.println("Барышня, соедините со Смольным!");
    }
}
