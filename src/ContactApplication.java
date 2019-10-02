import util.Input;

public class ContactApplication {
   static Input keyboard = new Input();

    public static void main(String[] args) {

        System.out.println(getMenuChoice());

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

        return keyboard.getInt("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):", 1, 5);

    }
}
