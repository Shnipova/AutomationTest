import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ImportJSONnewProduct {
    WebDriver driver = new ChromeDriver();
    @BeforeTest

    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        driver.get("https://cpb-v2-stage-march.myshopify.com");

    }






    @Test
    public void importJSON() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        driver.get("https://ws0.techstartacademy.io/stage-march.admin.html");
        WebDriverWait wait = new WebDriverWait(driver,90);

        driver.switchTo().frame(driver.findElement(By.id("cpb")));
        System.out.println("switched to iFrame");

        //click on create new button

        WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div/div/div/div[2]/h2/div/button"));
        wait.until(ExpectedConditions.elementToBeClickable(createNewButton));
        createNewButton.click();
        System.out.println("New button was clicked");

        //checking the checkbox
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cpb-loader")));
        WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Polaris-Checkbox__Backdrop']")));
        checkBox.click();
        Thread.sleep(3000);
        System.out.println("CheckBox was checked");

        //upload JSON file
        String pathFile = "/Users/svitlanashnipova/IdeaProjects/AutomationTest/src/testData/8286148526375-upload_test.json";
        WebElement uploadJSONField =  driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/div/div/input"));
        uploadJSONField.sendKeys(pathFile);

        WebElement fillDataButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[2]/div[4]/button")));
        fillDataButton.click();
        System.out.println("fill data button was clicked");

        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div")));

        String modalText = modal.getText();
        Assert.assertTrue(modalText.contains("Product Data Has Been Successfully Uploaded"), "Modal message does not match!");
        System.out.println("assertion modal was checked");

        WebElement titleInputField = driver.findElement(By.id("productTitle"));
        titleInputField.clear();
        titleInputField.sendKeys("Amazing Phone Case");
        Thread.sleep(3000);

        //upload image
        WebElement imageUploadField = driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[3]/div/input"));
        String imagePath =("/Users/svitlanashnipova/IdeaProjects/AutomationTest/src/testData/phone case.jpeg");
        imageUploadField.sendKeys(imagePath);
        System.out.println("image was uploaded");

        WebElement createProductButton = driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[3]/div/div[1]/button"));
        createProductButton.click();
        System.out.println("create button was clicked");

        //back to list
        WebElement waitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-builder\"]/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/div/button[4]")));
        WebElement backToListButton = driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div[1]/div/div/div[1]/div[1]/button[1]"));
        backToListButton.click();
        System.out.println("Back to button ws clicked");

        WebElement leaveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[6]/button[1]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", leaveButton);
        System.out.println("Leave button was clicked");

    }

    @AfterTest

    public void quit(){
        if(driver !=null)
            driver.quit();
    }
}
