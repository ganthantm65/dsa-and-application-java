import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        JFrame frame=new JFrame();
        frame.setLayout(new BorderLayout());
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(3,3));

        JPanel panel1=new JPanel(new FlowLayout());
        JLabel l1=new JLabel("User 1:X");
        l1.setForeground(Color.white);
        panel1.add(l1);
        JLabel l2=new JLabel("User 2:O");
        l2.setForeground(Color.white);
        panel1.add(l2);
        panel1.setBackground(Color.BLACK);
        panel.setBackground(Color.BLACK);
        frame.add(panel1,BorderLayout.NORTH);

        new PanelAligner(frame).fillPanel(panel);

        frame.add(panel,BorderLayout.CENTER);
        frame.getContentPane().setBackground(new Color(0,0,0));
        frame.setSize(300,300);
        frame.setResizable(false);
        frame.show();
    }
}
