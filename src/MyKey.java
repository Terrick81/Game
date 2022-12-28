import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKey implements KeyListener {
    Window window = new Window();

    pole Pole = new pole(window.difficult);

    //pole gameP = pole.x;

    int x = Pole.x;

    int speed = Pole.speed;

    public void keyPressed(KeyEvent e) {
        int key_ = e.getKeyCode();


        if(key_ == 65 && x > 0) {
            x -= speed;
            System.out.println("АЛЁЁЁЁ");
            System.out.println(x + " - " + speed);
        }

        if(key_ == 68 && x < 1920) {
            x += speed;
            System.out.println("АЛЁЁЁЁ");
            System.out.println(x + " - " + speed);
        }

        if(key_ == 27) System.exit(0);
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}
}
