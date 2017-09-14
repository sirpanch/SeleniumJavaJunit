
package com.dpsolution.Tests;

import com.dpsolution.Pages.*;
import org.junit.Test;
import org.openqa.selenium.InvalidElementStateException;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import com.github.javafaker.Faker;

import static org.junit.Assert.*;

public class DpRegistrationTest extends TestBase {
    String baseUrl = "http://85.93.17.135:9000/user/new";

    @Test
    public void registerAUserSuccessfully() throws InvalidElementStateException {
        Map<String, String> userData = new HashMap<String, String>();
        DpRegistration registration = new DpRegistration(driver);
        registration.visitPage(baseUrl);
        userData = registration.getDefaultUserData();
        registration.userRegistration(userData);
        assertTrue(registration.userRegistered());
    }

    @Test
    public void registerAUserWithDuplicateName() throws InvalidElementStateException {
        Map<String, String> userData;
        DpRegistration registration = new DpRegistration(driver);
        registration.visitPage(baseUrl);
        userData = registration.getDefaultUserData();
        registration.userRegistration(userData);
        assertTrue(registration.userRegistered());
        registration.selectNewUser();
        registration.userRegistration(userData);
        String nameErrorMessage = registration.getNameError();
        assertTrue(nameErrorMessage.contains("Must be unique"));

        String nameEmailMessage = registration.getEmailError();
        assertTrue(nameEmailMessage.contains("Must be unique"));


    }


}