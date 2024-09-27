package com.ingjuanfg;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    public void configuracionInicial(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginExitoso() {
        //ARRANGE
        driver.get("https://teststore.automationtesting.co.uk/index.php");

        int randomNumber = (int)(Math.random()*100+1);
        String firstName = "John";
        String lastName = "Doe";
        String email = "test" + Integer.toString(randomNumber) + "@email.com";
        String password = "#7G42OV^ndRv";

        WebElement buttonSignIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]//div[@class=\"user-info\"]//a[@title=\"Log in to your customer account\"]"));
        buttonSignIn.click();
        WebElement buttonCreateAccount = driver.findElement(By.xpath("//*[@id=\"main\"]//div[@class=\"no-account\"]//a[@data-link-action=\"display-register-form\"]"));
        buttonCreateAccount.click();

        WebElement firstNameInput = driver.findElement(By.xpath("//form[@id=\"customer-form\"]//child::div[@class=\"form-group row \"]//input[@id=\"field-firstname\"]"));
        WebElement lastNameInput = driver.findElement(By.xpath("//form[@id=\"customer-form\"]//child::div[@class=\"form-group row \"]//input[@id=\"field-lastname\"]"));
        WebElement emailInput = driver.findElement(By.xpath("//form[@id=\"customer-form\"]//child::div[@class=\"form-group row \"]//input[@id=\"field-email\"]"));
        WebElement passwordInput = driver.findElement(By.xpath("//form[@id=\"customer-form\"]//child::div[@class=\"form-group row \"]//input[@id=\"field-password\"]"));
        WebElement tycInput = driver.findElement(By.xpath("//form[@id=\"customer-form\"]//child::div[@class=\"form-group row \"]//input[@name=\"psgdpr\"]"));
        WebElement buttonSubmit = driver.findElement(By.xpath("//form[@id=\"customer-form\"]/div/following-sibling::footer/button[@data-link-action=\"save-customer\"]"));
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        tycInput.click();
        buttonSubmit.click();
    }

    //@AfterEach
    //public void configuracionFinal(){
    //    driver.close();
    //}
}