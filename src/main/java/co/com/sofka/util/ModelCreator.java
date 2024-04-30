package co.com.sofka.util;

import co.com.sofka.model.AlertsModel;
import co.com.sofka.model.FormModel;
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
}
