package com.mobile.test;


import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertTrue;


public class MacysMobileWebsiteTesting {
	
		private WebDriver driver;
		public static final String USERNAME = "nandita7";
		public static final String AUTOMATE_KEY = "XscWDwAzLqydxmyrff3h";
		public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		
		@Before
		public void setUp() throws Exception {
			getWebDriver(DeviceBrowserType.IPhone);
		}
		
		
		/*
		 * author nramakr
		 * 
		 * This method tests if new users are able to create a new Macy's
		 * account and logged in to the website 
	     */
		@Ignore
		@Test
		public void testCreateAccount() throws Exception{
			
			driver.get("https://m.macys.com/");
			
			// Close the initial welcome screen
			if(driver.findElement(By.id("marketorial-close")) != null)
				driver.findElement(By.id("marketorial-close")).click();
			
			// Click on create account button
			driver.findElement(By.id("m-footer-link-signin")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@href='https://m.macys.com/account/profile']")).click();
			Thread.sleep(2000);
			
			// Provide user credentials for account creation
			driver.findElement(By.id("firstName")).sendKeys("rohit");	
			driver.findElement(By.id("lastName")).sendKeys("jachak");	
			driver.findElement(By.id("addressLine1")).sendKeys("208 W irving");	
			driver.findElement(By.id("addressLine2")).sendKeys("Apt 4");	
			driver.findElement(By.id("city")).sendKeys("Normal");	
			Select stateList = new Select(driver.findElement(By.id("state"))); 
			stateList.selectByVisibleText("Illinois");
			driver.findElement(By.id("zipcode")).sendKeys("61761");
			Thread.sleep(1000);
			
			Select monthList = new Select(driver.findElement(By.id("month")));   
			monthList.selectByVisibleText("January");
			Select dateList = new Select(driver.findElement(By.id("date")));   
			dateList.selectByVisibleText("4");
			Select yearList = new Select(driver.findElement(By.id("year")));   
			yearList.selectByVisibleText("1991");
			Select genderList = new Select(driver.findElement(By.id("gender")));   
			genderList.selectByVisibleText("Male");
			
			// Provide email, password, security question & answer
			driver.findElement(By.id("email")).sendKeys("rohitsjachak@gmail.com");
			driver.findElement(By.id("createConfirmEmail")).sendKeys("rohitsjachak@gmail.com");
			driver.findElement(By.id("password")).sendKeys("rohitjachak");
			driver.findElement(By.id("confirmPassword")).sendKeys("rohitjachak");
			Select questionList = new Select(driver.findElement(By.id("SecurityQna"))); 
			questionList.selectByValue("3");
			driver.findElement(By.id("securityAns")).sendKeys("Chennai");
			driver.findElement(By.id("textMeMsg")).click();
			driver.findElement(By.id("areaCode")).sendKeys("309");
			driver.findElement(By.id("exchangeNbr")).sendKeys("520");
			driver.findElement(By.id("subscriberNbr")).sendKeys("2216");
			
			// Submit the user information form
			driver.findElement(By.id("createProfileBtn")).click();
			Thread.sleep(10000);
			
			// Click on cancel button
			driver.findElement(By.xpath("//div[@class='btnscontainer-bottom row']/button[@id='overalyCancelBtn']")).click(); 
			Thread.sleep(2000);
			
			// Check if user is logged in
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='8px solid green'", 
					            driver.findElement(By.xpath("//div[@id='welcomeUserMsg']")));
			Thread.sleep(3000);
			
