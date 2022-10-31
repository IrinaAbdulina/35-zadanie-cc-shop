package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StepDefinitions {
    public static final WebDriver webDriver;
    public static final ChooseProductPage chooseProductPage;
    public static final ProductMenuPage productMenuPage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IRINA\\IdeaProjects\\cc-35\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().window().maximize();
        chooseProductPage = new ChooseProductPage(webDriver);
        productMenuPage = new ProductMenuPage(webDriver);
    }
    @Given("url of shop {string}")
    public void url_of_shop(String url) {
        chooseProductPage.go(url);
           }
    @Then("chose product {string}")
    public void chose_product(String product) {
        chooseProductPage.searchProduct(product);
    }

    @Then("assert that chosen product is {string}")
    public void assert_that_chosen_product_is(String expectedProduct) {
        final var currentActiveProduct= productMenuPage.getCurrentActiveProduct();
        Assert.assertEquals(expectedProduct, currentActiveProduct);
    }
    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
        final var productNotFoundMessage = chooseProductPage.getProductNotFoundMessage();
        Assert.assertEquals(errorMessage, productNotFoundMessage);
    }

    @Then("replies to messages")
    public void replies_to_messages() {
        final var wer = webDriver.findElement(By.id("right_region"));
        if (wer != null) {
            wer.click();
        }

        final var rew = webDriver.findElement(By.id("onesignal-slidedown-cancel-button"));
        if (rew != null) {
            rew.click();
        }
    }
}
