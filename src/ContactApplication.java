import util.Input;

public class ContactApplication {
    static Input keyboard = new Input();

    public static void main(String[] args) {

        boolean userContinues = true;


        do {
            userContinues = processMenuChoice(getMenuChoice());


        } while (userContinues);


    }

    // displayMenu // Print menu screen, return an int representing the user's option
    // processUserChoice ||  takes in an int rep. user option, processes with a switch statement
    // 1. View contacts.
    // 2. Add a new contact.
    // 3. Search a contact by name.
    // 4. Delete an existing contact.
    // 5. Exit. // set looping variable equal to false
    // Write to text file upon exiting application

    private static int getMenuChoice() {

        return keyboard.getInt("\n\n1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):", 1, 5);

    }

    private static boolean processMenuChoice(int userChoice) {
        switch (userChoice) {

            case 1:

                viewContacts();
                return true;
            case 2:

                addNewContact();
                return true;
            case 3:

                searchContactName();
                return true;
            case 4:

                deleteContact();
                return true;
            case 5:

                return false;
            default:
                System.out.println("userChoice = " + userChoice);
                return true;
        }
    }

    private static void viewContacts() {
        System.out.println("viewContacts");
    }

    private static void addNewContact() {
        System.out.println("addNewContact");
    }

    private static void searchContactName() {
        System.out.println("searchContactName");

    }

    private static void deleteContact() {
        System.out.println("deleteContact");
    }

}
