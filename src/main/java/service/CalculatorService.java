package service;

public class CalculatorService {
    private String result;
    private String current;
    private char operator;
    public CalculatorService(){
        result = "0";
        current = "0";
        operator = '+';
    }

    public void addToCurrent(char a){
        if(current.equals("0")){
            current = "";
            current += a;
        }
        else{
            current += a;
        }
    }

    public void equals(){
        double resultDouble = Double.parseDouble(result);
        switch(operator){

            case '+':
                resultDouble += Double.parseDouble(current);
                break;
            case '-':
                resultDouble -= Double.parseDouble(current);
                break;
            case '*':
                resultDouble *= Double.parseDouble(current);
                break;
            case '/':
                resultDouble /= Double.parseDouble(current);
                break;
        }
        result = Double.toString(resultDouble);
        if(result.endsWith(".0")){
            result = result.substring(0, result.length()-2);
        }

    }

    public void startOperation(char o){
        equals();
        current = "0";
        operator = o;
    }

    public String getResult() {
        return result;
    }

    public String getCurrent() {
        return current;
    }

    public char getOperator() {
        return operator;
    }
}
