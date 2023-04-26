package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
//        * Mouse Hover on Gear Menu
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));
//        * Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
//        * Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
//        * Verify the text ‘Overnight Duffle’
        verifyExpectedAndActual(By.xpath("//span[@class='base']"),"Overnight Duffle");
//        * Change Qty 3
        clearText(By.xpath("//input[@value='1']"));
        sendTextToElement(By.xpath("//input[@value='1']"),"3");
//        * Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));
//        * Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyExpectedAndActual(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),
                "You added Overnight Duffle to your shopping cart.");
//        * Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
//        * Verify the product name ‘Overnight Duffle’
        verifyExpectedAndActual(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"),"Overnight Duffle");
//        * Verify the Qty is ‘3’
        Thread.sleep(2000);
        verifyExpectedAndActualValue(By.xpath("//input[@value='3']"),"3");
//        * Verify the product price ‘$135.00’
        verifyExpectedAndActual(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"),
                "$135.00");
//        * Change Qty to ‘5’
        clearText(By.xpath("//input[@value='3']"));
        sendTextToElement(By.xpath("//input[@value='3']"),"5");
//        * Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
//        * Verify the product price ‘$225.00’
        verifyExpectedAndActual(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"),
                "$225.00");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
