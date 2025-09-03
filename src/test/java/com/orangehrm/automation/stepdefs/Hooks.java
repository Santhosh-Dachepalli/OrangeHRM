package com.orangehrm.automation.stepdefs;

import com.orangehrm.automation.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {

    @Before
    public void launchApplication() {
        setUp();
        System.out.println("🚀 Browser launched and OrangeHRM opened");
    }

    @After
    public void closeApplication() {
        tearDown();
        System.out.println("🛑 Browser closed");
    }
}
