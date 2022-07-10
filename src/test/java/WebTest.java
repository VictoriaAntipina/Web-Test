import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// Тест кейс
// 1. Открыть страницу "https://www.99-bottles-of-beer.net/"
// 2. Нажать пункт меню BrowseLanguages
// 3. Нажать пункт меню Start
// 4. Подтвердить, что пользователь видит заголовок "Welcome to 99 Bottles of Beer"
// 5. Закрыть браюзер

public class WebTest {

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/victoria/Desktop/untitledfolder/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath(
          "//body/div[@id = 'wrap']/div[@id = 'navigation']/ul[@id='menu']/li/a[@ href='/abc.html']")
        );

        menuBrowseLanguages.click();
        //sleep(1000);

        //driver.quit();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );

        menuStart.click();
        //sleep(1000); // задержка на 1 сек, чтоб посмотреть что происходит в браузере
        //driver.quit();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();



    }
}
