    import javax.swing.*;
    import java.awt.*;
    import java.util.Arrays;

    public class Main {
        public static void main(String[] args){
            PostFix postFix=new PostFix();
            Evaluation evaluation=new Evaluation();
            String[][] keys=new String[][]{
                    {"AC","DE","*","/"},
                    {"9","8","7","+"},
                    {"6","5","4","-"},
                    {"3","2","1","^"},
                    {"0","(",")","="}
            };
            JFrame frame=new JFrame();
            frame.setLayout(new BorderLayout());

            TextField textField=new TextField(20);
            textField.setEditable(true);

            JPanel panel =new JPanel();
            panel.setLayout(new GridLayout(5,4));

            for (int i = 0; i < keys.length; i++) {
                for (int j = 0; j < keys[0].length; j++) {
                    Button btn=new Button(keys[i][j]);
                    btn.addActionListener((e)->{
                        if(btn.getLabel()=="="){
                            String infixExp=textField.getText();
                            String[] postFixExp=postFix.infixToPostFix(infixExp);
                            try{
                                double result= evaluation.evaluate(postFixExp);
                                textField.setText(String.valueOf(result));
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage());
                            }
                        } else if (btn.getLabel()=="AC") {
                            textField.setText("");
                        } else if (btn.getLabel()=="DE") {
                            String exp=textField.getText();
                            exp=exp.substring(0,exp.length()-1);
                        } else{
                            String exp=textField.getText();
                            exp+= btn.getLabel();
                            textField.setText(exp);
                        }
                    });
                    panel.add(btn);
                }
            }

            frame.add(textField,BorderLayout.NORTH);
            frame.add(panel,BorderLayout.CENTER);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setSize(250,350);
            frame.show();
        }
    }
