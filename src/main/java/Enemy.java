import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Enemy {

    private double x;
    private double y;
    private int r;

    private Image enemy;
    private Image enemy1;
    private Image enemy2;

    private double speed;
    private double dx;
    private double dy;

    private double health;

    private int type;
    private int rank;

    public Enemy(int type, int rank) {
        this.type = type;
        this.rank = rank;
        images();

        switch (type) {

            case (1):
                switch (rank) {
                    case (1):
                        x = Math.random() * GamePanel.WIDTH;
                        y = 0;

                        r = 10;

                        speed = 4;

                        health = 2;

                        double angle = Math.toRadians(Math.random() * 360);
                        dx = Math.sin(angle) * speed;
                        dy = Math.cos(angle) * speed;
                        enemy = enemy1;
                }

            case (2):
                switch (rank) {
                    case (2):
                        x = Math.random() * GamePanel.WIDTH;
                        y = 0;

                        r = 15;

                        speed = 6;

                        health = 4;

                        double angle = Math.toRadians(Math.random() * 360);
                        dx = Math.sin(angle) * speed;
                        dy = Math.cos(angle) * speed;
                        enemy = enemy2;
                }



        }
    }

    private void images() {
        try {
            enemy1 = ImageIO.read(getClass().getResource("enemy.png"));
            enemy2 = ImageIO.read(getClass().getResource("enemy2.png"));
        } catch (IOException e) {

        }
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

    public boolean remove() {
        if (health <= 0) {
            return true;
        }
        return false;
    }

    public void hit() {
        health--;
    }


    public void update() {

        x += dx;
        y += dy;

        if (x < r && dx < 0) dx = -dx;
        if (x > GamePanel.WIDTH - r && dx > 0) dx = -dx;
        if (y < r && dy < 0) dy = -dy;
        if (y > GamePanel.HEIGHT - r && dy > 0) dy = -dy;

    }

    public void draw(Graphics g) {

        g.drawImage(enemy, (int) (x - r), (int) (y - r), 2 * r, 2 * r, null);
    }
}

