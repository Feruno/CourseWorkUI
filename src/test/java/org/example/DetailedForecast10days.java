package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class DetailedForecast10days {
    private WebDriver webDriverDetailedForecast;
    private final String URI = "https://yandex.ru/pogoda/";

    public DetailedForecast10days(WebDriver webDriver) {
        this.webDriverDetailedForecast = webDriver;
        webDriver.get(URI);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Подробный прогноз на 10 дней')] ")
    public WebElement clickField;

    public void clcickDetailedForecast10days() {
        clickField.click();
    }

    public void findTemperatureMorning(Integer countOfDay) {
        List<WebElement> dayTable = webDriverDetailedForecast.findElements(By.xpath("//td[@class='weather-table__body-cell weather-table__body-cell_type_daypart weather-table__body-cell_wrapper']//div[@class='weather-table__daypart']"));
        List<WebElement> tempTable = webDriverDetailedForecast.findElements(By.xpath("//td[@class='weather-table__body-cell weather-table__body-cell_type_daypart weather-table__body-cell_wrapper']//span[@class='temp__value temp__value_with-unit']"));

        int next = 0;
        for (int i = 0; i < countOfDay * 4; i++) {

            if (i % 4 == 0) {
                System.out.println("Следующий День");
            }

            String timeDay = dayTable.get(i).getText();
            String temperatureFirst = tempTable.get(i + next).getText();
            String temperatureSecond = tempTable.get(i + next + 1).getText();
            next++;
            System.out.println("|| Время дня = " + timeDay + " || температура от  " + temperatureFirst + " || температура до  " + temperatureSecond + " ||");
        }
    }
}
