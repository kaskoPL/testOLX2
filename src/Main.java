import org.openqa.selenium.*;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1800,1000));
        driver.get("https://www.olx.pl");
//        BrowsingContext bContext = new BrowsingContext(driver, driver.getWindowHandle());
        try {
            WebElement myElement = driver.findElement(By.linkText("Zwierzęta"));

            myElement.click();
            driver.findElement(By.linkText("Konie")).click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.id("search")).sendKeys("feliński");
            driver.findElement(By.cssSelector("button[data-testid=\"search-submit\"]")).click();

            Thread.sleep(5000);
        } catch (Exception e) {

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);


//            String screenshot = bContext.captureScreenshot();
//            BufferedWriter writer = new BufferedWriter(new FileWriter("d://projects//testOLX2//test.png"));
            byte[] decodedimg = Base64.getDecoder().decode(screenshotBase64.getBytes(StandardCharsets.UTF_8));

//            writer.write(screenshotBase64);
//            writer.close();
            Files.write(Path.of("d://projects//testOLX2//test.png"), decodedimg);
            System.out.println(e.getMessage());
        }
        driver.close();
    }
}