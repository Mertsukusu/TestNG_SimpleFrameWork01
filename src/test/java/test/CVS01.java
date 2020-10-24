package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CVS01 {
    @Test
    public void firstDriverTest() throws Exception {
        //driver ==>>> Driver.getDriver();
        // Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().get("https://www.cvs.com/minuteclinic/?icid=CVS-HOME-PWRZN-MINUTECLINIC");
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(6000);
        //If you get iframe on the webpage you use below codes for handle to iframe
//        WebElement iframe=Driver.getDriver().findElement(By.xpath("//body/iframe[1]"));
//        Driver.getDriver().switchTo().frame(iframe);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'No, thanks')]")));
        Driver.getDriver().findElement(By.xpath("//a[contains(text(),'No, thanks')]")).click();
//        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().findElement(By.xpath("//input[@id='zip']")).sendKeys("76015" + Keys.ENTER);
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
