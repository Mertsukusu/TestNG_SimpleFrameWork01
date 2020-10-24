package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CvsMinuteClinicPage {
    WebDriver driver;
    public CvsMinuteClinicPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Visit MinuteClinic")
    public WebElement visitMinuteClick;

    @FindBy(xpath = "//a[contains(text(),'No, thanks')]")
    public WebElement noThanksButton;

    @FindBy(xpath = "//input[@id='zip']")
    public WebElement cvsZipcode;

    @FindBy(xpath = "//div[@class='distance']")
    public WebElement mileages;
}
