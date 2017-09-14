
package com.dpsolution.Tests;

import com.dpsolution.Pages.*;
import org.junit.Test;
import org.openqa.selenium.InvalidElementStateException;
import static org.hamcrest.CoreMatchers.containsString;
import java.util.UUID;
import com.github.javafaker.Faker;

import static org.junit.Assert.*;

public class DpRegistrationTest extends TestBase {
    String baseUrl = "http://85.93.17.135:9000/user/new";

    @Test
    public void registerAUserSuccessfully() throws InvalidElementStateException {

        DpRegistration page = new DpRegistration(driver);
        page.visitPage(baseUrl);
        page.userRegistration();

        assertTrue(page.userRegistered());
    }

}