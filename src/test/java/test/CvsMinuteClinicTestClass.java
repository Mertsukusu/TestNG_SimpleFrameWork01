package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CvsMinuteClinicPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CvsMinuteClinicTestClass {

    @Test
    public void cvsTest01() throws Exception {
        Driver.getDriver().get(ConfigReader.getProperty("cvs_url"));
        CvsMinuteClinicPage cvsMinuteClinicPage = new CvsMinuteClinicPage(Driver.getDriver());
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        cvsMinuteClinicPage.visitMinuteClick.click();
        cvsMinuteClinicPage.cvsZipcode.sendKeys("76015" + Keys.ENTER);
        Thread.sleep(4000);
        List<WebElement> Distance = Driver.getDriver().findElements(By.xpath("//*[@class='distance']"));
        for (WebElement each : Distance) {

            if (each.isDisplayed()) {
                String str = each.getText();
                String newStr = str.substring(0, str.indexOf(" "));

                double DistanceInMile = Double.parseDouble(newStr);
                System.out.println("Distance is : " + str + "and is less than 20: " + (DistanceInMile < 20));
                Assert.assertTrue(DistanceInMile < 20);
            }
        }
    }

}
