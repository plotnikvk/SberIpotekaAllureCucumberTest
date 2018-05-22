package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class DomPage extends BasePageObject {
    public DomPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);

    @FindBy(xpath = "//h1")
    public WebElement title;

    @FindBy(xpath = ".//div[@class = 'dcCalc_frame']//div[contains(text()," +
            " 'Цель кредита')]/following-sibling::div//input[@class = 'dcCalc_textfield__input']")
    public WebElement menuButton;

    @FindBy(xpath = ".//div[@class = 'Select-menu']/div[@role = 'option']")
    public List<WebElement> menuOption;

    @FindBy(xpath = "//input[contains(@class,'dcCalc')]")
    public List<WebElement> fields;

    @FindBy(xpath = "//input[@type='checkbox']/ancestor::label")
    List<WebElement>checkBoxes;

    @FindBy(xpath = "//div[contains(@class,'result')]//span")
    public List<WebElement> fieldsWithResults;


    @Override
    public void selectCollectionItem(String itemName, List<WebElement> collection) {
        new Actions(BaseSteps.getDriver()).moveToElement(menuButton);
        wait.until(ExpectedConditions.visibilityOf(menuButton));
        wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuButton.click();
        wait.until(ExpectedConditions.visibilityOf(menuOption.get(0)));

        for (WebElement item : menuOption) {
            if (item.getText().equals(itemName)) {
                item.click();
                return;
            }
        }
    }


    public void fillField(int i, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(fields.get(i)));
        fields.get(i).click();
        fields.get(i).clear();
        fields.get(i).sendKeys(value);
        try { Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
         fields.get(i).sendKeys(Keys.ENTER);

    }

    public void fillCheckBox(int i, String value) {
        wait.until(ExpectedConditions.visibilityOf(checkBoxes.get(i)));
        if (value.equals("true")){
            if (checkBoxes.get(i).isSelected()){
                checkBoxes.get(i).click();
            } else {
                return;
            }
        }
       else if(value.equals("false")){
            if(checkBoxes.get(i).isSelected()){
                return;
            }
            else checkBoxes.get(i).click();
        }
    }

    public void checkField(int i,String expected)
    {
        new Actions(BaseSteps.getDriver()).moveToElement(fieldsWithResults.get(i));
        Assert.assertTrue(String.format("В поле рассчитано значение %s. Ожидалось - %s", fieldsWithResults.get(i).getText(),
                expected), wait.until((ExpectedCondition<Boolean>) driver -> {
            String actualResult =  fieldsWithResults.get(i).getText();
            return actualResult.equalsIgnoreCase(expected);}));
    }
}

