// Future Features List

// * make sure number is either 7 or 10 digits

// * alphabetize contacts
// * format contact name for consistency


// * warn user when they try to enter contact with existing name
// * format display list so that columns have equal width
// * menu option where user can edit a contact


import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactApplication {
    static Input keyboard = new Input();
    static HashMap<String, Contact> contactList = new HashMap<>();

    public static void main(String[] args) {

        // Read the data from the text file

        boolean userContinues = true;
        getData();

        do {
            userContinues = processMenuChoice(getMenuChoice());


        } while (userContinues);

        // Write the list to the text file
        writeData();
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
            System.out.println(contactList.get(key).getName() + " | " + contactList.get(key).getFormattedNumber());
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

    private static void getData() {

        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Contact tempContact;
        String name;
        String number;

        if (!Files.exists(dataDirectory)) {

            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
//
        }

        if (!Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(dataFile);
            for (String line : lines) {
                name = line.substring(0, line.indexOf(',')).trim();
                number = line.substring(line.indexOf(',') + 1).trim();
                tempContact = new Contact(name, number);
                contactList.put(tempContact.getKey(), tempContact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeData() {

        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        Contact tempContact;
        String name;
        String number;
        String line;


        List<String> contacts = new ArrayList<>();
        // Build the array list from the hash map

        for (String key : contactList.keySet()) {
            name = contactList.get(key).getName();
            number = contactList.get(key).getNumber();
            line = name + ", " + number;
            contacts.add(line);
        }

        try {
            Files.write(dataFile, contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


