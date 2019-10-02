// Future Features List
// * make sure number is at least 10 digits
// * format number when displayed (xxx) xxx-xxxx

import util.Input;

import java.util.HashMap;

public class ContactApplication {
    static Input keyboard = new Input();
    static HashMap<String, Contact> contactList = new HashMap<>();

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
        System.out.println("Name | Phone number");
        System.out.println("---------------");
        for (String key : contactList.keySet()) {
            System.out.println(contactList.get(key).getName() + " | " + contactList.get(key).getNumber());
        }
    }

    private static void addNewContact() {
        String newContactName = keyboard.getString("\nPlease enter the name of the new contact:");
        String newContactNumber = keyboard.getString("Please enter the phone number of the new contact:");
        Contact newContact = new Contact(newContactName, newContactNumber);
        contactList.put(newContact.getKey(), newContact);
        System.out.println(contactList.toString());
    }

    private static void searchContactName() {
        String searchName = keyboard.getString("Please enter the name of the contact you'd like to search for:").replace(" ", "").toLowerCase();
        if (contactList.containsKey(searchName)) {
            System.out.println(contactList.get(searchName).getName() + " | " + contactList.get(searchName).getNumber());
        } else {
            System.out.println("I'm sorry, I couldn't find that contact.");
        }
    }

    private static void deleteContact() {
        String deleteName = keyboard.getString("Please enter the name of the contact you'd like to delete:").replace(" ", "").toLowerCase();
        if (contactList.containsKey(deleteName)) {
            System.out.println("Deleting this contact...");
            contactList.remove(deleteName);
        } else {
            System.out.println("I'm sorry, I couldn't find that contact.");
        }
    }

}
