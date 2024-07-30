import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class swagLabsDashboard {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.findElement(By.id("inventory_filter_container")).isDisplayed();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void verifyClickingHamburger(){
        driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[2]/div[1]")).isDisplayed();
    }
    @Test
    public void verifyMenusOnHamburger(){
        driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
        driver.findElement(By.id("inventory_sidebar_link")).isDisplayed();
        driver.findElement(By.id("about_sidebar_link")).isDisplayed();
        driver.findElement(By.id("logout_sidebar_link")).isDisplayed();
        driver.findElement(By.id("reset_sidebar_link")).isDisplayed();
    }
    @Test
    public void verifyCloseIconOfHamburger(){
        driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Close Menu')]")).click();
        driver.findElement(By.id("inventory_filter_container")).isDisplayed();
    }
    @Test
    public void verifyAllItemsFunctionality(){
        driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
        driver.findElement(By.id("inventory_sidebar_link")).click();
        driver.findElement(By.className("inventory_list")).isDisplayed();
    }
    @Test
    public void verifyAboutFunctionality(){
        driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
        driver.findElement(By.id("about_sidebar_link")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div")).isDisplayed();
    }
    @Test
    public void verifyLogoutFunctionality(){
        driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        driver.findElement(By.xpath("//body/div[2]")).isDisplayed();
    }
//    @Test
//    public void verifyAppStateResetFunctionality(){
//        driver.findElement(By.xpath("//button[contains(text(),'Open Menu')]")).click();
//        driver.findElement(By.id("reset_sidebar_link")).isDisplayed();
//
//    }
    @Test
    public void verifyClickingProductName() {
        driver.findElement(By.className("inventory_item_name")).click();
        Assert.assertTrue(driver.findElement(By.className("inventory_details_name")).isDisplayed(), "Item description page is not displayed.");
    }
    @Test
    public void verifyClickingProductImage(){
        driver.findElement(By.className("inventory_item_img")).click();
//      Assert.assertTrue(driver.findElement(By.className("inventory_details_name")).isDisplayed(), "Item Description Page is not Displayed.");
        Assert.assertEquals(driver.findElement(By.className("inventory_details_name")).isDisplayed(),true,"Item Description Page is not Displayed.");
    }
    @Test
    public void verifySortingAToZ(){

    }
}
