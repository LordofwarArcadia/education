package dayfore.reflection;

@SomeAnnotation(value = "Test")
public class Client {

    @SomeAnnotation(someVal = "TestVal", value = "Test")
    private String name;

    @SomeAnnotation("Test")
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Name should not be null or empty");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new RuntimeException("Last Name should not be null or empty");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
