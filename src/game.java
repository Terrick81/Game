import javax.swing.*;

public class game {
    public static void main(String[] args) {
        while (true) {
            String rez = JOptionPane.showInputDialog(null, "Введите сложность игры от 3 до 9:", "Сложность игры", 1);
            int difficult = rez.charAt(0) - '0';
            if ((difficult >= 3) &&(difficult <= 9)){
                okno window = new okno(difficult);
                break;
            }
            else JOptionPane.showMessageDialog(null, "Недопустимое значение", "Сложность игры", JOptionPane.ERROR_MESSAGE);
        }
    }
}
