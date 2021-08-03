package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {
	public static WebDriver driver;
	public WebDriverWait wt;
	public static int x,y;
	
	public CommonPage(WebDriver driver) {
		this.driver=driver;
	}
	//highlighting element
	public void jsElementHighlight(WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style','border:2px solid red; background:yellow')", element);
	}
	
	public void eWaitVisibility(WebElement element) {
		WebDriverWait wt=new WebDriverWait(driver,120);
		wt.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void eWaitForUrl() {
		WebDriverWait wt=new WebDriverWait(driver,20);
		wt.until(ExpectedConditions.urlContains("DELIVERY_PAYMENTS"));
	}
	
	public void eWaitClickable(WebElement element) {
		WebDriverWait wt=new WebDriverWait(driver,120);
		wt.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	public void jsClick(WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click", element);
	}
	
	public void scrolltoView(WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView", element);
	}
	public static void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
	}
	
	public static void scrollbyPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)");
	}
	
}
