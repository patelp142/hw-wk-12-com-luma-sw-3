package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
//        * Mouse Hover on Men Menu and * Mouse Hover on Bottoms
        mouseHoverMultiple(By.xpath("//span[normalize-space()='Men']"),
                By.xpath("//a[@id='ui-id-18']"));
//        * Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
//        * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
//        * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
//        * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        clickOnElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
//        * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyExpectedAndActual(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),
                "You added Cronus Yoga Pant to your shopping cart.");
//        * Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
//        * Verify the text ‘Shopping Cart’
        verifyExpectedAndActual(By.xpath("//span[@class='base']"),"Shopping Cart");
//        * Verify the product name ‘Cronus Yoga Pant’
        verifyExpectedAndActual(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"),
                "Cronus Yoga Pant");
//        * Verify the product size ‘32’
        verifyExpectedAndActual(By.xpath("//dd[contains(text(),'32')]"),"32");
//        * Verify the product colour ‘Black’
        verifyExpectedAndActual(By.xpath("//dd[contains(text(),'Black')]"),"Black");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
