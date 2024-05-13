package visite.project.controller;

public class Main {
    public static void main(String[] args) {
        Person person = Person.getBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(25)
                .build();
        System.out.println(person.toString());
    }
}
