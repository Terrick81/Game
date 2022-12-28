import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public pole gameP;

    public int difficult;

    public void window(int difficult)
    {
        this.difficult = difficult;
        addKeyListener(new MyKey());
        setFocusable(true);

        setBounds(0,0,1920,1080);
        setTitle("game_rocket_with_DORA");
        gameP = new pole(difficult);

        Container con = getContentPane();
        con.add(gameP);
        setVisible(true);
    }
}
