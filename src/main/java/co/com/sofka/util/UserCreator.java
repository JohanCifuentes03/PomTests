package co.com.sofka.util;

import co.com.sofka.model.FormModel;
import com.github.javafaker.Faker;

public class UserCreator {
    public static FormModel createUser(){
        Faker faker = new Faker();
        FormModel user = new FormModel();
        user.setName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setMobileNumber(faker.bothify("##########"));
        user.setSubject(faker.howIMetYourMother().catchPhrase());
        user.setAddress(faker.address().fullAddress());
        return user;
    }
}
