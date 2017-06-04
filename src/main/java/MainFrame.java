import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("HeroShooter");

        GamePanel panel = new GamePanel();

        JPanel field = new GamePanel();

        field.setBorder(new BevelBorder(BevelBorder.LOWERED));
        getContentPane().add(panel);
        panel.start();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

interface Updateble {
    void getUpdate();
}

interface Draweble {
    void draw(Graphics g);
}

interface Getter {
    double getX();

    double getY();

    int getR();
}

interface MainPlayer {
    boolean up();

    boolean down();

    boolean left();

    boolean right();

    boolean isFiring();
}

interface MouseCoordinates {
    int mouseX();

    int mouseY();

    boolean pressed();
}
