package co.com.sofka.util;

import co.com.sofka.model.AlertsModel;
import co.com.sofka.model.FormModel;
import co.com.sofka.model.WebTableModel;
import com.github.javafaker.Faker;

public class ModelCreator {
    private static final Faker faker = new Faker();
    public static FormModel createUser(){
        FormModel user = new FormModel();
        user.setName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setMobileNumber(faker.bothify("##########"));
        user.setSubject(faker.howIMetYourMother().catchPhrase());
        user.setAddress(faker.address().fullAddress());
        return user;
    }

    public static AlertsModel createAlertsModel(){
        AlertsModel alertsModel = new AlertsModel();
        alertsModel.setPromptMessage(faker.howIMetYourMother().catchPhrase());
        return alertsModel;
    }
    public static WebTableModel createWebTableModel(){
        WebTableModel webTableModel = new WebTableModel();
        webTableModel.setFirstName(faker.name().firstName());
        webTableModel.setLastName(faker.name().lastName());
        webTableModel.setAge(Integer.parseInt(faker.numerify("##")));
        webTableModel.setEmail(faker.internet().emailAddress());
        webTableModel.setSalary(Integer.parseInt(faker.numerify("######")));
        webTableModel.setDepartment(faker.address().cityName());
        return  webTableModel;
    }
}
