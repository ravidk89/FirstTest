
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
public class HomeScreen {
    public static void PickACatagory(AndroidDriver driver) {
        driver.findElementByXPath("//android.widget.TextView[@text='גיפט קארד למותגי אופנה']").click();
    }
    public static void PickABuisness(AndroidDriver driver) {
        driver.findElementByXPath("//android.widget.TextView[@text='BUYME TOTAL - שובר משולב לרשתות מובילות']").click();
    }
    public static void EnterGiftBudget(AndroidDriver driver) {
        WebElement EnterGiftBudget = driver.findElement(MobileBy.className("android.widget.EditText"));
        EnterGiftBudget.sendKeys("700");
    }
    public static void PressButtonContinue(AndroidDriver driver) {
        driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/purchaseButton")).click();
    }
}


