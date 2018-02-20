import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoEmail {
    public static void main(String[] args) {

        String gmailURL = "https://accounts.google.com/signin/v2/" +
                "identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&l" +
                "tmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

        String emailAddr = "alvee.bit03@gmail.com";
        String emailPass = "Alvee_123";
        String emailToAddress = "anowar@bitmascot.com";
        String emailSubject = "Hello From Java Automation";
        String emailBody = "Hello bro, \n \nThis is an automated email using java webdriver. \n \n" +
                "Lorem ipsum dolor sit amet proin gravida. Lorem ipsum dolor sit amet proin gravida. " +
                "Lorem ipsum dolor sit amet proin gravida. Lorem ipsum dolor sit amet proin gravida.  \n \nBest Regards, \nAuto Email.";

        String expectedTitle = "Gmail";
        String actualTitle = "";

/*        System.setProperty("webdriver.gecko.driver", //webdriver.gecko.driver, instead chrome driver
                "C:\\Users\\Alvee\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");   // Set Fire fox Driver class path
        WebDriver driver = new FirefoxDriver(); //Create a instance of FireFox Driver
*/
        System.setProperty("webdriver.chrome.driver", //webdriver.gecko.driver, instead chrome driver
                "C:\\Users\\Alvee\\Downloads\\geckodriver-v0.19.1-win64\\chromedriver.exe");   // Set Fire fox Driver class path
        WebDriver driver = new ChromeDriver(); //Create a instance of Google Chrome Driver


        driver.get(gmailURL); //Navigate to an url

        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){  // to check if the titles matched for the desired page
            System.out.println("Test passed for given title!");
        } else {
            System.out.println("Test failed for given title");
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

        WebElement PassField = driver.findElement(By.name("password")); //element chosen by name

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(PassField));
        PassField.sendKeys(emailPass);
        driver.findElement(By.id("passwordNext")).click();

        System.out.println("Page Title: " + driver.getTitle() + " and the password has been inserted" );

        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[text()='COMPOSE']")));
        //T-I J-J5-Ji T-I-KE L3 T-I-J0 T-I-JW      L3 T-I-J0  T-I J-J5-Ji T-I-KE L3
        element1.click();
        System.out.println("Email composing");

        try {
            Thread.sleep(2000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        WebDriverWait wait2 = new WebDriverWait(driver, 15);
        WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//textarea[@class='vO' and @name='to']")));
        element2.sendKeys(emailToAddress);
        System.out.println("Inserted to address");

        driver.findElement(By.xpath(".//input[@name='subjectbox']")).sendKeys(emailSubject);
        System.out.println("Inserted to subject");

        driver.findElement(By.xpath(".//div[@class='Am Al editable LW-avf']")).sendKeys(emailBody); // ****************
        System.out.println("Inserted to email body");

        driver.findElement(By.xpath(".//div[@data-tooltip='Send \u202A(Ctrl-Enter)\u202C']")).click();

        try {
            Thread.sleep(2000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent");

        driver.close();
    }
}