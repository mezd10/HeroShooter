import java.awt.*;

public class Bullet {

    private double x;
    private double y;
    private int r;

    private int speed;

    private Color color;

    public Bullet() {
        x = GamePanel.player.getX();
        y = GamePanel.player.getY();
        r = 5;

        speed = 10;

        color = Color.BLACK;
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

    public void update() {
        y -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, r, r);
    }

    public boolean remove() {
        if (y < 0) {
            return true;
        }
        return false;
    }
}
