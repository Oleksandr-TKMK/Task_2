package com.company;

import java.util.Locale;
import java.util.Stack;

// Class to create new User
public class User {
    private Stack<String> stack;
    private int counter; // count days for paid user OR actions for free user
    private String status; // Paid or Free status
    private String name; // Username
    private int level; // User level
    private int experience; // User experience

    public String getName() {
        return this.name;
    }
    public int getExperience(){ return this.experience; }
    public int getLevel(){ return this.level; }
    public String getStatus(){ return this.status; }
    public  int getCounter() { return this.counter; }

    public User (Stack<String> stack) { // Constructor for class User
        this.stack = stack;
        counter = Integer.parseInt(stack.pop());
        status = stack.pop();
        level = Integer.parseInt(stack.pop());
        experience = Integer.parseInt(stack.pop());
        name = stack.pop();


    }

    public void taskFunction() // function for updating User's data
    {
        if (experience >= 500)
        {
            level += (experience - (experience % 500)) / 500; // 500 experience == 1 level
            experience = experience % 500; // experience = remainder of division by 500
        }

        if (status.toLowerCase(Locale.ROOT).equals("free")) {if (counter < 3) counter = 3;} // update free actions
        else if (--counter == 0) System.out.println("Subscription expired"); // update paid days
    }

}
