package visite.project.controller;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private Person(PersonBuilder personBuilder) {
        this.firstName = personBuilder.getFirstName();
        this.lastName = personBuilder.getLastName();
        this.age = personBuilder.getAge();
    }

    public static PersonBuilder getBuilder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private int age;

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public Person build() {
            return new Person(this);
        }
    }
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
