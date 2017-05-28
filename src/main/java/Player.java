import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player {

    private double x;
    private double y;
    private int r;

    private double dx;
    private double dy;

    private int speed;
    private int health;

    private Image hero;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    public static boolean isFiring;

    public Player(){
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        r = 10;

        speed = 5;
        dx = 0;
        dy = 0;


        health = 6;

        up = false;
        down = false;
        left = false;
        right = false;

        isFiring = false;

        images();
    }

    private void images(){
        try {
            hero = ImageIO.read(getClass().getResource("Dudl_1.png"));
        }catch (IOException e){

        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public int getR(){return r;}

    public void hit(){
        health --;
    }

    public boolean remove(){
        if (health <= 0){
            return true;
        }
        return false;
    }

    public void update(){

        if (up && y > r){
            dy = -speed;
        }
        if (down && y < GamePanel.HEIGHT - r){
            dy = speed;
        }
        if (left && x > r){
            dx = -speed;
        }
        if (right && x < GamePanel.WIDTH - r){
            dx = speed;
        }
        if(up && left || up && right || down && left || down && right){
            double angle = Math.toRadians(45);
            dy = dy * Math.sin(angle);
            dx = dx * Math.cos(angle);
        }

        y += dy;
        x += dx;

        dy = 0;
        dx = 0;

        if (isFiring){
            GamePanel.bullets.add(new Bullet());
        }
    }

    public void draw(Graphics g){

            g.drawImage(hero, (int) (x - r), (int) (y - r), 40, 40, null);
    }
}
