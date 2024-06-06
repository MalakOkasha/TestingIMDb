import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    @Test
    public void scenario1() throws Exception
    {
        System.setProperty("webdriver.chrome.driver","D:\\Uni\\Semester 6\\Testing\\Selenium Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //maximize the window
        webDriver.manage().window().maximize();

        webDriver.navigate().to("https://www.imdb.com/");

        // sending the movie name
        webDriver.findElement(By.id("suggestion-search")).sendKeys("The Shawshank Redemption");
        Thread.sleep(2000);

        // clicking the search button
        webDriver.findElement(By.id("suggestion-search-button")).click();

        //verifying that the first search result is "The Shawshank Redemption" movie
        String actualValue = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/div/div[1]/section[2]/div[2]/ul/li[1]/div[2]/div/a")).getText();
        String expetedValue ="The Shawshank Redemption";
        Assert.assertEquals(expetedValue, actualValue);

        Thread.sleep(5000);
        webDriver.quit();
    }
    @Test
    public void scenario2() throws Exception
    {
        System.setProperty("webdriver.chrome.driver","D:\\Uni\\Semester 6\\Testing\\Selenium Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //maximize the window
        webDriver.manage().window().maximize();

        webDriver.navigate().to("https://www.imdb.com/");

        //click on menu
        webDriver.findElement(By.xpath("//*[@id=\"imdbHeader-navDrawerOpen\"]/span")).click();
        Thread.sleep(2000);

        //click on top 250
        webDriver.findElement(By.xpath("//*[@id=\"imdbHeader\"]/div[2]/aside[1]/div/div[2]/div/div[1]/span/div/div/ul/a[2]/span")).click();
        Thread.sleep(2000);

        //verify that the page should display a list of the Top 250 Movies.
        String actualValue = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[1]/div/div[2]/hgroup/h1")).getText();
        String expetedValue ="IMDb Top 250 Movies";
        Assert.assertEquals(expetedValue, actualValue);

        //verify that the first movie in the list should be "The Shawshank Redemption"
         actualValue = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]/div[2]/div/div/div[1]/a/h3")).getText();
         expetedValue ="1. The Shawshank Redemption";
        Assert.assertEquals(expetedValue, actualValue);

        Thread.sleep(5000);
        webDriver.quit();

    }
    @Test
    public void scenario3() throws Exception
    {
        System.setProperty("webdriver.firefox.driver","D:\\Uni\\Semester 6\\Testing\\Selenium Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();


        //maximize the window
        webDriver.manage().window().maximize();

        webDriver.navigate().to("https://www.imdb.com/");

        //click on (All) beside the search bar
        webDriver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[1]/div/label/span")).click();
        Thread.sleep(2000);

        //click on advanced search
        webDriver.findElement(By.linkText("Advanced Search")).click();

        //verify that the page title is Advanced title search
        String actualValue = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/section/div/section/div/hgroup/h1")).getText();
        String expectedValue ="Advanced title search";
        Assert.assertEquals(expectedValue, actualValue);

        //selects "Movie" as title type
        webDriver.findElement(By.xpath("//*[@id=\"titleTypeAccordion\"]/div[1]/label")).click();
        webDriver.findElement(By.xpath("//*[@id=\"accordion-item-titleTypeAccordion\"]/div/section/button[1]")).click();
        Thread.sleep(2000);

        // scroll to Ratings Accordion
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"ratingsAccordion\"]/div[1]/label"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

        //select "Action" as Genre type
        webDriver.findElement(By.xpath("//*[@id=\"genreAccordion\"]/div[1]/label")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[3]/section/section/div/section/section/div[2]/div/section/div[2]/div[1]/section/div/div[6]/div[2]/div/section/button[1]")).click();
        Thread.sleep(2000);

        // scroll to ratings
        element = webDriver.findElement(By.xpath("//*[@id=\"titleTypeAccordion\"]/div[1]/label/span[1]/div"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

        //Release date
        webDriver.findElement(By.xpath("//*[@id=\"releaseDateAccordion\"]/div[1]/label")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[3]/section/section/div/section/section/div[2]/div/section/div[2]/div[1]/section/div/div[3]/div[2]/div/div/div[2]/div[1]/div/div/div/input")).sendKeys("2010");
        webDriver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[3]/section/section/div/section/section/div[2]/div/section/div[2]/div[1]/section/div/div[3]/div[2]/div/div/div[2]/div[2]/div/div/div/input")).sendKeys("2020");
        Thread.sleep(2000);

        // click see result
        webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/section/div/section/section/div[2]/div/section/div[1]/button")).click();

        // Verify the presence of the sorting option for Popularity
        Thread.sleep(2000);
        actualValue = webDriver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[3]/section/section/div/section/section/div[2]/div/section/div[2]/div[2]/div[1]/div[2]/div/span/span/select")).getText();

        // Extracting the first word
        String[] words = actualValue.split("\\s+");
        String firstWord = words[0];

        expectedValue = "Popularity";
        Assert.assertEquals(expectedValue, firstWord) ;

        Thread.sleep(5000);
        webDriver.quit();
    }
}
