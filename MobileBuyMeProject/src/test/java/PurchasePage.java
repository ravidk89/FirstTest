import com.sun.org.apache.xpath.internal.operations.Plus;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
public class PurchasePage {
    public static void PressButtonPurchase(AndroidDriver driver) {
       driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/nowRadioButton")).click();
    }
    public static void PickEmail(AndroidDriver driver) {
        List<WebElement> checkbox = new ArrayList<WebElement>();
        checkbox = driver.findElements(By.id("il.co.mintapp.buyme:id/optionCheckBox"));
        checkbox.get(0).clear(); // no clicks on "first"
        checkbox.get(1).clear(); // no clicks on "second"
        checkbox.get(2).click(); // clicks on "third"
        }
    public static void EnterEMail(AndroidDriver driver) {
        driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("Ravid08pk9@gmail.com");
    }
    public static void Continue(AndroidDriver driver) {
        driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/goNextButton")).click();
    }
}
