package app;

import java.util.ArrayList;

public class Messages {
    private String msg;
    private Contacts cc;

    private static ArrayList<Messages> messages = new ArrayList<Messages>();

    private Messages(Contacts cc, String msg) {
        this.cc = cc;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Contacts getCc() {
        return cc;
    }

    public static void showDetails(Messages msg) {
        System.out.print("\n");
        System.out.printf(
                """
                Sent to: [ContactIndex: %s] -> [Number: %d] -> [Name: %s] 
                Message: \"%s\"
                """, messages.indexOf(msg.cc), msg.cc.getNumber(), msg.cc.getName(), msg.getMsg());
    }

    public static void showAll() {
        if (messages.isEmpty()) {
            System.out.println("There aren't any messages!");
        } else {
            for (Messages msg : messages) {
                showDetails(msg);
            }
        }
    }

    public static void create(Contacts cc, String msg) {
        messages.add(new Messages(cc, msg));
    }
}
