package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    private WebDriver driver;
    private By bUserLogin = By.id("loginForm:userId");
    private By bUserPass = By.id("loginForm:password");
    private By bLoginButton = By.id("loginForm:j_id_g_1_6_8");

    public LogInPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setUserName(String userName)
    {
        WebElement weUserName = driver.findElement(bUserLogin);
        weUserName.sendKeys(userName);
    }

    public void setPassword(String userPass)
    {
        WebElement weUserPwd = driver.findElement(bUserPass);
        weUserPwd.sendKeys(userPass);
    }

    public void clickLogin()
    {
        WebElement weLoginButtonU = driver.findElement(bLoginButton);
        weLoginButtonU.click();
    }

    public void loginDemoSite(String user, String password)
    {
        this.setUserName(user);
        this.setPassword(password);
        this.clickLogin();
    }

}
