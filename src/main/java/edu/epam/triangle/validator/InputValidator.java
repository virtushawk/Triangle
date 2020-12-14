package edu.epam.triangle.validator;

public class InputValidator {
    private static final String SPLIT_BY = "\\s+";
    private static final String NUMBER_REGEX = "^-?\\d*(\\.\\d+)?$";
    private static final int DATA_LENGTH = 6;

    public boolean validateInput(String line){
        String [] data = line.split(SPLIT_BY);
        if (data.length != DATA_LENGTH){
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
        return number.matches(NUMBER_REGEX);
    }
}
