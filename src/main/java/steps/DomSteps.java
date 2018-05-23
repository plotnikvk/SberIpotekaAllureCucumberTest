package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.DomPage;

public class DomSteps {
    DomPage domPage = new DomPage();

    @Step("проверено, что на открывшейся странице есть заголовок - {0}")
    public void checkTitle(String title){
        Assert.assertEquals("Заголовок не соответствует укзазанному",title, domPage.title.getText());
    }

    @Step("Заполняем поля и проверяем чекбоксы")
    public void send(String field, String value) {

        switch (field) {
            case "Цель кредита":
                domPage.selectCollectionItem(value,domPage.menuOption);
                break;
            case "Стоимость недвижимости":
                domPage.fillField(1,value);
                break;
            case "Первоначальный взнос":
                domPage.fillField(2,value);
                break;
            case "Срок кредита":
                domPage.fillField(3,value);
                break;
            case "Есть зарплатная карта Сбербанка":
                domPage.fillCheckBox(0,value);
                break;
            case "Страхование жизни":
                domPage.fillCheckBox(1,value);
                break;
            case "Электронная регистрация":
                domPage.fillCheckBox(2,value);
                break;
            case "Скидка от застройщика":
                domPage.fillCheckBox(3,value);
                break;
            default:
                Assert.fail("Такого поля не существует");
        }
    }

    public void check(String name, String value) {
        switch(name){
            case"Сумма кредита":
                domPage.checkField(0,value);
                break;
            case"Ежемесячный платеж":
                domPage.checkField(1,value);
                break;
            case"Необходимый доход":
                domPage.checkField(2,value);
                break;
            case"Процентная ставка":
                domPage.checkField(3,value);
                break;
            default:
                Assert.fail("Нет такого поля для проверки");
        }
    }
}
