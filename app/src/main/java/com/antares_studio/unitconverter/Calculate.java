package com.antares_studio.unitconverter;

public class Calculate {
    public Calculate() {

    }
    public Integer calculate(Integer userAnswer, String operator, Integer by){
        if (operator.equals("multiply")){
            return userAnswer*by;
        }
        else if (operator.equals("divide")){
            return  userAnswer/by;
        }
        else{
            return null;
        }
    }
}
