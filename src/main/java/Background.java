import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background implements Draweble {

    private Image fon1;

    public Background() {

        images();
    }

    private void images() {
        try {
            fon1 = ImageIO.read(getClass().getResource("/fon3.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {

        g.drawImage(fon1, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);

    }
}
