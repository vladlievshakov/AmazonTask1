package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    public WebDriver driver;
    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    private WebElement filterButton;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[1]/div/div/select/option[6]")
    private WebElement itemBks;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement findingField;

    @FindBy(xpath = "//*[contains(@id, 'nav-search-submit-button')]")
    private WebElement searchBtn;

    public void clickFilterButton() {
        filterButton.click(); }

    public void clickItemButton() {
        itemBks.click(); }

    public void inputText(String value) {
        findingField.sendKeys(value); }

    public void clickSearchButton() {
        searchBtn.click(); }
}
