import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        String rez = JOptionPane.showInputDialog(null, "Введите сложность игры от 3 до 9:", "Сложность игры", 1);
        int difficult = rez.charAt(0) - '0';
        while (true) {
            if ((difficult >= 3) && (difficult <= 9)){
                Window window = new Window();
                window.window(difficult);
                break;
            }
            else JOptionPane.showMessageDialog(null, "Недопустимое значение", "Сложность игры", JOptionPane.ERROR_MESSAGE);
        }
    }

}
