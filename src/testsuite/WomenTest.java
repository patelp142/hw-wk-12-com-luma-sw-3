package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
//        * Mouse Hover on Women Menu & * Mouse Hover on Tops
        mouseHoverMultiple(By.xpath("//span[normalize-space()='Women']"),By.xpath("//a[@id='ui-id-9']"));
//        * Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
//        * Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"),"Product Name");
//        * Verify the products name display in  alphabetical order
    }
    @Test
    public void verifyTheSortByPriceFilter(){
//        * Mouse Hover on Women Menu & * Mouse Hover on Tops
        mouseHoverMultiple(By.xpath("//span[normalize-space()='Women']"),By.xpath("//a[@id='ui-id-9']"));
//        * Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
//        * Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.id("sorter"),"Price");
//        * Verify the products price display in Low to High
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
