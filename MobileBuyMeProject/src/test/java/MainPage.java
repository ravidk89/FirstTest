import com.sun.glass.events.SwipeGesture;
import com.sun.xml.internal.bind.v2.model.core.Element;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import javafx.scene.input.SwipeEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import java.time.Duration;
import java.util.HashMap;
//import javax.xml.datatype.Duration;

public class MainPage {
    public static void EnterReceiver(AndroidDriver driver) {
        driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/toEditText")).sendKeys("Moriel");
    }
    public static void EnterABlessing(AndroidDriver driver) {
        driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/blessEditText")).sendKeys("Have a good week");

    }
    public static void EnterSenderName(AndroidDriver driver) {
        driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/userFrom")).sendKeys(":)");
    }
   public static void ClickDown(AndroidDriver driver) throws InterruptedException {
      System.out.println(driver.manage().window().getSize().getWidth());
      System.out.println(driver.manage().window().getSize().getHeight());

      TouchAction action = new TouchAction(driver);
       long noOfMillis = 100;
       Duration oneHundreadMillisDuration = Duration.ofMillis(noOfMillis);
       LongPressOptions longPressOptions = new LongPressOptions();
       PointOption frompointoption = new PointOption();
       Thread.sleep(5000);
       frompointoption.withCoordinates(600,800);
       PointOption topointoption = new PointOption();
       topointoption.withCoordinates(200,400);
       longPressOptions.withDuration(oneHundreadMillisDuration).withPosition(frompointoption).build();
       action.longPress(longPressOptions).moveTo(topointoption).release().perform();
   }
    public static void PressContinue(AndroidDriver driver) {
       driver.findElement(MobileBy.id("il.co.mintapp.buyme:id/goNextButton")).click();
    }
}
