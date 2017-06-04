import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Menu implements Updateble, Draweble {

    private final int buttonWidth = 400;
    private final int buttonHeight = 60;
    private Color color;
    private String buttonPlay;
    private String buttonSelectionPlayer;

    private ListenersMouse mouse;

    private Image fon;

    public Menu() {
        images();

        color = Color.RED;

        buttonPlay = "Play";
        buttonSelectionPlayer = "Selection Player";

        mouse = new ListenersMouse();
    }

    private void images() {
        try {
            fon = ImageIO.read(getClass().getResource("fon.png"));
        } catch (IOException e) {

        }
    }

    public void draw(Graphics g) {
        g.drawImage(fon, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        g.setColor(color);
        g.drawRect(GamePanel.WIDTH / 2 - buttonWidth / 2, GamePanel.HEIGHT / 2 - buttonHeight / 2, buttonWidth, buttonHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.ITALIC, 40));
        int lenght = (int) g.getFontMetrics().getStringBounds(buttonPlay, g).getWidth();
        g.drawString(buttonPlay, GamePanel.WIDTH / 2 - lenght / 2, GamePanel.HEIGHT / 2 + buttonHeight / 4);


        g.setColor(color);
        g.drawRect(GamePanel.WIDTH / 2 - buttonWidth / 2, (GamePanel.HEIGHT / 2 - buttonHeight / 2) + 80, buttonWidth, buttonHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.ITALIC, 40));
        g.drawString(buttonSelectionPlayer, GamePanel.WIDTH / 2 - buttonWidth / 2 + 60, (GamePanel.HEIGHT / 2 - buttonHeight / 2) + 120);
    }

    @Override
    public void getUpdate() {
        if (mouse.mouseX() > GamePanel.WIDTH / 2 - buttonWidth / 2
                && mouse.mouseX() < GamePanel.WIDTH / 2 + buttonWidth / 2
                && mouse.mouseY() > GamePanel.HEIGHT / 2 - buttonHeight / 2
                && mouse.mouseY() < GamePanel.HEIGHT / 2 + buttonHeight / 2
                && mouse.pressed()) {

            GamePanel.state = GamePanel.STATES.PLAY;

        } else if (mouse.mouseX() > GamePanel.WIDTH / 2 - buttonWidth / 2
                && mouse.mouseX() < GamePanel.WIDTH / 2 + buttonWidth / 2
                && mouse.mouseY() > GamePanel.HEIGHT / 2 - buttonHeight / 2 + 80
                && mouse.mouseY() < GamePanel.HEIGHT / 2 + buttonHeight / 2 + 80
                && mouse.pressed()) {

            GamePanel.state = GamePanel.STATES.SELECTIONPLAER;
        }
    }
}

