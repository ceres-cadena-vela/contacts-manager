import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactApplicationIO {

    public static void getData( HashMap<String, Contact> contactList) {

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

    public static void writeData(HashMap<String, Contact> contactList) {

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
}
