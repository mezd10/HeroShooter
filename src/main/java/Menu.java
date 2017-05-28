import javax.imageio.ImageIO;
        import java.awt.*;
        import java.io.IOException;

public class Menu {

    private final int buttonWidth = 400;
    private final int buttonHeight = 60;
    private Color color;
    private String buttonPlay;
    private String buttonSelectionPlayer;

    private static boolean stateGameOver;

    private Image fon;

    public Menu() {
        images();

        color = Color.RED;

        buttonPlay = "Play";
        buttonSelectionPlayer = "Selection Player";

        stateGameOver = false;
    }

    private void images() {
        try {
            fon = ImageIO.read(getClass().getResource("fon.png"));
        } catch (IOException e) {

        }
    }

    public void update() {
        if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2
                && GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonWidth / 2
                && GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonHeight / 2
                && GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonHeight / 2
                && GamePanel.pressed) {
            GamePanel.state = GamePanel.STATES.PLAY;

            if (GameOver.getState()){
                stateGameOver = true;
            }

        } else if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2
                && GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonWidth / 2
                && GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonHeight / 2 + 80
                && GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonHeight / 2 + 80
                && GamePanel.pressed) {

            GamePanel.state = GamePanel.STATES.SELECTIONPLAER;

        }
    }

    public static boolean getState(){
        return stateGameOver;
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
}

