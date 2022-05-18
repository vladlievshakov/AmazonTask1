package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.example.AmazonTest.driver;

public class Book {
        WebElement setName;
        WebElement setAuthor;
        List<WebElement> setBestseller;

        public void getBooks() {
            ArrayList<String> listOfBooks = new ArrayList<>();
            List<WebElement> items = driver.findElements(By.xpath("//div[contains(@class, 's-card-container s-overflow-hidden aok-relative s-include-content-margin s-latency-cf-section s-card-border')]"));
            for (int i = 1; i <= items.size(); i++) {
                Book book = new Book();
                book.setName = driver.findElement(By.xpath("//div[@data-component-type=\"s-search-result\"][" + i + "]//h2/a/span"));
                listOfBooks.add(book.setName.getText());
            }

            for (int i = 1; i <= items.size(); i++) {
                    Book author1 = new Book();
                    author1.setAuthor = driver.findElement(By.xpath("//div[@data-component-type=\"s-search-result\"][" + i + "]//div[span]/a | //div[@data-component-type=\"s-search-result\"][" + i + "]//div[@class=\"a-row a-size-base a-color-secondary\"]/div/span[@class=\"a-size-base\"][2]"));
                    listOfBooks.add(author1.setAuthor.getText());
            }

            Book bestseller = new Book();
            bestseller.setBestseller = driver.findElements(By.xpath("//*[@class='a-badge-text']"));
            listOfBooks.add(bestseller.setBestseller.toString());


//            for (int i = 1; i <= items.size(); i++) {
//                Book author2 = new Book();
//                author2.setAuthor = driver.findElement(By.xpath("//div[@data-component-type=\"s-search-result\"][" + i + "]//div[span]/a | //div[@data-component-type=\"s-search-result\"][" + i + "]//div[@class=\"a-row a-size-base a-color-secondary\"]/div/span[@class=\"a-size-base\"][2]"));
//                listOfBooks.add(author2.setAuthor.getText());
//            }

//            Book expectedBook = new Book();
            String expectedBookName = "Head First Java, 2nd Edition";
            String expectedBookAuthor1 = "Kathy Sierra";
//            expectedBook.setName = driver.findElement(By.xpath("//span[normalize-space()='Head First Java, 2nd Edition']"));
//            expectedBook.setAuthor = driver.findElement(By.xpath("//a[contains(text(),'Kathy Sierra')]"));


            System.out.println(listOfBooks);
            System.out.println("Book 1 " + expectedBookName);
            System.out.println("Author 1 " + expectedBookAuthor1);
            System.out.println("Best 1 = " + bestseller);
//            System.out.println(expectedBook.setAuthor.getText());
            Assert.assertTrue(listOfBooks.contains(expectedBookName));
            Assert.assertTrue(listOfBooks.contains(expectedBookAuthor1));
//            Assert.assertTrue(listOfBooks.contains(expectedBookAuthor2));
//            Assert.assertTrue(listOfBooks.contains(expectedBook.setName.getText()));
//            Assert.assertTrue(listOfBooks.contains(expectedBook.setAuthor.getText()));
        }
    }
//}
