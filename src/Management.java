import java.util.ArrayList;
import java.util.List;

public class Management {
    private final List<Person> listPerson;

    public Management () {
        listPerson = new ArrayList<>();
    }

    public void createPerson(String firstName, String lastName) throws InvalidPersonName {
        try{
            testName(firstName);
            testName(lastName);
            Person person = new Person(firstName, lastName);
            if (findPerson(firstName, lastName) == null)
                listPerson.add(person);
            else
                System.out.println("The person already exists");
    }   catch (InvalidPersonName e){
            System.out.println(e.getMessage());
        }
    }

    public void createPerson (String firstName, String lastName, Sex sex, String dob) throws InvalidPersonName {
        try {
            testName(firstName);
            testName(lastName);
            Person person = new Person(firstName, lastName, sex, dob);
            if (findPerson(firstName, lastName, dob) == null)
                listPerson.add(person);
            else
                System.out.println("The person " + person.getFirstName() + " " + person.getLastName() + " " + person.getDob() + " already exists");
            }
        catch (InvalidPersonName e){
            System.out.println(e.getMessage());
        }
    }

    public void testName(String name) throws InvalidPersonName {
        char[] nameChar = name.toLowerCase().toCharArray();
        for (char c : nameChar) {
            if ((int) c < 61 || (int) c > 122) {
                throw new InvalidPersonName("The name " + name + " mast be contain only characters");
            }
        }
    }
    public void createPerson (String firstName, String lastName, Sex sex, String dob, Address address) throws InvalidPersonName {
        try {
            testName(firstName);
            testName(lastName);
            Person person = new Person(firstName, lastName, sex, dob, address);
            if (findPerson(firstName, lastName, dob) == null)
                listPerson.add(person);
            else {
                throw  new  NullpointerException("The person already exists");
            }
        }
        catch (InvalidPersonName | NullpointerException e){
            System.out.println(e.getMessage());
        }

    }

    private Person findPerson (String firstName, String lastName, String dob){
        for(Person person: listPerson) {
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName) && person.getDob().equals(dob))
                return  person;
        }
        return null;
    }

    private Person findPerson (String firstName, String lastName) {
        for(Person person: listPerson) {
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                return  person;
        }
        return null;
    }
    public void removePerson (String firstName, String lastName) throws InvalidPersonName, NullpointerException {
        try {
            testName(firstName);
            testName(lastName);
            try {
                Person person = findPerson(firstName, lastName);
                if (person != null)
                    listPerson.remove(person);
                else
                    throw new NullpointerException("Person not found");
            }
            catch (NullpointerException e) {
                System.out.println(e.getMessage());
            }
        }
        catch (InvalidPersonName e) {
            System.out.println(e.getMessage());
        }
    }

    public void printListPerson() {
        for (Person person :  listPerson){
            System.out.println(person.getFirstName()+ " " + person.getLastName());
        }
    }
}
