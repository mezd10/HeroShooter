import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class SelectionPlayer implements Updateble, Draweble {

    private int buttonWidth;
    private int buttonHeight;
    private Color color;

    private Image fon;
    private Image heroFirst;
    private Image heroSecond;
    private static Image mainHero;

    private ListenersMouse mouse;

    public SelectionPlayer() {

        buttonWidth = 80;
        buttonHeight = 60;

        color = Color.BLUE;

        images();

        mainHero = heroFirst;

        mouse = new ListenersMouse();
    }

    private void images() {
        try {
            fon = ImageIO.read(getClass().getResource("fon.png"));
            heroFirst = ImageIO.read(getClass().getResource("Dudl_1.png"));
            heroSecond = ImageIO.read(getClass().getResource("mario1.png"));
        } catch (IOException e) {

        }
    }

    public static Image getImage() {
        return mainHero;
    }


    public void draw(Graphics g) {
        g.drawImage(fon, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        g.setColor(color);
        g.drawRect(0, 0, buttonWidth, buttonHeight);
        g.drawImage(heroFirst, 20, 8, 40, 40, null);

        g.setColor(color);
        g.drawRect(100, 0, buttonWidth, buttonHeight);
        g.drawImage(heroSecond, 120, 8, 40, 40, null);
    }

    @Override
    public void getUpdate() {
        if (mouse.mouseX() > 0
                && mouse.mouseX() < buttonWidth
                && mouse.mouseY() > 0
                && mouse.mouseY() < buttonHeight
                && mouse.pressed()) {

            mainHero = heroFirst;
            GamePanel.state = GamePanel.STATES.MENU;

        }

        if (mouse.mouseX() > 100
                && mouse.mouseX() < buttonWidth + 100
                && mouse.mouseY() > 0
                && mouse.mouseY() < buttonHeight
                && mouse.pressed()) {

            mainHero = heroSecond;
            GamePanel.state = GamePanel.STATES.MENU;
        }
    }
}