			String welcomeMsg = driver.findElement(By.xpath("//div[@id='welcomeUserMsg']")).getText();	
			welcomeMsg = welcomeMsg.substring(0, welcomeMsg.indexOf("!"));
			assertTrue(welcomeMsg.trim().equals("Hi Nandita"));
		}
		
		
		/*
		 * author nramakr
		 * 
		 * This method tests if user is able to successfully submit
		 *  product review.
	     */
		@Ignore
		@Test
		public void testWritingProductReview() throws Exception{
			
			driver.get("https://m.macys.com/");
			
			// Close the initial welcome screen
			if(driver.findElement(By.id("marketorial-close")) != null)
				driver.findElement(By.id("marketorial-close")).click();
			
			driver.findElement(By.id("m-footer-link-signin")).click();
			Thread.sleep(2000);
			
			// Sign in to macys website
			driver.findElement(By.id("mb-j-signup-email")).sendKeys("nandygopu1242@gmail.com");	
			driver.findElement(By.id("mb-j-signup-password")).sendKeys("macys123");	
			driver.findElement(By.xpath("//button[@id='mb-j-signin-button']")).click();
			Thread.sleep(2000);
			
			// Search for a product
			driver.findElement(By.xpath("//div[@id='m-search-input-wrapper']/input[@id='mb-j-search-field']")).sendKeys("womens fossil watch");
			Thread.sleep(2000);
			driver.findElement(By.id("m-search-go")).click();
			Thread.sleep(2000);
		    
			// Select product to write review
			driver.findElement(By.xpath("//a[@href='/shop/product/fossil-womens-tailor-rose-gold-tone-stainless-steel-bracelet-watch-35mm-es3713?ID=1946143']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='m-j-product-launch-write-reviews-modal m-button black']")).click();
			Thread.sleep(2000);
			
			// Provide overall rating, review, nickname 
			driver.findElement(By.xpath("//div[@id='mb-write-review-rating']/div[5]")).click();
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='8px solid green'", 
		            driver.findElement(By.xpath("//div[@id='title-form-item']/input[@name='title']")));
			driver.findElement(By.xpath("//div[@id='title-form-item']/input[@name='title']")).sendKeys("Super classy watch");
			
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='8px solid green'", 
		            driver.findElement(By.xpath("//div[@id='reviewtext-form-item']/textarea[@name='reviewtext']")));
			driver.findElement(By.xpath("//div[@id='reviewtext-form-item']/textarea[@name='reviewtext']")).sendKeys("The watch looks super cool and I feel great wearing it.");
			
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='8px solid green'", 
		            driver.findElement(By.xpath("//div[@id='displayName-form-item']/input[@name='displayName']")));
			driver.findElement(By.xpath("//div[@id='displayName-form-item']/input[@name='displayName']")).sendKeys("nango28");
			Thread.sleep(2000);
			
			// Submit the review details
			driver.findElement(By.xpath("//div[@id='write-review-submit']/button[@id='mb-j-write-review-submit']")).sendKeys("cool");
			Thread.sleep(5000);
			
			// Check if user review is successfully submitted for approval
			WebElement headerElement = driver.findElement(By.xpath("//div[@class='m-confirm-overlay']/div[@class='m-header']/div[1]"));
			String reviewMessage = headerElement.getText();
			assertTrue(reviewMessage.trim().equals("Thanks For Your Review"));
					
		}
		
		
		/*
		 *  author nramakr
		 *  
		 *  This method checks if the user entered product review
		 *  is approved and visible. Review approved within 48 hours
	     */
		@Ignore
		@Test
		public void testReviewApprovedandDisplayed() throws Exception{
			
			String providedReviewTitle = "Super classy watch";
			String providedReview = "The watch looks super cool and I feel great wearing it.";
			String userName = "nango28";
			boolean reviewFound=false;
			
			driver.get("https://m.macys.com/");
			
			// Close the initial welcome screen
			if(driver.findElement(By.id("marketorial-close")) != null)
				driver.findElement(By.id("marketorial-close")).click();
			
			// Search for a product
			driver.findElement(By.xpath("//div[@id='m-search-input-wrapper']/input[@id='mb-j-search-field']")).sendKeys("womens fossil watch");
			Thread.sleep(2000);
			driver.findElement(By.id("m-search-go")).click();
			Thread.sleep(2000);
		    
			driver.findElement(By.xpath("//a[@href='/shop/product/fossil-womens-virginia-shimmer-horn-and-rose-gold-tone-stainless-steel-bracelet-watch-30mm-es3716?ID=1865881']")).click();
			Thread.sleep(2000);
			
			// Get the total number of user reviews for the product
			String ratingCount = driver.findElement(By.xpath("//div[@class='m-rating-count']")).getText();
			int totalReview = 0;
			if(!ratingCount.isEmpty()){
				ratingCount = ratingCount.substring(1, ratingCount.lastIndexOf(")")).trim();
				totalReview =  Integer.parseInt(ratingCount);
			}
			driver.findElement(By.xpath("//div[@class='m-rating-count']")).click();
			Thread.sleep(2000);
		
			// Iterate through review list to find the user provided review
			for(int i=0; i< totalReview && !reviewFound; i++){
				WebElement titleElement = driver.findElement(By.xpath("//section[@id='mb-product-reviews-list']/article[" + (i+1) + "]/div[@class='m-product-review-title']"));
				WebElement reviewElement = driver.findElement(By.xpath("//section[@id='mb-product-reviews-list']/article[" + (i+1) + "]/div[@class='m-product-review-desc']"));
				
				if(titleElement.getText().trim().equals(providedReviewTitle) && reviewElement.getText().trim().equals(providedReview)){
					
					WebElement userElement = driver.findElement(By.xpath("//section[@id='mb-product-reviews-list']/article[" + (i+1) + "]/section[@class='m-product-review-details']"
							+ "/div[@class='m-product-review-details-user']/div[@class='m-product-review-user-name-loc']/span[@class='name']"));
					
					if(userElement.getText().trim().equals(userName)){
						
						((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)", "");
						reviewFound = true;
						
						// Highlight the user review
					    ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", titleElement);
					    ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", reviewElement);
					    ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid green'", userElement);
					    Thread.sleep(4000);
					   
					}
				}
			}
		}
		
		
		/*
		 *  author jgarg
		 *  
		 *  This method adds item to cart and checks if sum of individual
		 *  item price is equal to total price in the cart
	     */
		 @Test
	       public void addProductToBag() throws Exception {
	           
	           // go to macy's site
	           driver.get("https://m.macys.com/");

	           // Close the initial welcome screen
	           if (driver.findElement(By.id("marketorial-close")) != null)
	               driver.findElement(By.id("marketorial-close")).click();
	           
	           Thread.sleep(2000);
	           
	            driver.findElement(By.id("m-footer-link-signin")).click();
	            Thread.sleep(2000);
	            
	            // Sign in to macys website
	            driver.findElement(By.id("mb-j-signup-email")).sendKeys("nandygopu1242@gmail.com");    
	            driver.findElement(By.id("mb-j-signup-password")).sendKeys("macys123");    
	            driver.findElement(By.xpath("//button[@id='mb-j-signin-button']")).click();
	            Thread.sleep(2000);
	            
	           // go the hamburger menu button and click it
	           driver.findElement(By.className("unselectedMenuButton")).click();
	           
	           // click on shop button
	           Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='shop']/a")).click();
	             
	             // click on women button
	             Thread.sleep(2000);
	             driver.findElement(By.linkText("Women")).click();
	             
	             // click on shoe and accessories button
	             Thread.sleep(2000);
	             driver.findElement(By.linkText("Shoes & Accessories")).click();
	             
	             // click on belts button
	             Thread.sleep(2000);
	             driver.findElement(By.linkText("Belts")).click();
	             
	             // click on filter by category
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='m-browse-buttons-filterby']")).click();
	             
	             // click on brand button button
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='m-j-facet-list-BRAND']/div")).click();
	             
	             // click on brand fossil
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='mb-facetSelectionModal-container']/div[2]/ul/li[3]/div/div/div")).click();
	             
	             // click on the done button
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='facet-selection-button-right']")).click();
	             
	             // click on the apply button
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='facet-list-button-right']")).click();
	             
	             // select the first item
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='m-browse-results-list']/li[3]/a/div[2]/div[1]")).click();
	             
	             // select the size
	             Thread.sleep(2000);
	             driver.findElement(By.className("m-size")).click();
	             
	             // get the price of first item
	             String itemPrice1 = driver.findElement(By.className("m-product-price-amt")).getText();
	             double price1 = Double.parseDouble(itemPrice1.substring(1).trim());
	             System.out.println(itemPrice1);
	             System.out.println("Price of item1 = "+ price1);
	             
	             // add to bag
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='m-product-container']/div[3]/div[2]/div/div[2]/div/div[1]/button")).click();
	             
	             // click on back button 
	             Thread.sleep(2000);
	             driver.findElement(By.xpath("//div[@class='mb-j-modalHeader-left m-back']")).click();
	             
	             // click on the back button again
	             Thread.sleep(2000);
	             driver.findElement(By.className("m-back")).click();
	             
	             // select the second item
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='m-browse-results-list']/li[5]/a/div[2]/div[1]")).click();
	             
	             // select the size
	             Thread.sleep(2000);
	             driver.findElement(By.className("m-size")).click();

	             // get the price of first item
	             String itemPrice2 = driver.findElement(By.className("m-product-price-amt")).getText();
	                 double price2 = Double.parseDouble(itemPrice2.substring(1).trim());
	                 System.out.println(itemPrice2);
	                 System.out.println("Price of item2= " +price2);
	             
	             // add to bag
	             Thread.sleep(2000);
	             driver.findElement(By.xpath(".//*[@id='m-product-container']/div[3]/div[2]/div/div[2]/div/div[1]/button")).click();
	             
	             // Add the price of individual items
		         double totalPrice = price1 + price2;
		         System.out.println("Total price of item = $" + totalPrice);
		            
	             //click on check out
	             Thread.sleep(2000);
	             driver.findElement(By.linkText("checkout")).click();
	             ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)", "");
	             Thread.sleep(2000);

	             // Get the total value from cart 
	             String cartTotal = driver.findElement(By.xpath("//div[@id='m-bag-summary']/dl[@class='m-bag-section']/dd[@class='m-bag-order-subtotal m-qe-subtotal-amt']")).getText();
	             cartTotal = cartTotal.substring(1, cartTotal.length()-1);
	             double cartTotal1 = Double.parseDouble(cartTotal);
	             System.out.println("Total price in cart = $" + cartTotal1);
	             System.out.println(totalPrice+ "-" +cartTotal1);
	             
	             //Check if sum of individual item price equals the total price in cart
	             assertTrue(totalPrice == cartTotal1);
		 }
		 
		 /*
		  *  author jgarg
		  *  
		  *  This method validates the number of stores based on the zipcode
		  */
		 @Ignore
		 @Test
		  public void findStore() throws Exception {
		        int noOfStores = 8;
		        
		        // go to macy's site
		        driver.get("https://m.macys.com/");

		        // Close the initial welcome screen
		        if (driver.findElement(By.id("marketorial-close")) != null)
		            driver.findElement(By.id("marketorial-close")).click();
		        Thread.sleep(2000);
		        
		        // click on the "Find a Store" button
		        driver.findElement(By.id("m-footer-button-find-store")).click();
		        Thread.sleep(2000);
		        
		        // enter the zip code in the search box
		        driver.findElement(By.xpath(".//*[@id='mb-j-location-input']")).sendKeys("61761");
		        Thread.sleep(4000);
		        
		        // Hit enter to list drop down
		        driver.findElement(By.xpath(".//*[@id='mb-j-location-input']")).sendKeys(Keys.RETURN);
		        Thread.sleep(4000);

		        // Getting the number of stores from list web element
		        List<WebElement> storeList = driver.findElements(By.xpath("//ul[@class='mb-store-list']/li"));
		        Thread.sleep(2000);
		        System.out.println(noOfStores + "-" + storeList.size());

		        // Asserting for the number of stores displayed on the site 
		        assertTrue("Store counts are equal", noOfStores == storeList.size());

		    }
		  
		public enum DeviceBrowserType{
			Android, IPhone, IPad;
		}
		
		public void getWebDriver(DeviceBrowserType browsertype) throws Exception{
			DesiredCapabilities caps = new DesiredCapabilities();
			
			switch(browsertype){
			
			case Android:
				caps.setCapability("browserStack.debug", "true");
				caps.setCapability("browserName", "android");
				caps.setCapability("platform", "ANDROID");
				caps.setCapability("device", "Samsung Galaxy S5");
				break;
				
			case IPhone:
				caps.setCapability("browserStack.debug", "true");
				caps.setCapability("browserName", "iPhone");
				caps.setCapability("platform", "MAC");
				caps.setCapability("device", "iPhone 6");
				break;
				
			case IPad:
				caps.setCapability("browserStack.debug", "true");
				caps.setCapability("browserName", "iPhone");
				caps.setCapability("platform", "MAC");
				caps.setCapability("device", "iPad");
				break;
				
				default:
					throw new RuntimeException("Browser type unsupported");
			}
			
			driver = new RemoteWebDriver(new URL(URL), caps);
		}
		
		@After
		public void tearDownAfterClass() throws Exception {
			driver.quit();
		}
		
	}

