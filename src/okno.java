import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class okno extends JFrame {
    private pole gameP;
    private int difficult;


    public  pole getGameP(){ return this.gameP;}
    public  void editGameP()

    public  okno(int difficult)
    {
        this.difficult = difficult;
        addKeyListener(new myKey());
        setFocusable(true);

        setBounds(0,0,1920,1080);
        setTitle("game_rocket_with_DORA");
        gameP = new pole(difficult);
        Container con = getContentPane();
        con.add(gameP);
        setVisible(true);
    }
}
