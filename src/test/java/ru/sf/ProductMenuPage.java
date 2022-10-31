package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductMenuPage {
    private final WebDriver webDriver;
    private final static String ACTIVE_PRODUCT_SPAN_XPATH = "//*[text()='Нет результатов по вашему запросу']";

    public ProductMenuPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentActiveProduct() {
        return webDriver.findElement(By.xpath(ACTIVE_PRODUCT_SPAN_XPATH)).getText();
    }

}
