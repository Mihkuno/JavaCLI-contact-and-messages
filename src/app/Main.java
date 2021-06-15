package app;

import tools.Selector;

public class Main {

    private static boolean start = true;

    public static void main(String[] args) {
        do { showOptions(); } while (start);
    }

    private static void showOptions() {
        System.out.println("\nHello There! Please select a number");
        System.out.println("""
                1. Manage contacts
                2. Messages
                3. Quit""");

        System.out.print("> ");
        int input = Selector.selectorIntLine();

        switch(input) {
            case (1) -> manageContacts();
            case (2) -> viewMessages();
            case (3) -> quitApplication();
        }
    }

    private static void manageContacts() {
        boolean repeat = true;
        do {
            System.out.print("\n");
            System.out.println("""
                    1. Show all contacts
                    2. Add a new contact
                    3. Search for a contact
                    4. Delete a contact
                    5. Go back to the previous menu""");

            System.out.print("> ");
            int input = Selector.selectorIntLine();

            switch (input) {
                case (1) -> {
                    // Show all contacts
                    Contacts.showAll();
                }
                case (2) -> {
                    // Add new contact
                    System.out.print("Input contact name: ");
                    String name = Selector.selectorAlphaLine();
                    System.out.print("Input contact number: ");
                    long number = Selector.queryNumLine();
                    Contacts.create(name, number);
                }
                case (3) -> {
                    // Search for keyword in a contact
                    System.out.print("Input keyword to query: ");
                    String in = Selector.selectorAlphaLine();
                    Contacts.query(in);
                }
                case (4) -> {
                    // Delete a contact
                    System.out.print("Input index: ");
                    int del = Selector.selectorIntLine();
                    Contacts.remove(del);
                }
                case (5) -> repeat = false;
            }
            System.out.print("\n");
        } while (repeat);
    }

    private static void viewMessages() {

        boolean repeat = true;
        do {
            System.out.print("\n");
            System.out.println("""
                    1. See the list of all messages
                    2. Send a new message
                    3. Go back the the previous menu""");

            System.out.print("> ");
            int input = Selector.selectorIntLine();

            switch (input) {
                case (1) -> {
                    // Show all messages
                    Messages.showAll();
                }
                case (2) -> {
                    // Send a new message
                    if (Contacts.getContacts().isEmpty()) {
                        System.out.println("Your contacts are empty.");
                    } else {
                        System.out.print("Select contact index: ");
                        int in = Selector.selectorIntLine();
                        Contacts cc = Contacts.select(in);
                        if (cc == null) {
                            continue;
                        } else {
                            System.out.print("Write message: ");
                            String msg = Selector.queryLine();
                            Messages.create(cc, msg);
                        }
                    }
                }
                case (3) -> repeat = false;
            }
        } while (repeat);
    }

    private static void quitApplication() {
        System.out.println("Application Terminated Successfully");
        start = false;
    }
}
