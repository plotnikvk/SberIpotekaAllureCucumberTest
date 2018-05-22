package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.util.List;

/**
 * Create by plotnikvk
 */

public class MainSteps {

    MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(),10 );

    @Step("в меню {0}  выбрано {0}")
    public void chooseItem(String item, String subItem)  {

        BaseSteps.getDriver().findElement(By.xpath("//a[@aria-label='Раздел "+item+"']")).click();
        List<WebElement> finishedHouses = BaseSteps.getDriver().findElements(By.xpath("//*[contains(text(),'"+subItem+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(finishedHouses.get(0)));
        if (finishedHouses.get(0).isDisplayed()) {
            finishedHouses.get(0).click();
        } else {
            Assert.fail("Нет такого подменю: " + subItem);
        }
    }
}
