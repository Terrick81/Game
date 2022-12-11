import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class pole extends JPanel {
    int x = 400;
    int y = 1080-531;
    int score = 0;
    int Height_R;
    int Width_R;
    int speed = 10;
    byte life = 3;
    int difficult;
    object[] gameObject = new object[10];
    int col_Img = 15;
    Image[] Images = new Image[col_Img];
    int firelevel = 9;

    byte shild = 0;
    byte timespeed = 0;
    byte cooldown_speed = random(5,15);
    byte cooldown_shild = random(5,15);
    byte cooldown_repair = random(5,15);
    Timer timerUpdate, timerDraw, helpers_timer;
    public pole (int difficult){
        this.difficult = difficult;

        helpers_timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (shild > 0) shild--;
                if (timespeed > 0) timespeed--;
                else speed = 10;
                if (cooldown_speed > 0) cooldown_speed--;
                if (cooldown_shild > 0) cooldown_shild--;
                if (cooldown_repair > 0) cooldown_repair--;
            }
        });
        helpers_timer.start();

        timerUpdate = new Timer(2200-200*difficult, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStart();
                score += difficult/2;

            }
        });

        timerUpdate.start();

        timerDraw = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDraw.start();
        for (int i = 0; i < 10; i++){
            try{
                gameObject[i] = new object(ImageIO.read(new File("C:\\users\\Terre\\IdeaProjects\\game_1\\images\\" + i + ".png")), difficult);
            }
            catch (IOException exp){
                System.out.println("одна из картинок не загрузилась");
            }
        }
        for (int i = 0; i < col_Img; i++){
            try{
                Images[i] = ImageIO.read(new File("C:\\users\\Terre\\IdeaProjects\\game_1\\images\\1" + i + ".png"));
            }
            catch (IOException exp){System.out.println("одна из картинок не загрузилась!");}
        }
        Height_R = Images[6].getHeight(null);
        Width_R = Images[6].getWidth(null);
    }

    public void paintComponent(Graphics gr) // Метод, который рисует содержимое панели окна
    {
        super.paintComponent(gr);
        gr.drawImage(Images[0],0,0,null);
        gr.drawImage(Images[9-life], x, y,  null);
        if (firelevel == 14) firelevel = 9;
        gr.drawImage(Images[firelevel], x+25, y + Height_R,  null);
        firelevel ++;
        for (int i = 0; i < 10; i++) {
            gameObject[i].draw(gr);
            if (gameObject[i].act == true) {
                int Met_W = gameObject[i].img.getWidth(null);
                int Met_H = gameObject[i].img.getHeight(null);
                int Met_x = gameObject[i].x;
                int Met_y = gameObject[i].y;
                if ((x <= Met_x+Met_W && x + Width_R>=Met_x && y+10<=Met_y+Met_H*3/4 && y+10+Height_R>=Met_y+Met_H/4)
                    || (x<=Met_x+Met_W*3/4 && x+Width_R>=Met_x+Met_W/4 && y+10<Met_y+Met_H && y+10+Height_R>=Met_y)) {
                    if (i==7 && life < 3) life++;
                    if (i==9) {
                        timespeed = 15;
                        speed += 5;
                    }
                    if (i==8) shild = 10;
                    if(shild == 0 && i < 7) life--;
                    if (life == 0){
                        gr.drawImage(Images[1], 500, 400, null);
                        gr.setColor(Color.red);
                        gr.drawRect(x,y+10,Width_R,Height_R);
                        gr.drawRect(Met_x,Met_y+Met_H/4,Met_W,Met_H*2/4);
                        gr.drawRect(Met_x+Met_W/4,Met_y,Met_W*2/4,Met_H);
                        timerUpdate.stop();
                        timerDraw.stop();
                        break;
                    }
                    gameObject[i].act = false;
                }
            }
        }
        gr.setColor(Color.WHITE);
        gr.drawString("our score: " + score, 10, 20);
        //gr.drawString("cooldown_shild: " + cooldown_shild, 10, 40);
        //gr.drawString("cooldown_speed: " + cooldown_speed, 10, 60);
        //gr.drawString("cooldown_repair: " + cooldown_repair, 10, 80);
        //gr.drawString("speed: " + speed, 10, 100);
        if (shild > 0){
            gr.drawImage(Images[5], x-30, y-30,  null);
            gr.drawString("shild: " + shild, x-10, y-40);
        }
        if (timespeed > 0) gr.drawString("boost: " + timespeed, x-10, y-50);
    }
    private void updateStart()
    {
        int kol = 0;
        for (int i =0; i < 7; i++)
        {
            if(gameObject[i].act == false){
                gameObject[i].start();
                break;
            }
            else kol++;
        }
        if (cooldown_repair == 0) {
            gameObject[7].start();
            cooldown_repair = random(15,10 * difficult/2);
        }
        if (cooldown_shild == 0) {
            gameObject[8].start();
            cooldown_shild = random(15,10 * difficult/2);
        }
        if (cooldown_speed == 0) {
            gameObject[9].start();
            cooldown_speed = random(10,10 * difficult/2);
        }
    }

    byte random(int min, int max){
        return (byte)(Math.random() * (max - min + 1) + min);
    }
}



