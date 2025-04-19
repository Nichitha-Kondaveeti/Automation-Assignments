package Com.Day8_Assignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Log4j2 {
	final Logger logger = LogManager.getLogger(Log4j2.class);
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.setProperty("Log4j.ConfigurationFile", "./resources/log4j.xml");

		// Navigate to Leafground application
		driver.get("https://leafground.com/dashboard.xhtml;jsessionid=node0vvkqhnhws6mj1dosovjjke8fd8811352.node0");
		Thread.sleep(2000);
		logger.info("Navigated to Leafground Input Page");
	}

	/**
	 * Validates email address format using regex
	 * 
	 * @param email Email address to validate
	 * @return true if email is valid, false otherwise
	 */
	public boolean isValidEmail(String email) {
		if (email == null) {
			return false;
		}

		// RFC 5322 Official Standard for email validation
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);

		boolean isValid = matcher.matches();
		logger.info("Email Validation - Email: " + email + ", Valid: " + isValid);

		return isValid;
	}

	/**
	 * Validates message length and content
	 * 
	 * @param message Message to validate
	 * @return true if message is valid, false otherwise
	 */
	public boolean isValidMessage(String message) {
	    if (message == null) {
	        return false;
	    }
	    
	    // More strict validation
	    boolean isValid = message.length() >= 10 && message.length() <= 100; // Adjusted max length
	    
	    // Optional: Add more validation criteria
	    boolean hasValidContent = !message.matches("^\\s*$"); // Ensures not just whitespace
	    boolean containsMeaningfulWords = message.split("\\s+").length >= 3; // Ensures at least 3 words
	    
	    boolean finalValidation = isValid && hasValidContent && containsMeaningfulWords;
	    
	    logger.info("Message Validation Details - " +
	        "Length: " + message.length() + 
	        ", Valid Length: " + isValid + 
	        ", Has Content: " + hasValidContent + 
	        ", Meaningful Words: " + containsMeaningfulWords +
	        ", Final Validation: " + finalValidation
	    );
	    
	    return finalValidation;
	}

	@Test
	public void testEmailValidation() {
		try {
			// Find email input field
			WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]")); // Replace with actual ID

			// Test valid email
			String validEmail = "test.user@example.com";
			emailInput.clear();
			emailInput.sendKeys(validEmail);

			Assert.assertTrue(isValidEmail(validEmail), "Invalid email format");
			logger.info("Email Validation Test Passed for: " + validEmail);

			// Test invalid email formats
			String[] invalidEmails = { "invalid.email", "user@.com", "@example.com", "user@example" };

			for (String invalidEmail : invalidEmails) {
				emailInput.clear();
				emailInput.sendKeys(invalidEmail);

				Assert.assertFalse(isValidEmail(invalidEmail), "Should be an invalid email: " + invalidEmail);
				logger.warn("Invalid Email Detected: " + invalidEmail);
			}
		} catch (Exception e) {
			logger.error("Email Validation Test Failed", e);
			Assert.fail("Email Validation Test Failed: " + e.getMessage());
		}
	}

	@Test
	public void testMessageValidation() {
	    try {
	        // Find message input field
	        WebElement messageInput = driver.findElement(By.xpath("//*[@id=\"message\"]")); // Replace with actual ID
	        
	        // Test valid messages
	        String[] validMessages = {
	            "This is a valid message with enough characters.",
	            "Hello, this is another valid test message.",
	            "A meaningful message that passes validation checks"
	        };
	        
	        for (String validMessage : validMessages) {
	            messageInput.clear();
	            messageInput.sendKeys(validMessage);
	            
	            Assert.assertTrue(isValidMessage(validMessage), "Message should be valid: " + validMessage);
	            logger.info("Message Validation Passed for: " + validMessage);
	        }
	        
	        // Test invalid messages
	        String[] invalidMessages = {
	            "Short",  // Too short
	            "",       // Empty string
	            "   ",    // Only whitespace
	            "A very long message that exceeds the maximum allowed length and should be considered invalid for our validation rules...",
	            "Repeated words ".repeat(20)  // Excessively long message
	        };
	        
	        for (String invalidMessage : invalidMessages) {
	            messageInput.clear();
	            messageInput.sendKeys(invalidMessage);
	            
	            Assert.assertFalse(isValidMessage(invalidMessage), "Message should be invalid: " + invalidMessage);
	            logger.warn("Invalid Message Detected: " + invalidMessage);
	        }
	    } catch (Exception e) {
	        logger.error("Message Validation Test Failed", e);
	        Assert.fail("Message Validation Test Failed: " + e.getMessage());
	    }
	}
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			logger.info("WebDriver closed successfully");
		}
	}
}
