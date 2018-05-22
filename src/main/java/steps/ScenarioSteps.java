package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    MiddleSteps middleSteps = new MiddleSteps();
    DomSteps domSteps = new DomSteps();

    @When("^в меню \"(.+)\" выбрано \"(.+)\"$")
    public void chooseItem(String menuItem, String subMenuItem){
        mainSteps.chooseItem(menuItem, subMenuItem);
    }

    @When("^в разделе \"(.+)\" нажата кнопка \"(.+)\"$")
    public void pressCalculateButton(String item, String subItem){
        middleSteps.pressCalculateButton(item , subItem);
    }

    @Then("^проверено, что на открывшейся странице есть заголовок - \"(.+)\"$")
    public void checkTitle(String title){
        domSteps.checkTitle(title);
    }

    @When("^заполнены поля и чекбоксы:$")
    public void sendField(DataTable data) {
        data.asMap(String.class, String.class).forEach((field, value) -> domSteps.send(field, value));
    }

    @Then("^проверены поля:$")
    public void checkField(DataTable data){
        data.asMap(String.class,String.class).forEach((name,value)->domSteps.check(name,value));
    }

}
