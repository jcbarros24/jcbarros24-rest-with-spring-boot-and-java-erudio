package com.example.demo;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", 
            method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne, 
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    

    private Double convertToDouble(String number) {
        if (number == null)
            return 0D;
        // BR 21,24 US 21.24
        String numbeString = number.replaceAll(",",".");
        if (isNumeric(numbeString)) 
            return Double.parseDouble(numbeString);
        return 0D;
    }


    private boolean isNumeric(String number){
        if (number == null)
            return false;
            String numbeString = number.replaceAll(",",".");
        return numbeString.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
