public class Person{

    private String firstName;
    private String lastName;
    private Sex sex;
    private String dob;
    private Address address ;

    public Person (String firstName, String lastName, Sex sex, String dob, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dob = dob;
        this.address = address;
    }

    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person (String firstName, String lastName, Sex sex, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dob = dob;
    }

    public String getFirstName(){
        return  firstName;
    }

    public String getLastName(){

        return  lastName;
    }

    public String getDob(){

        return  dob;
    }


}

