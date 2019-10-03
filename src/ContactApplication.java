// Future Features List

// * warn user when they try to enter contact with existing name

// refactor to separate across more classes



import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactApplication {
    static Input keyboard = new Input();
    static HashMap<String, Contact> contactList = new HashMap<>();

    public static void main(String[] args) {

        // Read the data from the text file

        boolean userContinues;
        getData();

        do {
            userContinues = processMenuChoice(getMenuChoice());


        } while (userContinues);

        // Write the list to the text file
        writeData();
    }


    private static int getMenuChoice() {

        return keyboard.getInt("\n\n1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete a contact.\n" +
                "5. Edit a contact.\n" +
                "6. Exit.\n" +
                "\nEnter an option (1, 2, 3, 4, 5 or 6):", 1, 6);

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

                editContact();
                return true;
            case 6:

                return false;
            default:
                System.out.println("userChoice = " + userChoice);
                return true;
        }
    }


    public static void viewContacts() {

        // Source:  https://www.geeksforgeeks.org/sorting-hashmap-according-key-value-java/

        // TreeMap to store values of HashMap
        // TreeMap automatically sorts the entries by key  value.
        TreeMap<String, Contact> sortedContactList = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sortedContactList.putAll(contactList);

        // Display the TreeMap which is naturally sorted
        System.out.printf("%-25s | %s\n","Name","Number");
        System.out.println("------------------------------------------");
        for (Map.Entry<String, Contact> entry : sortedContactList.entrySet())
            // System.out.println(contactList.get(entry.getKey()).getTitleCase() + " | " + contactList.get(entry.getKey()).getFormattedNumber());

            System.out.printf("%-25s | %s\n",contactList.get(entry.getKey()).getName() , contactList.get(entry.getKey()).getFormattedNumber());
    }

    private static void addNewContact() {
        String newContactName = keyboard.getString("\nPlease enter the name of the new contact:");
        // Ask the user if they want the name in title case
        if (!newContactName.equals(getTitleCase(newContactName))) {
            if (keyboard.yesNo("Would you like to format the name to " + getTitleCase(newContactName) + "?")) {
                newContactName = getTitleCase(newContactName);
            }
        }

        String newContactNumber = keyboard.getString("Please enter the phone number of the new contact:");
        Contact newContact = new Contact(newContactName, newContactNumber);
        contactList.put(newContact.getKey(), newContact);
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

    private static void editContact() {
        String searchName = keyboard.getString("Please enter the name of the contact you'd like to edit:").replace(" ", "").toLowerCase();
        if (contactList.containsKey(searchName)) {
            if (keyboard.yesNo("Would you like to edit information for the following contact? [ y | n ]\n" + contactList.get(searchName).getName() + " | " + contactList.get(searchName).getNumber())) {
                int option = keyboard.getInt("\n1. Edit name\n" +
                        "2. Edit phone number.\n" +
                        "3. Return to Main Menu.\n" +
                        "\nEnter an option (1, 2 or 3):", 1, 3);
                switch (option) {
                    case 1:
                        contactList.get(searchName).setName(keyboard.getString("Enter the new name for the contact."));
                        break;
                    case 2:
                        contactList.get(searchName).setNumber(keyboard.getString("Enter the new number for the contact."));
                        break;
                    case 3:
                        break;
                }
            } else {
                System.out.println("Returning to the main menu.");
            }
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
        Path dataFile = Paths.get(directory, filename);
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

    private static String getTitleCase(String contactName) {
        String nameTitleCase = "";
        String[] nameTitleCaseArray = contactName.split(" ");
        for (String str : nameTitleCaseArray) {
            if (nameTitleCase.length() > 0) {
                nameTitleCase += " ";
            }
            nameTitleCase += str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }

        return nameTitleCase;
    }

}


