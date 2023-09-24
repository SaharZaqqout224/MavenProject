import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class NewTest {


    public static void main(String[] args) throws InterruptedException {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://famcare.app/");


        List<WebElement> linkElements = chrome.findElements(By.tagName("a"));

        // Iterate through the list of links and check if each one is clickable
        for (WebElement linkElement : linkElements) {
            if (linkElement.isEnabled() && linkElement.isDisplayed()) {
                System.out.println("Link is clickable: " + linkElement.getText() + linkElement.getAttribute("href"));
            } else {
                System.out.println("Link is not clickable: " + linkElement.getText()+linkElement.getAttribute("href"));
            }
        }
        //check
        List<WebElement> imageElements = chrome.findElements(By.tagName("img"));
        Thread.sleep(1000);
        // Iterate through the list of images and check each one for visibility
        for (WebElement imageElement : imageElements) {
            if (imageElement.isDisplayed()) {
                System.out.println("Image is visible: " + imageElement.getAttribute("src"));
            } else {
                System.out.println("Image is not visible: " + imageElement.getAttribute("src"));
            }
        }
        Thread.sleep(1000);
        WebElement element = chrome.findElement(By.xpath("//*[@id=\"navbarContent\"]/button"));
        element.click();
        Thread.sleep(1000);
        WebElement usernameField = chrome.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[2]/input"));
        WebElement mobileField = chrome.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[3]/input"));
        WebElement specialization = chrome.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[4]/input"));
        WebElement degree = chrome.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[5]/input"));
        WebElement experience = chrome.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[6]/input"));
        WebElement socialmedia = chrome.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[7]/input"));

        usernameField.sendKeys("invalid_username");
        Thread.sleep(1000);
        mobileField.sendKeys("invalid");
        Thread.sleep(1000);
        specialization.sendKeys("invalid");
        Thread.sleep(1000);
        degree.sendKeys("invalid");
        Thread.sleep(1000);
        experience.sendKeys("12");
        Thread.sleep(1000);
        socialmedia.sendKeys("invalid");
        WebElement button = chrome.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/input"));
        button .click();
        Thread.sleep(10000);

        // Enter invalid data and submit the form

        // Check for validation messages or success messages
        WebElement validationMessage = chrome.findElement(By.xpath("//*[@id=\"wpcf7-f1890-o2\"]/form/div[8]"));

        if (validationMessage.isDisplayed()) {
            System.out.println("Validation message displayed: " + validationMessage.getText());
        } else {
            System.out.println("Form submitted successfully.");
        }
        if (validationMessage.getText() =="required"){
            System.out.println("Validation message displayed: " + validationMessage.getText());
        } else {
            System.out.println("Form submitted successfully.");
        }

        chrome.quit();
    }
}