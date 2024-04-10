package com.example.demo;

//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mathOperations.MathLogicOperations;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {

    //private final AtomicLong counter = new AtomicLong();      
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", 
            method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne, 
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{

        return MathLogicOperations.sum(numberOne, numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", 
            method=RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne, 
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{

        return MathLogicOperations.sub(numberOne, numberTwo);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", 
            method=RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne, 
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{

        return MathLogicOperations.multiplication(numberOne, numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", 
            method=RequestMethod.GET)
    public Double division(
            @PathVariable(value = "numberOne") String numberOne, 
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{

        return MathLogicOperations.division(numberOne, numberTwo);
    }

    @RequestMapping(value = "/medium/{numberOne}/{numberTwo}", 
            method=RequestMethod.GET)
    public Double medium(
            @PathVariable(value = "numberOne") String numberOne, 
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception{

        return MathLogicOperations.medium(numberOne, numberTwo);
    }

    @RequestMapping(value = "/squareRoot/{numberOne}", 
            method=RequestMethod.GET)
    public Double square(
            @PathVariable(value = "numberOne") String numberOne
        ) throws Exception{

        return MathLogicOperations.squareRoot(numberOne);
    } 

}
