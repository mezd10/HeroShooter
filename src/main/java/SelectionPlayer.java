import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SelectionPlayer { // не продуман до конца

    private int buttonWidth;
    private int buttonHeight;
    private Color color;

    private Image fon;
    private Image heroFirst;
    private Image heroSecond;

    public SelectionPlayer(){

        buttonWidth = 80;
        buttonHeight = 60;

        color = Color.BLUE;


        images();
    }

    private void images(){
        try {
            fon = ImageIO.read(getClass().getResource("fon.png"));
            heroFirst = ImageIO.read(getClass().getResource("Dudl_1.png"));
            heroSecond = ImageIO.read(getClass().getResource("mario1.png"));
        }catch (IOException e){

        }
    }

    public void update(){

        if (GamePanel.mouseX > 0
                && GamePanel.mouseX < buttonWidth / 2
                && GamePanel.mouseY > 0
                && GamePanel.mouseY < buttonHeight / 2
                && GamePanel.pressed) {

            GamePanel.state = GamePanel.STATES.PLAY;

        }

    }


    public void draw(Graphics g){
        g.drawImage(fon, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        g.setColor(color);
        g.drawRect(0, 0 , buttonWidth, buttonHeight);
        g.drawImage(heroFirst, 20, 8 , 40, 40, null);

        g.setColor(color);
        g.drawRect(100, 0 , buttonWidth, buttonHeight);
        g.drawImage(heroSecond, 120, 8 , 40, 40, null);
    }
}
