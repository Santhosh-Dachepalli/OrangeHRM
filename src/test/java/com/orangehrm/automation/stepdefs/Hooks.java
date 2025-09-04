package com.orangehrm.automation.stepdefs;

import com.orangehrm.automation.base.BaseTest;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

public class Hooks {

    @BeforeAll
    public static void launchApplication() {
        BaseTest.setUp();   // Open driver ONCE
        System.out.println("🚀 Browser launched and OrangeHRM opened");
    }

    @AfterAll
    public static void closeApplication() {
        BaseTest.tearDown();   // Close driver ONCE after all features
        System.out.println("🛑 Browser closed");
    }
}
