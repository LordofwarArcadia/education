package dayfive;

import dayfore.DayFour;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {

    private static List<DayFour.User> users;

    private static List<Event> events;

    private static List<DayFour.User> tickets;

    public static void main(String[] args) throws Exception {

        // тернарные (унарные) операторы
        // эксепшены

        int expected = 0;

        int score = new Random().nextInt(100);

        if (score > 50) {
            expected += score * 1.25;
        } else if (score == 0) {
            throwCheckedException();
        } else {
            expected += score;
        }

        expected += score > 50 ? score * 1.25 : score;

        //unchecked as test assertion
        String expectedName = "some-name0";

        String actualName = "some-name" + new Random().nextInt(3);

        if(!expectedName.equals(actualName)){
            throw new RuntimeException("Actual name differs from the Expected name");
        }

        try {
            someMethodFromOtherTeamGeneratesToken();
        } catch (Exception e){
            // transform checked to unchecked
            throw new RuntimeException(e);
        }
    }

    public static void throwCheckedException() throws Exception {
        throw new Exception();
    }

    public static void someMethodFromOtherTeamGeneratesToken() throws Exception{
        throw new Exception();
    }


    //region checked exception example
    public static class Class1UIElements {

        public static void main(String[] args) {
            new Class1UIElements().drawUI();
            if (true) {
                new Class1UIElements().readFileByClickButton();
            }
        }

        public void readFileByClickButton() {
            try {
                new Class2().readFile();
            } catch (IOException e) {
                System.out.println("User ty dolbaeb, imya faila nevernoe. Protri glaza sssuka");
            }
        }

        public void drawUI() {

        }
    }

    public static class Class2 {

        public void readFile() throws IOException {
            new Class3().readFileByName();
        }
    }

    public static class Class3 {

        public void readFileByName() throws IOException {
            new Class4().readFileInFileSystem();
        }
    }

    public static class Class4 {

        public void readFileInFileSystem() throws IOException {
            if (true) { //file not found

                throw new IOException();

            }
        }
    }
    //endregion

    //region example
    private static void createEvent() {
        // read event fields:
        // read id
        // read title
        // read date time
        // events.add(event);
        int lastId = events.stream().map(e -> e.id).max(Integer::compareTo).get();
        int id = lastId + 1;

        Event event = new Event();
        event.id = id;
        String tmp = new Scanner(System.in).nextLine();
        if (tmp.isEmpty()) {
        }
        event.title = tmp;

        events.add(event);

    }

    private static void createUser() {
        // read event fields:
        // read id
        // read phone
        // check phone exists (unique phone constraint)
        String tmpPhone = new Scanner(System.in).nextLine();
        //if(!checkPhoneIsUnique(tmpPhone)){
        //    System.out.println("Not unique");
        //    return;
        //}
        // read fio
        // events.add(event);
    }

    private static void createTicket() {
        // read ticket fields:
        // read event id
        // check exist
        // check expiration
        // read user id
        // check exist
        // read seat
        // check availability - get list of tickets for selected event (filter(e -> e.eventId==eventId))
        // => if seat exists => return error message
        // filter(t -> t.eventId == eventId && t.seat == seat).findFirst() => Optional<Ticket>
        // => if optional.isPresent()=> show error message
        // anyMatch(t -> t.eventId == eventId && t.seat == seat) => if true => show error message
        // tickets.add(ticket);

    }

    private static void notifyUser() {

    }

    private static void removeExpired() {

    }

    private static class Event {

        public int id;

        public String title;
    }
    //endregion
}
