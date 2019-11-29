package com.penelakut.soswedding;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {
        Result bidResult = JUnitCore.runClasses(BidAPITest.class);
        Result requestResult = JUnitCore.runClasses(RequestAPITest.class);
        Result reviewResult = JUnitCore.runClasses(ReviewAPITest.class);
        Result userResult = JUnitCore.runClasses(UserAPITest.class);

        System.out.println("Bid test cases passed: " + bidResult.wasSuccessful());
        System.out.println("Request cases passed: " + requestResult.wasSuccessful());
        System.out.println("Review test cases passed: " + reviewResult.wasSuccessful());
        System.out.println("User test cases passed: " + userResult.wasSuccessful());
    }
}
