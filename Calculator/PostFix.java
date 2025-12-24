import java.util.Stack;

public class PostFix {
    private String[] postFix=new String[100];

    private int top=-1;

    private Stack<Character> stack=new Stack<>();

    private int precendence(char c){
        switch(c){
            case '+','-':
                return 1;
            case '*','/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public String[] infixToPostFix(String inFix){
        String ops="+*/-^";
        for (int i = 0; i < inFix.length(); i++) {
            char c=inFix.charAt(i);
            if(c==' '){
                continue;
            }else if(Character.isDigit(c)){
                String num="";
                int j=i;
                while(j<inFix.length() && Character.isDigit(inFix.charAt(j))){
                    num+=inFix.charAt(j);
                    j++;
                }
                postFix[++top]=num;
                i=j-1;
            }else if(c=='(') {
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    postFix[++top]=String.valueOf(stack.pop());
                }
                stack.pop();
            } else if (ops.contains(String.valueOf(c))) {
                while (!stack.isEmpty() && precendence(stack.peek()) >= precendence(c)) {
                    postFix[++top] = String.valueOf(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            postFix[++top]=String.valueOf(stack.pop());
        }
        return postFix;
    }
}
