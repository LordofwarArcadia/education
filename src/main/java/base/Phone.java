package base;
                    // Полиморфизм (интерфейс, контракт) = возможность использовать
                    // разные способы реализации одного и того же (по имени) действия
                    // контракт (по сути) и есть определение списка имен
public class Phone implements PhoneIn {

    public String operator = "RosTelekom";

    public void call() {
        System.out.println("Набрать на крутилке номер");
    }
}
