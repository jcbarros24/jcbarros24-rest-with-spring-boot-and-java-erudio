package com.mathOperations;

import com.example.demo.exceptions.UnsupportedMathOperationException;

public class MathLogicOperations {

    public static Double sum(String numberOne, String numberTwo){ 
        if (!isNumericDouble(numberOne) || !isNumericDouble(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public static Double sub(String numberOne, String numberTwo){ 
        if (!isNumericDouble(numberOne) || !isNumericDouble(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public static Double multiplication(String numberOne, String numberTwo){ 
        if (!isNumericDouble(numberOne) || !isNumericDouble(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public static Double division(String numberOne, String numberTwo){ 
        if (!isNumericDouble(numberOne) || !isNumericDouble(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public static Double medium(String numberOne, String numberTwo){ 
        if (!isNumericDouble(numberOne) || !isNumericDouble(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public static Double squareRoot(String numberOne){ 
        if (!isNumericDouble(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(numberOne));
    }
    
    public static Double convertToDouble(String number) {
        if (number == null)
            return 0D;
        // BR 21,24 US 21.24
        String numbeString = number.replaceAll(",",".");
        if (isNumericDouble(numbeString)) 
            return Double.parseDouble(numbeString);
        return 0D;
    }

    public static boolean isNumericDouble(String number){
        if (number == null)
            return false;
        String numbeString = number.replaceAll(",",".");
        return numbeString.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
