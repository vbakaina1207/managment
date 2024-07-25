import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management managementInstance = new Management();
        Management managementCodersbay = new Management();
        Address exampleAddress = new Address(4202, "Hellmonsödt", "SomeStreet", "1b");
        Address exampleAddress2 = new Address(4202, "Hellmonsödt", "SchoolStreet", "3");
        Address addressCodersbay = new Address(4020, "Linz", "Peter-Behrens-Platz", "4");
        Sex female = Sex.FEMALE;

        Scanner sc = new Scanner(System.in);
        String firstName = "";
        String lastName = "";
        int choose = -1;
        String chooseInput = "";

        while (choose != 4) {
            try {
                System.out.println("Choose what you want to do:");
                System.out.println("1. add person");
                System.out.println("2. remove person");
                System.out.println("3. print all persons");
                System.out.println("4. exit");
                choose = sc.nextInt();

                try {
                    sc.nextLine();

                    if (choose == 1) {
                        System.out.println("Enter your first name:");
                        firstName = sc.nextLine();
                        managementInstance.testName(firstName);

                        System.out.println("Enter your lastname:");
                        lastName = sc.nextLine();
                        managementInstance.testName(lastName);

                        managementInstance.createPerson(firstName, lastName, female, "2002-03-03", exampleAddress);
                        managementInstance.printListPerson();
                        choose = -1;
                    } else if (choose == 2) {
                        System.out.println("Enter your first name:");
                        firstName = sc.nextLine();
                        managementInstance.testName(firstName);

                        System.out.println("Enter your lastname:");
                        lastName = sc.nextLine();
                        managementInstance.testName(lastName);
                        managementInstance.removePerson(firstName, lastName);
                        managementInstance.printListPerson();
                        choose = -1;
                    } else if (choose == 3) {
                        managementInstance.printListPerson();
                        choose = -1;
                    } else if (choose == 4) {
                        System.out.println("Goodbye!");
                    } else {
                        System.out.println("Invalid input -> choose between 1 and 4");
                    }

                } catch (InvalidPersonName e) {
                    System.out.println(e.getMessage());
                    sc.next(); //consumes nextLine
                } catch (NullpointerException e) {
                    System.out.println("Nullpointer exception");
                    sc.next(); //consumes nextLine
                }

            } catch (Exception e) {
                System.out.println("Invalid input -> choose between 1 and 4");
                sc.next();
            }


        }

    }


    public static void testInput(String input) throws InvalidInputChoose {
        char[] nameChar = input.toLowerCase().toCharArray();
        for (char c : nameChar) {
            if ((int) c < 49 || (int) c > 52) {
                throw new InvalidInputChoose("The choose " + input + " mast be contain only number between 1 and 4");
            }
        }
    }
}
