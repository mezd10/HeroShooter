import javax.imageio.ImageIO;
        import java.awt.*;
        import java.io.IOException;

public class GameOver {

    private Image fon;
    private Color color;

    private final int buttonWidth = 400;
    private final int buttonHeight = 60;

    private String buttonRoadToMenu;

    private static boolean state;


    public GameOver(boolean state) {

        this.state = state;

        images();

        color = Color.RED;

        buttonRoadToMenu = "M E N U ";

    }

    private void images() {
        try {
            fon = ImageIO.read(getClass().getResource("fonGameOver.png"));
        } catch (IOException e) {

        }
    }

    public void update(){

        if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2
                && GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonWidth / 2
                && GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonHeight / 2 + 160
                && GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonHeight / 2 + 160
                && GamePanel.pressed) {
            GamePanel.state = GamePanel.STATES.MENUE;
            state = true;
        }
    }

    public static boolean getState(){
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
}
