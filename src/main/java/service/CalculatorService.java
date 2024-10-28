package service;

public class CalculatorService {
    private String result;
    private String current;
    private char operator;

    public CalculatorService() {
        result = "0";
        current = "0";
        operator = '+';
    }

    public void addToCurrent(char a) {
        if (current.equals("0")) {
            current = "";
        }
        current += a;

    }

    public void deleteFromCurrent(){
        if (current.contains(".")) {
            if (current.charAt(current.length() - 2) == '.') {
                current = current.substring(0, current.length() - 2);
            } else {
                current = current.substring(0, current.length() - 1);
            }
        } else {
            current = current.substring(0, current.length() - 1);
        }

        if(current.equals("")){
            current = "0";
        }
    }

    public void equals() {
        double resultDouble = Double.parseDouble(result);
        if (!current.isEmpty()) {
            switch (operator) {

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
                case '√':
                    resultDouble = Math.sqrt(Double.parseDouble(result));
                    break;
            }
            result = Double.toString(resultDouble);
            if (result.endsWith(".0")) {
                result = result.substring(0, result.length() - 2);
            }
        }
        current = "";
    }

    public void percent(){
        current = Double.toString(Double.parseDouble(current)/100);
        if (current.endsWith(".0")) {
            current = result.substring(0, result.length() - 2);
        }
    }

    public void clearAll(){
        result = "0";
        current = "0";
        operator = '+';
    }

    public void clearEntry(){
        current = "0";
    }



    public void changeSigns(){
        equals();
        if(result.charAt(0) == '-'){
            result = result.substring(1);
        }
        else{
            String temp = "-";
            temp += result;
            result = temp;
        }
    }

    public void startOperation(char o) {
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
