import java.util.Stack;

public class Evaluation {
    private Stack<Double> stack=new Stack<>();

    public double evaluate(String[] postFix) throws Exception{
        for (int i = 0; i < postFix.length && postFix[i]!=null; i++) {
            String str=postFix[i];
            if(str.matches("\\d+")){
                stack.push(Double.parseDouble(str));
            }else{
                double no2=stack.pop();
                double no1=stack.pop();
                double res;
                if (str.equals("+")){
                    res=no1+no2;
                } else if (str.equals("*")) {
                    res=no1*no2;
                } else if (str.equals("-")) {
                    res=no1-no2;
                } else if (str.equals("/")) {
                    if (no1>no2 && no2!=0){
                        res=no1/no2;
                    }else{
                        throw new Exception("Division is not possible");
                    }
                } else if(str.equals("^")){
                    res=Math.pow(no1,no2);
                }else{
                    throw new Exception("Operator Not Valid");
                }
                stack.push(res);
            }
        }
        if(stack.size()>1){
            throw new Exception("Invalid Expression");
        }
        return stack.pop();
    }
}
