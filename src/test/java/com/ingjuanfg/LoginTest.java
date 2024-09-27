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

        WebElement buttonSignIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]//div[@class=\"user-info\"]//a[@title=\"Log in to your customer account\"]"));
        buttonSignIn.click();
        WebElement buttonCreateAccount = driver.findElement(By.xpath("//*[@id=\"main\"]//div[@class=\"no-account\"]//a[@data-link-action=\"display-register-form\"]"));
        buttonCreateAccount.click();
    }

    //@AfterEach
    //public void configuracionFinal(){
    //    driver.close();
    //}
}