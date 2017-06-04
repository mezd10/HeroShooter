import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements Updateble, Draweble, Getter {

    private double x;
    private double y;
    private int r;

    private double dx;
    private double dy;

    private int speed;
    private int health;

    private MyKeyListener listener;

    public Player() {
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        r = 10;

        speed = 5;
        dx = 0;
        dy = 0;


        health = 6;

        listener = new MyKeyListener();

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public void hit() {
        health--;
    }

    public boolean remove() {
        if (health <= 0) {
            return true;
        }
        return false;
    }

    public void draw(Graphics g) {

        g.drawImage(SelectionPlayer.getImage(), (int) (x - r), (int) (y - r), 40, 40, null);
    }

    @Override
    public void getUpdate() {


        if (listener.up() && y > r) {
            dy = -speed;
        }
        if (listener.down() && y < GamePanel.HEIGHT - r) {
            dy = speed;
        }
        if (listener.left() && x > r) {
            dx = -speed;
        }
        if (listener.right() && x < GamePanel.WIDTH - r) {
            dx = speed;
        }
        if (listener.up() && listener.left() || listener.up() && listener.right()
                || listener.down() && listener.left() || listener.down() && listener.right()) {
            double angle = Math.toRadians(45);
            dy = dy * Math.sin(angle);
            dx = dx * Math.cos(angle);
        }

        y += dy;
        x += dx;

        dy = 0;
        dx = 0;
    }
}

