package com.penelakut.soswedding;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("\nRunning BidAPI Test Cases...\n");
        Result bidResult = JUnitCore.runClasses(BidAPITest.class);
        if (bidResult.wasSuccessful()) {
            System.out.println("\u001B[32m" + "Bid test cases passed: " + bidResult.wasSuccessful() + "\u001B[0m" + '\n');
        } else {
            System.out.println("\u001B[31m" + "Bid test cases passed: " + bidResult.wasSuccessful() + "\u001B[0m" + '\n');
        }
         
        System.out.println("Running RequestAPI Test Cases...\n");
        Result requestResult = JUnitCore.runClasses(RequestAPITest.class);
        if (requestResult.wasSuccessful()) {
            System.out.println("\u001B[32m" + "Request cases passed: " + requestResult.wasSuccessful() + "\u001B[0m" + '\n');
        } else {
            System.out.println("\u001B[31m" + "Request cases passed: " + requestResult.wasSuccessful() + "\u001B[0m" + '\n');
        }
        

        System.out.println("Running ReviewAPI Test Cases...\n");
        Result reviewResult = JUnitCore.runClasses(ReviewAPITest.class);
        if(reviewResult.wasSuccessful()) {
            System.out.println("\u001B[32m" + "Review test cases passed: " + reviewResult.wasSuccessful() + "\u001B[0m" + '\n');
        } else {
            System.out.println("\u001B[31m" + "Review test cases passed: " + reviewResult.wasSuccessful() + "\u001B[0m" + '\n');
        }
        

        System.out.println("Running UserAPI Test Cases...\n");
        Result userResult = JUnitCore.runClasses(UserAPITest.class);     
        if(userResult.wasSuccessful()) {
            System.out.println("\u001B[32m" + "User test cases passed: " + userResult.wasSuccessful() + "\u001B[0m" + '\n');
        } else {
            System.out.println("\u001B[31m" + "User test cases passed: " + userResult.wasSuccessful() + "\u001B[0m" + '\n');
        }
        
    }
}
