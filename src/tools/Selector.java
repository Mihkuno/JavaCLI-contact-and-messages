package tools;

import java.util.Scanner;

public class Selector {
    public static int selectorIntLine() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int inputInt = 0;
        try {
            inputInt = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            System.out.println ("Selected index must be an integer");
            e.printStackTrace();
        }
        return inputInt;
    }

    public static long queryNumLine() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        long inputLong = 0;
        try {
            inputLong = Long.parseLong(input);

        } catch (NumberFormatException e) {
            System.out.println ("Selected index must be a integer");
            e.printStackTrace();
        }
        return inputLong;
    }

    public static String queryLine() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static String selectorAlphaLine() {
        String input = "";
        try {
            Scanner in = new  Scanner(System.in);
            input = in.nextLine();
            if(input.matches(".*\\d.*")){
                System.out.println("AlphaLine must not contain a Number!");
            } else{
                return input;
            }

        } catch (Exception e) {
            System.out.println("selectAlpha Selector error has occurred");
            e.printStackTrace();
        }
        return input;
    }
}
