package com.antares_studio.unitconverter;

public class Calculate {
    public Calculate() {

    }
    public float calculate(Integer userAnswer, String operator, float by){
        if (operator.equals("multiply")){
            return userAnswer*by;
        }
        else if (operator.equals("divide")){
            return  userAnswer/by;
        }
        else{
            return userAnswer;
        }
    }
}
