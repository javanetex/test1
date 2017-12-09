package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


public class HomePage {
    WebDriver driver;
//    private By bCommentLink = By.linkText("Comments");
    @FindBy(xpath = "//*[@id=\"j_id_f_1s\"]/ul/li[1]/a")
    private  WebElement weComment;

    public HomePage(WebDriver driver)
    {
        if (!driver.getTitle().equals("Index")) {
            throw new IllegalStateException("This is not Home Page of logged in user, current page" +
                    "is: " +driver.getTitle());
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickComments()
    {
//        WebElement weComment = driver.findElement(bCommentLink);
        weComment.click();
    }
}
