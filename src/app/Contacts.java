package app;

import java.util.ArrayList;

public class Contacts {
    private final String name;
    private final long number;

    private static final ArrayList<Contacts> contacts = new ArrayList<Contacts>();


    private Contacts(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Contacts> getContacts() {
        return contacts;
    }

    public long getNumber() {
        return number;
    }

    public static void showDetails(Contacts cc) {
        System.out.printf("\n[Index: %s] -> [Number: %d] -> [Name: %s]",
                contacts.indexOf(cc), cc.number, cc.name);
    }


    
    public static Contacts select(int index) {
        try {
            return contacts.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oh no! Contact index is missing..");
        }
        return null;
    }

    public static void create(String name, long number) {
        contacts.add(new Contacts(name.toLowerCase(), number));
        System.out.println("Contact Added.");
    }

    public static void showAll() {
        if (contacts.isEmpty()) {
            System.out.println("There aren't any contacts!");
        } else {
            for (Contacts cc : contacts) {
                showDetails(cc);
            }
        }
    }

    public static void query(String input) {
        int resultCount = 0;
        for (Contacts cc : contacts) {
            if (cc.name.contains(input.toLowerCase())
                    || Long.toString(cc.number).contains(input)) {
                showDetails(cc);
                resultCount++;
            }
        }
        System.out.println("\n");
        if (resultCount > 0) {
            System.out.printf("Results found: %d", resultCount);
        } else {
            System.out.println("Sorry, query is not found");
        }
    }

    public static void remove(int index) {
        Contacts cc = contacts.get(index);
        System.out.print("\nDeleted: ");
        showDetails(cc);
        contacts.remove(index);
    }
}
