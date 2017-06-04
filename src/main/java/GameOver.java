import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class GameOver implements Updateble {

    private Image fon;
    private Color color;

    private final int buttonWidth = 400;
    private final int buttonHeight = 60;

    private String buttonRoadToMenu;

    private static boolean state;

    private ListenersMouse mouse;


    public GameOver() {

        images();

        color = Color.RED;

        buttonRoadToMenu = "M E N U ";

        mouse = new ListenersMouse();

    }

    private void images() {
        try {
            fon = ImageIO.read(getClass().getResource("fonGameOver.png"));
        } catch (IOException e) {

        }
    }

    public static boolean getState() {
        return state;
    }

    public void draw(Graphics g) {
        g.drawImage(fon, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);

        g.setColor(color);
        g.drawRect(GamePanel.WIDTH / 2 - buttonWidth / 2, GamePanel.HEIGHT / 2 - buttonHeight / 2 + 160, buttonWidth, buttonHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.ITALIC, 40));
        int lenght = (int) g.getFontMetrics().getStringBounds(buttonRoadToMenu, g).getWidth();
        g.drawString(buttonRoadToMenu, GamePanel.WIDTH / 2 - lenght / 2, GamePanel.HEIGHT / 2 + buttonHeight / 4 + 160);
    }

    @Override
    public void getUpdate() {
        if (mouse.mouseX() > GamePanel.WIDTH / 2 - buttonWidth / 2
                && mouse.mouseX() < GamePanel.WIDTH / 2 + buttonWidth / 2
                && mouse.mouseY() > GamePanel.HEIGHT / 2 - buttonHeight / 2 + 160
                && mouse.mouseY() < GamePanel.HEIGHT / 2 + buttonHeight / 2 + 160
                && mouse.pressed()) {
            GamePanel.state = GamePanel.STATES.MENU;
            state = true;
        }
    }
}
