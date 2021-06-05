package android.po;

import base.AppDriver;
import base.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePage {

    //this section is intentionally commented, so we can see how to detect and perform actions with By locators

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    public WebElement ProductsHeader;

    @FindBy(xpath = "//android.widget.TextView[@text='Sauce Labs Backpack']")
    public WebElement sauceLabsBackpack;

    @FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART")
    public WebElement addToCartButton;
    
    By backToProducts = By.xpath("//android.widget.TextView[@text='BACK TO PRODUCTS");
    
    @FindBy(xpath = "//android.widget.TextView[@text='REMOVE")
    public WebElement removeButton;
    
    public void verifyHomePageIsDisplayed() {
    	
    	if(ProductsHeader.isDisplayed()) {
    		Assert.assertTrue(true, "User is logged in successfully and Homepage is displayed");
    	} else {
    		Assert.fail("User is Unable to login");
    	}	
    }
    
    public void selectBackpackItem() {
    	sauceLabsBackpack.click();
    	Util.waitForEl(backToProducts);
    }
    
    public void addItem() {
    	Util.scrollIntoView("ADD TO CART");
    	addToCartButton.click();
    }
    
    public void removeItem() {
    	removeButton.click();
    }
    
    public void verifyItemIsAdded() {
    	
    	if(removeButton.isDisplayed()) {
    		Assert.assertTrue(true, "Item is added in the cart successfully");
    	} else {
    		Assert.fail("User is Unable to add Item");
    	}
    	
    }

    public void verifyItemIsDeleted() {
    	
    	if(addToCartButton.isDisplayed()) {
    		Assert.assertTrue(true, "Item is deleted in the cart successfully");
    	} else {
    		Assert.fail("User is Unable to delete Item");
    	}
    	
    	
    }
}
