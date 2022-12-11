import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class okno extends JFrame {
    private pole gameP;
    private int difficult;

    class myKey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key_ = e.getKeyCode();
            if(key_ == 65 && gameP.x > 0) {
                gameP.x -= gameP.speed;
            }
            if(key_ == 68 && gameP.x < getWidth() - 160) {
                gameP.x += gameP.speed;
            }

            if(key_ == 27) System.exit(0);
        }
        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }
    public okno(int difficult)
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
