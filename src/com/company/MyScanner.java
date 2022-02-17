package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyScanner {          //Class for User's input
    private Stack<String> stack;

    public MyScanner(){
        stack = new Stack<>(); // Stack consists of User's input
        setName();
        setExperience();
        setLevel();
        setStatus();
    }

    public Stack<String> getStack(){
        return stack;
    }

    public void setName() {
        boolean matches;
        StringBuilder nameInput;
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[A-Za-z]+([\\\\.-_]?[A-Za-z0-9]+)*"); // Pattern for username
        Matcher matcher;
        do {
            System.out.println("Enter User's name correctly: ");
            nameInput = new StringBuilder(sc.next());
            matcher = pattern.matcher(nameInput);
            matches = matcher.matches();

        } while (!matches);
        stack.push(String.valueOf(nameInput));

    }

    public void setExperience() {
        int exp;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Input User's experience: ");
            exp = sc.nextInt();
        } catch (java.util.InputMismatchException e) {exp = 0;} // set exp ZERO if input not INT value
        stack.push(String.valueOf(Math.max(exp, 0))); // set 'experience' Zero if input INT value. but less than ZERO
    }                                                 // pattern may be implemented there also

    public void setLevel() {
        int lev;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Input User's level: ");
            lev = sc.nextInt();
        } catch (java.util.InputMismatchException e) {lev = 0;} // set lev ZERO if input not INT value
        stack.push(String.valueOf(Math.max(lev, 0)));       // set 'level' Zero if input INT value. but less than ZERO
    }                                                       // pattern may be implemented there also

    public void setStatus() {
        String stat;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Input User's status - Paid or Free? : ");
            stat = sc.next();
        } catch (java.util.InputMismatchException e) {stat = "Free";} // set Free if exception

        if (stat.toLowerCase(Locale.ROOT).equals("paid")) { // Set Paid and call setCounter for value of paid days
            stack.push("Paid");
            setCounter();}
        else {
            stack.push("Free"); // if Free or something other then Set Free
            stack.push("3"); // for Free-status set 3 actions by default
        }

    }

    public void setCounter() {
        int count;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Input User's paided days: ");
            count = sc.nextInt();
        } catch (java.util.InputMismatchException e) {count = 10;}
        if (count < 0) stack.push("10");
        else  stack.push(String.valueOf(count));
    }

}
