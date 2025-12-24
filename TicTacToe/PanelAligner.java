import javax.swing.*;
import java.awt.*;

public class PanelAligner {
    private static String[][] blocks=new String[][] {
        {"","",""},
        {"","",""},
        {"","",""},
    };;
    private static int counter =0;
    private JFrame frame;
    private GameLogic gameLogic=new GameLogic();

    public PanelAligner(JFrame frame) {
        this.frame = frame;
    }
    public void fillPanel( JPanel panel){
        for (int i = 0; i < blocks.length; i++) {
            for (int j=0;j< blocks[0].length;j++){
                JButton btn=new JButton(blocks[i][j]);
                btn.setBackground(Color.WHITE);
                btn.setForeground(Color.BLACK);
                btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                int row=i,col=j;
                btn.setOpaque(true);
                btn.setBorderPainted(true);
                btn.setContentAreaFilled(true);
                btn.addActionListener((e)->{
                    fillButton(btn,row,col,panel);
                });
                panel.add(btn);
            }
        }
    }
    public void fillButton(JButton btn,int i,int j,JPanel panel){
        if (counter % 2 == 0) {
            btn.setText("X");
            btn.setForeground(Color.BLUE);
            blocks[i][j] = "X";
        } else {
            btn.setText("O");
            btn.setForeground(Color.RED);
            blocks[i][j] = "O";
        }
        counter+=1;
        String res=gameLogic.whoIsWinner(blocks);
        System.out.println(res);
        if(res.equals("X")){
            JOptionPane.showMessageDialog(frame,"X is winner" );
            counter=0;
            setEmpty(panel);
        }else if (res.equals("O")){
            JOptionPane.showMessageDialog(frame,"O is winner");
            counter=0;
            setEmpty(panel);
        }
        if (counter == 9) {
            JOptionPane.showMessageDialog(frame,"Drawn");
            counter=0;
            setEmpty(panel);
        }
        btn.setEnabled(false);
    }
    public void setEmpty(JPanel panel){
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                blocks[k][l]="";
            }
            System.out.println();
        }
        panel.removeAll();
        fillPanel(panel);
        panel.revalidate();
        panel.repaint();
    }
}
