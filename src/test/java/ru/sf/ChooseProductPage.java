package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ChooseProductPage {

    private static final String SEARCH_FIELD_CLASS = "multi-input";
    private static final String ERROR_MESSAGE_SPAN_CLASS = "//*[text()='Нет результатов по вашему запросу']";

    private final WebDriver webDriver;

    public ChooseProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void go(String url) {
        webDriver.get(url);
    }

    public void searchProduct(String product) {
        webDriver.findElement(By.className("search-hover__field")).click();
        final var serchInput = webDriver.findElement(By.className(SEARCH_FIELD_CLASS));
        serchInput.sendKeys(product, Keys.ENTER);
    }

    public String getProductNotFoundMessage() {
        return webDriver.findElement(By.xpath(ERROR_MESSAGE_SPAN_CLASS)).getText();
    }
}