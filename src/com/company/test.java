package com.company;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;
import pages.PrintScreen;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver;
    Wait<WebDriver> astept ;
    LogInPage liPage;
    HomePage hpPage;
    File screenshotFile;

    @BeforeTest
    public void startDriver()
    {
        //        Chrome
        String path = "D:\\Projects\\training\\Day11\\selenium\\";
        System.setProperty("webdriver.chrome.driver",path + "chromedriver.exe"); driver = new ChromeDriver();

        driver = new ChromeDriver();
        astept = new FluentWait<WebDriver>(driver)
                //how much to wait
        .withTimeout(10, TimeUnit.SECONDS)
                // frequency of check
        .pollingEvery(1, TimeUnit.SECONDS)
                // ignore exception
        .ignoring(java.util.NoSuchElementException.class);
    }

    @Test(priority = 1, dataProvider="getLoginData", dataProviderClass=com.company.provideLogin.class)
    public void testLogin(String userN, String passwN) {
        String baseUrl = "http://80.240.140.117/ElysianQuizz/";
        String expectedTitle = "";
        String actualTitle = "";


        driver.get(baseUrl);

        PrintScreen.takePrintScreen(driver, "LogInPage" );




        astept.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginForm:userId")));
        //admin login
        liPage = new LogInPage(driver);
        liPage.loginDemoSite(userN,passwN);

        PrintScreen.takePrintScreen(driver, "HomePage" );
//        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshotFile, new
//                    File("HomePage.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    @Test(priority = 2)
    public void goToTest() {
        astept.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"j_id_f_1s\"]/ul/li[1]/a")));
       hpPage = new HomePage(driver);
       hpPage.clickComments();

        PrintScreen.takePrintScreen(driver, "CommentPage" );
//        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshotFile, new
//                    File("CommentPage.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @AfterTest
    public void stopDriver()
    {
        driver.close();

    }
}