package webPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TextBoxPage {

    WebDriver driver;

    // Constructor
    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By fullName = By.id("userName");
    private By email = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By output = By.id("output");

    // Actions
    public void enterFullName(String name) {
        driver.findElement(fullName).sendKeys(name);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterCurrentAddress(String address) {
        driver.findElement(currentAddress).sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        driver.findElement(permanentAddress).sendKeys(address);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    // Output section
    public String getSubmittedOutput() {
        return driver.findElement(output).getText();
    }


}
