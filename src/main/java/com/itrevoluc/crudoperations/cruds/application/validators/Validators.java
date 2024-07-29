package com.itrevoluc.crudoperations.cruds.application.validators;

import java.util.ArrayList;
import java.util.List;

public class Validators {
    public static List<String> validMinLength(String property,String value,int minLength){
        List<String> errors = new ArrayList<>();
        if(value.isBlank()){
            errors.add(property+" cannot be blank");
        }
        if(value.length()<=minLength){
            errors.add(property+" needs at least "+minLength+" characters");
        }
        return errors;
    }
}
