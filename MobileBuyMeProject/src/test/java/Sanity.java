import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Sanity {
    private static AndroidDriver<MobileElement> driver;
    private static AndroidDriver androidDriver;
    private static AndroidDriver wait;
    private static ExtentReports extent ;
    private static ExtentTest test ;

    @BeforeClass
    //Run App and open
    public static void beforclassSetUp() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability("appPackage", "il.co.mintapp.buyme");
        capabilities.setCapability("appActivity", "il.co.mintapp.buyme.activities.common.SplashScreen");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\user\\BuyMeReport");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("MyFirstTest", "Sample description");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Ravid");
        test.log(Status.INFO, "@Before class");
    }
    //This is a Registration Page for BuyMe App
    @Test
    public void A_registration_1() throws InterruptedException, IOException {
       // RegistrationPage.ClickRegistration(driver);
        RegistrationPage.ChooseGoogleLogin(driver);
        RegistrationPage.ChooseAUser(driver);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Thread.sleep(700);
    }
    //Searching for gift by choosing its parameters
    @Test
    public void B_Homescreen_2() throws InterruptedException, IOException {
        HomeScreen.PickACatagory(driver);
        HomeScreen.PickABuisness(driver);
        HomeScreen.EnterGiftBudget(driver);
        HomeScreen.PressButtonContinue(driver);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String currentTime = String.valueOf(System.currentTimeMillis());
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\user\\Desktop\\MobileBuyMeProject" + currentTime)).build());
    }
    //We Pick Price and Blessing for the gift card
    @Test
    public void C_MainPage_3() throws InterruptedException, IOException {
        MainPage.EnterReceiver(driver);
        MainPage.EnterABlessing(driver);
        MainPage.EnterSenderName(driver);
       MainPage.ClickDown(driver);
        MainPage.PressContinue(driver);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    }
    //Completing form of Sender & Receiver details
    @Test
    public void D_PurchasePage_4() throws InterruptedException, IOException {
        PurchasePage.PressButtonPurchase(driver);
        PurchasePage.PickEmail(driver);
        PurchasePage.EnterEMail(driver);
        PurchasePage.Continue(driver);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    }
    //After we finish preparing the Gift Card, We can close the App
    @AfterClass
    public static void Close_5(){
        driver.closeApp();
        driver.quit();
        extent.flush();
    }
    //Take Screen Shot
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}
