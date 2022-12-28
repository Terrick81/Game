import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class myKey implements KeyListener {
    private int offset;
    public void keyPressed(KeyEvent e) {
        int key_ = e.getKeyCode();
        if(key_ == 65 && gameP.getX() > 0) {
            offset = gameP.getSpeed();
        }
        if(key_ == 68 && gameP.getX() < okno.getWidth() - 160) {
            offset = -gameP.getSpeed();
        }

        if(key_ == 27) System.exit(0);
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
