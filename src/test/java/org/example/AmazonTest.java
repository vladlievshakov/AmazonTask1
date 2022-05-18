package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
//import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static org.junit.Assert.assertTrue;

//import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AmazonTest {
    public static WebDriver driver;
    public static Header header;
    public static Book books;



    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        header = new Header(driver);
        books = new Book();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://amazon.com");

    }

    @Test
    public void startPage() {
        header.clickFilterButton();
        header.clickItemButton();
        header.inputText("Java");
        header.clickSearchButton();

        books.getBooks();




//        Book expectedBook = new Book();
//            expectedBook.setNames = driver.findElement(By.xpath("//div[@data-component-type=\"s-search-result\"][5]//h2/a/span"));
//            System.out.println("Expected = " + expectedBook);
//        Assert.assertTrue(listOfBooks.contains(expectedBook));
        }

    @AfterClass
    public static void tearDown() {
//        driver.quit();
    }
}
