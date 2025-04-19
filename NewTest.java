package Com.Day8_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.io.FileWriter;
import java.time.Duration;
import java.util.List;

public class NewTest {
	public static void main(String[] args) {
		// Set up ChromeDriver path (if not using WebDriverManager)
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		// Configure Chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		// Uncomment the following line to run in headless mode if needed
		// options.addArguments("--headless");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver(options);

		try {
			// Navigate to the Amazon product page
			driver.get(
					"https://www.amazon.in/HP-i5-13420H-15-6inch-Enhanced-fa2700TX/dp/B0DTYZ2CG8/ref=sr_1_1_sspa?crid=263HA39GAEJ3D&dib=eyJ2IjoiMSJ9.2AsXKsfftLocSvZkz92gtfBX9h8T4tx87n-uNHhjj9FQZtTaxnnTceg3WsHpwP52r7jkjuAQG0Q7ksYLM3gH57QmkRg4AmrAzjrz5BJ718akUYcn0IJfWjX-SHKOa5flOfAHXREd9GqflkK2moxvDexmf9NEYYDMMmYcxPSkLrfcOCtcmVLfoscjBbuWJ4B2fX9u6zOZP_JKgWV4qWHs5_WcAgrILsSABBudzwU1Qnw.5piBhvn9GGgTRWfnOVQGvXTi3YuVg1r68D8bioOaweg&dib_tag=se&keywords=gaming+laptop&qid=1741327315&sprefix=%2Caps%2C198&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");

			Thread.sleep(10000);
			// Wait for the page to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Method 1: Try to find the close/cancel icon using common selectors
			// Amazon typically uses one of these patterns for close buttons

			/*
			 * JavascriptExecutor js = (JavascriptExecutor) driver;
			 * js.executeScript("window.scrollTo(0,700)"); Thread.sleep(2000); WebElement
			 * addToCartButton = driver.findElement(By.xpath(
			 * "/html/body/div[2]/div/div/div[5]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[36]/div[1]/span/span/span/input"
			 * ));
			 * 
			 * // js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block:
			 * // 'center'});", addToCartButton);
			 * 
			 * //
			 * js.executeScript("window.scrollTo(arguments[0],arguments[1])",addToCartButton
			 * .getLocation().x,addToCartButton.getLocation().y) // ; // Verify the add to
			 * cart button is present //
			 * Assert.assertTrue("Add to cart button should be displayed", //
			 * addToCartButton.isDisplayed()); addToCartButton.click(); // Find the quantity
			 * dropdownX WebElement quantityDropdown =
			 * driver.findElement(By.id("quantity"));
			 * 
			 * // Get the selected value from the dropdown String selectedValue =
			 * quantityDropdown.getAttribute("value");
			 * 
			 * // Convert to integer and verify it's at least 1 int quantity =
			 * Integer.parseInt(selectedValue);
			 * Assert.assertTrue("Product quantity should be greater than or equal to 1",
			 * quantity >= 1);
			 * 
			 * System.out
			 * .println("Test passed: Successfully navigated to gaming laptop product page and verified quantity"
			 * );
			 * 
			 * try { // Try multiple possible selectors for the close/cancel button String[]
			 * possibleSelectors = { "button.a-button-close", // Common close button class
			 * ".a-icon-close", // Close icon class ".a-icon-close-small", // Small close
			 * icon class "#attach-close_sideSheet-link", // Close button for side sheets
			 * "button.a-button-close i", // Close button with icon ".x-closebutton", // X
			 * close button "#dismiss-button", // Dismiss button ID "i.a-icon.a-icon-close",
			 * // Close icon with multiple classes "span.dsa-close", // Another close button
			 * class "button[aria-label='Close']", // Button with aria-label
			 * "button.a-link-normal.close-button", // Normal link close button
			 * ".close-button", // Generic close button ".x-close-button", // X close button
			 * alternative "//button[contains(@class, 'close')]" // XPath for any button
			 * with 'close' in its class };
			 * 
			 * boolean found = false; for (String selector : possibleSelectors) { try {
			 * WebElement closeButton; if (selector.startsWith("//")) { // Handle XPath
			 * selectors closeButton =
			 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector))); }
			 * else { // Handle CSS selectors closeButton =
			 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)))
			 * ; }
			 * 
			 * // Click the close button closeButton.click();
			 * System.out.println("Successfully clicked the close button using selector: " +
			 * selector); found = true; break; } catch (Exception e) { // This selector
			 * didn't work, try the next one continue; } }
			 * 
			 * if (!found) { System.out.println(
			 * "Could not find the close button with predefined selectors. Trying fallback methods."
			 * );
			 * 
			 * // Fallback: Find by partial text in button or span WebElement closeByText =
			 * driver.findElement(By.xpath(
			 * "//button[contains(text(),'Close') or contains(text(),'Cancel')] | //span[contains(text(),'Close') or contains(text(),'Cancel')]"
			 * )); closeByText.click();
			 * System.out.println("Clicked close/cancel button by text content.");
			 * 
			 * } } catch (Exception e) {
			 * System.out.println("Error finding or clicking the close button: " +
			 * e.getMessage()); e.printStackTrace(); } Thread.sleep(2000);
			 */
			/*
			 * WebElement topReview =
			 * driver.findElement(By.xpath("//h3[@data-hook='dp-local-reviews-header']"));
			 * js.executeScript("window.scrollTo(arguments[0],arguments[1])",topReview.
			 * getLocation().x,topReview.getLocation().y); Thread.sleep(2000);
			 * System.out.println("Navigated successfuly"); Actions action = new
			 * Actions(driver); action.doubleClick(topReview).build().perform()
			 */;
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement reviewsSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"//div[@id='reviewsMedley' or @id='customer-reviews-content' or contains(@class, 'review-views')]")));
			js.executeScript("arguments[0].scrollIntoView(true);", reviewsSection);

			// Wait a moment for the reviews to load after scrolling
			Thread.sleep(2000);
			// Wait a moment to see the result

			WebElement seeAllReviewsLink = driver.findElement(By
					.xpath("//a[contains(@data-hook, 'see-all-reviews-link') or contains(text(), 'See all reviews')]"));
			seeAllReviewsLink.click();
			System.out.println("Clicked on 'See all reviews' link");
			// Wait for reviews page to load
			Thread.sleep(3000);
			

			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//div[contains(@data-hook, 'review') or contains(@class, 'review')]")));
			
			Thread.sleep(10000);

			/*
			 * WebElement filterDropdown = driver.findElement(By.id("languageFilter"));
			 * filterDropdown.click(); Thread.sleep(10000);
			 * 
			 * WebElement indiaOption = driver .findElement(By.
			 * xpath("//li[contains(text(), 'India') or .//a[contains(text(), 'India')]]"));
			 * indiaOption.click(); System.out.println("Selected India filter for reviews");
			 * Thread.sleep(2000);
			 */

			// Create FileWriter to save the reviews
			FileWriter fileWriter = new FileWriter("amazon_india_reviews.txt");
			fileWriter.write("Top reviews from India for HP Gaming Laptop\n\n");

			// Find all review elements (try different selectors as Amazon's structure
			// varies)
			List<WebElement> reviewElements = driver
					.findElements(By.xpath("//div[contains(@data-hook, 'review') or contains(@class, 'review')]"));

			if (reviewElements.isEmpty()) {
				System.out.println("No reviews found with primary selector, trying alternative...");
				reviewElements = driver.findElements(By.cssSelector("[data-hook='review']"));
			}

			if (reviewElements.isEmpty()) {
				System.out.println("Still no reviews found, trying another alternative...");
				reviewElements = driver.findElements(By.cssSelector(".review"));
			}

			System.out.println("Found " + reviewElements.size() + " reviews");
			
			WebElement e21= driver.findElement(By.xpath("//div[@id='customer_review-R3TWOJIGGLJLO8']"));
			
			js.executeScript("arguments[0].scrollIntoView(true);", e21);

			// Extract and save review information
			int count = 0;
			for (WebElement review : reviewElements) {
				String reviewerName = "";
				String rating = "";
				String title = "";
				String body = "";
				String date = "";

				WebElement nameElement = review.findElement(
						By.xpath("//span[@class='a-profile-name' or text()='Richa Sharma']"));
				reviewerName = nameElement.getText();

				WebElement ratingElement = review.findElement(By.xpath(
						"//i[@data-hook='review-star-rating']"));
				rating = ratingElement.getAttribute("class");
				// Extract the numerical rating (e.g., "a-star-5" -> "5 stars")
				rating = rating.replaceAll(".*a-star-(\\d).*", "$1 stars");

				
				  WebElement titleElement = review.findElement(
				  By.xpath("(//span[@role='heading'])[1]")); title =
				  titleElement.getText();
				

				WebElement bodyElement = review.findElement(
						By.xpath("//span[@data-hook='review-body']"));
				body = bodyElement.getText();
				WebElement dateElement = review.findElement(
						By.xpath("//span[@data-hook='review-date']"));
				date = dateElement.getText();
				
				
				fileWriter.write("Reviewer: " + reviewerName + "\n");
                fileWriter.write("Rating: " + rating + "\n");
                fileWriter.write("Date: " + date + "\n");
                fileWriter.write("Title: " + title + "\n");
                fileWriter.write("Review: " + body + "\n");
                fileWriter.write("\n-------------------------------------------\n\n");
                
                count++;
                System.out.println("Extracted review #" + count);
                
                
                if (count == 0) {
                    fileWriter.write("No reviews found for this product. The page structure may have changed or there might be no reviews yet.");
                    System.out.println("No reviews were found.");
                    
                    
                }
                
               
			}
			
			 fileWriter.close();
             System.out.println("Reviews saved to amazon_india_reviews.txt");

		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
