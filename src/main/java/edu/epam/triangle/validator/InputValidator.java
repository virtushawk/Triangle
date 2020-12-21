package edu.epam.triangle.validator;

public class InputValidator {
    private static final String DELIMITER = "\\s+";
    private static final String NUMBER_REGEX = "^-?\\d*(\\.\\d+)?$";
    private static final int DATA_LENGTH = 6;

    public boolean validateInput(String line){
        String [] data = line.split(DELIMITER);
        if (data.length != DATA_LENGTH){
            return false;
        }
        int i = 0;
        while (i < data.length) {
            if(!isNumber(data[i])) {
                return false;
            }
            i++;
        }
        return true;
    }
    public boolean isNumber(String number){
        return number.matches(NUMBER_REGEX);
    }
}
