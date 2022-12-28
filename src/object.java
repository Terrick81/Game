import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class object {
    public Image img;
    public int x;
    public int y;
    public int Width;
    public int Height;
    double scale;
    public int speed = 6;
    Boolean act;
    private Timer timerUpdate;
    object(Image img, int difficult) {
        timerUpdate = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                down();
            }
        });
        this.img = img;
        act = false;
        speed = difficult * 2;
    }
    void start() {
        timerUpdate.start();
        y = -img.getHeight(null);
        x = (int)(Math.random() * (1920 - img.getWidth(null)));
        act = true;
    }
    void down(){
        if (act == true){
            y += speed;
        }
        if (y > 1080){
            act = false;
        }
    }
    void draw(Graphics gr){
        if (act == true) {
            gr.drawImage(img,x,y,null);
        }
    }
}
