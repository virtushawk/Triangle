package edu.epam.triangle.validator;

public class InputValidator {

    public boolean validateInput(String line){
        String [] data = line.split("\\s+");
        if (data.length != 6){
            return false;
        }
        for (String number: data) {
            if(!isNumber(number)){
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(String number){
        return number.matches("^-?\\d*(\\.\\d+)?$");
    }
}
