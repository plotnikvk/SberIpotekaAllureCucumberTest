package steps;


import cucumber.api.java.en_old.Ac;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MiddlePage;

/**
 * Create by plotnikvk
 */

public class MiddleSteps {

    MiddlePage middlePage = new MiddlePage();

    @Step("в разделе {0} нажата кнопка {0}")
    public void pressCalculateButton(String item, String subItem){

        WebElement title = BaseSteps.getDriver().findElement(By.xpath("//*[contains(text(),'"+item+"')]"));
        new Actions(BaseSteps.getDriver()).moveToElement(title).build().perform();
        new WebDriverWait(BaseSteps.getDriver(), 20).until(ExpectedConditions.visibilityOf(title));

       WebElement calculateButton = BaseSteps.getDriver().findElement(By.xpath("//*[(text()='"+subItem+"')]/ancestor::a"));
       BaseSteps.getDriver().navigate().to(calculateButton.getAttribute("href"));


    }
}
