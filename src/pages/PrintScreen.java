package pages;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class PrintScreen {

    public static void takePrintScreen(WebDriver driver, String sFileName)
    {
        File screenshotFile;
        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new
                    File(sFileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
