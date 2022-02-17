package com.company;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args)
    {


        Timer timer1 = new Timer(); // Timer for updating User's data
        timer1.schedule(new TimerTask() {    // Creating Task and schedule for Timer
            User userT = new User(new MyScanner().getStack());  // create new User
            @Override
            public void run() {
                System.out.println("User " + userT.getName() + " is updated " +  LocalDateTime.now());
                userT.taskFunction(); // User function calling for update
                if (userT.getCounter() == 0) timer1.cancel(); // Stop Timer by condition
            }   // timestamps for data's updating every midnight
        }, 86400000 - LocalDateTime.now().toLocalTime().toSecondOfDay() * 1000L, 86400000);
    }
}
