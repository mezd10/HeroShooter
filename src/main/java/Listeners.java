import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listeners implements KeyListener {

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = true;
        }
        if (key == KeyEvent.VK_UP) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.right = true;
        }
        if (key == KeyEvent.VK_K) {
            Player.isFiring = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            GamePanel.state = GamePanel.STATES.PAUSE;
        }


    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = false;
        }
        if (key == KeyEvent.VK_UP) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.right = false;
        }
        if (key == KeyEvent.VK_K) {
            Player.isFiring = false;
        }
    }
}
