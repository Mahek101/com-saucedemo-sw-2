package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Text is not Displayed",expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        int expectedNumber = 6;
        int actualNumber = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals("Different number is displayed",actualNumber,expectedNumber);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
