import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Pause {

    private Image fonPause;

    private Color color;

    private final int buttonWidth = 400;
    private final int buttonHeight = 60;

    private String buttonContinue = "C O N T I N U E";

    public Pause(){

        color = Color.RED;
        images();

    }

    public void update() {
        if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2
                && GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonWidth / 2
                && GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonHeight / 2
                && GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonHeight / 2
                && GamePanel.pressed) {

            GamePanel.state = GamePanel.STATES.PLAY;
        }
    }

    private void images() {

        try {
            fonPause = ImageIO.read(getClass().getResource("fonPause.png"));
        } catch (IOException e) {

        }
    }

    public void draw(Graphics g) {
        g.drawImage(fonPause, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        g.setColor(color);
        g.drawRect(GamePanel.WIDTH / 2 - buttonWidth / 2, GamePanel.HEIGHT / 2 - buttonHeight / 2, buttonWidth, buttonHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.ITALIC, 40));
        int lenght = (int) g.getFontMetrics().getStringBounds(buttonContinue, g).getWidth();
        g.drawString(buttonContinue, GamePanel.WIDTH / 2 - lenght / 2, GamePanel.HEIGHT / 2 + buttonHeight / 4);

    }
}
