package com.dpsolution.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class DpRegistration {

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmationPassword")
    private WebElement confirmationPassword;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement submitInfo;

    @FindBy(css = "a.btn.btn-default[href*='/user/new']")
    private WebElement newUser;

    @FindBy(id = "user.name.error")
    private WebElement userNameError;

    @FindBy(id = "user.email.error")
    private WebElement emailError;

    @FindBy(id = "user.password.error")
    private WebElement passwordError;

    @FindBy(id = "user.confirmationPassword.error")
    private WebElement confirmationPasswordError;






    public WebDriver driver;

    public DpRegistration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage(String url) {
        this.driver.get(url);
    }

    public Map<String, String> userRegistration(Map<String, String> userData){
        fillRegistrationForm(userData);
        submitInfo.click();
        return userData;
    }

    public Map<String, String> getDefaultUserData() {
        Map<String, String> userData = new HashMap<String, String>();
        Faker fakeObject = new Faker();
        userData.put("name", fakeObject.gameOfThrones().character());
        userData.put("email", fakeObject.internet().emailAddress());
        userData.put("password", fakeObject.internet().password());
        return userData;
    }

    private void fillRegistrationForm(Map userData){

        name.clear();
        name.sendKeys((CharSequence) userData.get("name"));

        email.clear();
        email.sendKeys((CharSequence) userData.get("email"));

        password.clear();
        password.sendKeys((CharSequence) userData.get("password"));

        confirmationPassword.clear();
        confirmationPassword.sendKeys((CharSequence) userData.get("password"));

    }

    public boolean userRegistered(){
        return newUser.isDisplayed();

    }

    public void selectNewUser(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newUser);
        newUser.click();
    }


    public String getNameError(){
        System.out.print(userNameError.getText());
        return userNameError.getText();

    }

    public String getEmailError(){
        System.out.print(emailError.getText());
        return emailError.getText();

    }

    public String getPasswordError(){
        System.out.print(passwordError.getText());
        return passwordError.getText();

    }

    public String getConfirmationPasswordError(){
        System.out.print(confirmationPasswordError.getText());
        return confirmationPasswordError.getText();

    }
}
