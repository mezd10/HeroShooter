import java.awt.*;

public class Rounds {

    private int roundsNumber;

    private String roundsText;

    private long roundsTimer;
    private long roundsDelay;
    private long roundsTimerDiff;

    private int roundsMultiplier;


    public Rounds(){
        roundsNumber = 1;
        roundsMultiplier = 5;

        roundsTimer = 0;
        roundsDelay = 5000;
        roundsTimerDiff = 0;

        roundsText = "R O U N D";
    }

    public void update(){
        if (GamePanel.enemies.size() == 0 && roundsTimer == 0){
            roundsTimer = System.nanoTime();
        }
        if(roundsTimer > 0){
            roundsTimerDiff += (System.nanoTime() - roundsTimer) / 1000000;
            roundsTimer = System.nanoTime();
        }
        if (roundsTimerDiff > roundsDelay){
            createEnemies();
            roundsTimer = 0;
            roundsTimerDiff = 0;
        }

    }

    public void createEnemies(){
        int enemyCount = roundsNumber * roundsMultiplier;
        if (roundsNumber <=  4){
            while (enemyCount > 0){
                int rank = 1;
                int type = 1;
                GamePanel.enemies.add(new Enemy(type, rank));
                enemyCount -= type * rank;
            }
        }
        if (roundsNumber > 4){
            while (enemyCount > 0){
                int rank = 2;
                int type = 2;
                GamePanel.enemies.add(new Enemy(type, rank));
                enemyCount -= type * rank;
            }
        }
        roundsNumber ++;
    }

    public boolean showRounds(){
        if (roundsTimer != 0){
            return true;
        }
        else return false;
    }

    public void draw(Graphics g){
        double divider = roundsDelay / 180;
        double alpha = roundsTimerDiff / divider;
        alpha = 255 *Math.sin(Math.toRadians(alpha));
        if (alpha < 0) alpha = 0;
        if (alpha > 255) alpha = 255;
        g.setFont(new Font("Consolas", Font.ITALIC, 25));
        g.setColor(new Color(100, 100, 255, (int)alpha));
        String s = roundsText + " - " + roundsNumber;
        int length = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        g.drawString(s, GamePanel.WIDTH / 2 - length / 2, GamePanel.HEIGHT / 2);
    }
}
