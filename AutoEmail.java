import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoEmail {
    public static void main(String[] args) {
        String guruUrl = "http://demo.guru99.com/selenium/newtours/";
        String googleUrl = "https://www.google.com/";
        String gmailURL = "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

        String emailAddr = "alvee.bit03@gmail.com";
        String emailPass = "pass_here"; //whsOnd zHQkBf emailToAddress
        String emailToAddress = "tabassumwazed@gmail.com";
        String emailSubject = "Email Sujbect Text";
        String emailBody = "This is an automated email using java webdriver. " +
                "Lorem ipsum dolor sit amet proin gravida. Lorem ipsum dolor sit amet proin gravida. " +
                "Lorem ipsum dolor sit amet proin gravida. Lorem ipsum dolor sit amet proin gravida. ";

        String ePassClass = "whsOnd zHQkBf";

        String expectedTitle = "Gmail";
        String actualTitle = "";

        System.setProperty("webdriver.chrome.driver", //webdriver.gecko.driver, instead chrome driver
                "D:\\Softs\\Java_WebDriver\\chromedriver.exe");   // Set GChrome Driver class path
        WebDriver driver = new ChromeDriver(); //Create a instance of GChromeDriver
            driver.get(gmailURL); //Navigate an url
        
        /*
        System.setProperty("webdriver.gecko.driver", //webdriver.gecko.driver, instead chrome driver
                "C:\\Users\\Alvee\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");   // Set Fire fox Driver class path
        WebDriver driver = new FirefoxDriver(); //Create a instance of FireFox Driver
        */

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

        try {
            Thread.sleep(3000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        WebElement PassField = driver.findElement(By.name("password")); //whsOnd zHQkBf

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(PassField));
        PassField.sendKeys(emailPass);
        driver.findElement(By.id("passwordNext")).click();

        System.out.println(driver.getTitle() + " and the password inserted" );

        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[text()='COMPOSE']")));
        //T-I J-J5-Ji T-I-KE L3 T-I-J0 T-I-JW      L3 T-I-J0  T-I J-J5-Ji T-I-KE L3
        element1.click();

        try {
            Thread.sleep(9000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        driver.findElement(By.xpath(".//textarea[@class='vO' and @name='to']")).sendKeys(emailToAddress); // //*[@id=":lb"] instead of //*[@id=':lb']
        System.out.println("Inserted to address");
        driver.findElement(By.xpath(".//input[@name='subjectbox']")).sendKeys(emailSubject);
        System.out.println("Inserted to subject");
        driver.findElement(By.xpath(".//div[@class='Am Al editable LW-avf']")).sendKeys(emailBody);
        System.out.println("Inserted to email body");

        driver.findElement(By.xpath(".//div[@data-tooltip='Send \u202A(Ctrl-Enter)\u202C']")).click();

        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent");

        driver.close();
    }
}
