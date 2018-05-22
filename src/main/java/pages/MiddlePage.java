package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;

/**
 * Create by plotnikvk
 */

public class MiddlePage extends BasePageObject {

    public MiddlePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    @FindBy(xpath = "//*[(text()='Рассчитать')]/ancestor::a")
    public WebElement calculateButton;
}

