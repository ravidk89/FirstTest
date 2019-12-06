import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
public class RegistrationPage {
   public static void ClickRegistration (AndroidDriver driver) {
       driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/skipButton")).click();
    }
    public static void ChooseGoogleLogin (AndroidDriver driver) {
        driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/googleButton")).click();
}
    public static void ChooseAUser (AndroidDriver driver) {
        List<WebElement> elements = driver.findElements(MobileBy.id("com.google.android.gms:id/account_display_name"));
        if (elements.size() > 0) {
            elements.get(0).click();
        }
    }
}