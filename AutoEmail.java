import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoEmail {
    public static void main(String[] args) {

        String guruUrl = "http://demo.guru99.com/selenium/newtours/";
        String googleUrl = "https://www.google.com/";
        String gmailURL = "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

        String emailAddr = "webalive.srv@gmail.com";
        String emailPass = "bitmascot@321"; //whsOnd zHQkBf
        String ePassClass = "whsOnd zHQkBf";

        String expectedTitle = "Gmail";
        String actualTitle = "";

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Alvee\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver(); //Create driver object

        //driver.get(guruUrl); //Navigate an url

        //WebElement emailField = driver.findElement(By.className("whsOnd")); //Find an html element object by class name

        //emailField.click(); //mouse click event

        //emailField.sendKeys(“Text you want to set in html element”);

        driver.get(gmailURL);
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys(emailAddr);
        WebElement NxtBtn = driver.findElement(By.id("identifierNext"));
        NxtBtn.click();

        WebElement PassField = driver.findElement(By.name("password")); //whsOnd zHQkBf

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(PassField));
        PassField.sendKeys(emailPass);
        driver.findElement(By.id("passwordNext")).click();

        /*PassField.sendKeys("bitmascot@321");
        System.out.println("Debug: After inserting the password");
        WebElement PassNxtBtn = driver.findElement(By.id("passwordNext"));
        PassNxtBtn.click(); */

        System.out.println(driver.getTitle());

        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.className("T-I J-J5-Ji T-I-KE L3"))); //T-I J-J5-Ji T-I-KE L3 T-I-J0 T-I-JW      L3 T-I-J0
        element1.click();

        /* WebElement comField = driver.findElement(By.className("T-I J-J5-Ji T-I-KE L3"));
        System.out.println("selected compose button");
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until(ExpectedConditions.elementToBeClickable(comField));
        driver.findElement(By.className("T-I J-J5-Ji T-I-KE L3")).click(); */

        driver.close();

    }
}
