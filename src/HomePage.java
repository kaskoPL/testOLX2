import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    private By messageBy = By.tagName("h2");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessageText(){
        return driver.findElement(messageBy).getText();
    }
}
