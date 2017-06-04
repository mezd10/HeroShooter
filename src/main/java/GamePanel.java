import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class GamePanel extends JPanel implements Runnable, Updateble {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    private Thread thread;

    private BufferedImage image;
    private Graphics2D g;

    private Background background;

    private int FPS;
    private long timerFPS;
    private double dividerFPS;
    private int sleepTime;

    private MyKeyListener listener;

    public static Player player;
    public static ArrayList<Enemy> enemies;
    private ArrayList<Bullet> bullets;
    private Rounds rounds;
    private Menu menu;
    private SelectionPlayer selectionPlayer;
    private GameOver gameOver;
    private Pause pause;

    public enum STATES {
        MENU,
        PLAY,
        SELECTIONPLAER,
        PAUSE,
        GAMEOVER
    }

    public static STATES state;

    public GamePanel() {
        super();

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();

        init();
        FPS = 30;
        dividerFPS = 1000 / FPS;

        listener = new MyKeyListener();

    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {

        state = STATES.MENU;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        selectionPlayer = new SelectionPlayer();

        player = new Player();

        background = new Background();

        bullets = new ArrayList<>();

        enemies = new ArrayList<>();

        rounds = new Rounds();

        menu = new Menu();

        pause = new Pause();

        gameOver = new GameOver();

        while (true) {

            if (state.equals(STATES.MENU)) {

                menu.getUpdate();
                menu.draw(g);
                gameDraw();
            }

            if (state.equals(STATES.SELECTIONPLAER)) {

                selectionPlayer.getUpdate();
                selectionPlayer.draw(g);
                gameDraw();
            }

            if (state.equals(STATES.PLAY)) {
                background.draw(g);
                getUpdate();
                gameRender();
                gameDraw();
            }

            if (state.equals(STATES.PAUSE)) {

                pause.getUpdate();
                pause.draw(g);
                gameDraw();
            }

            if (state.equals(STATES.GAMEOVER)) {
                gameOver.getUpdate();
                gameOver.draw(g);
                gameDraw();
                if (GameOver.getState()) {
                    SwingUtilities.invokeLater(() -> {
                        start();
                    });
                    return;
                }
            }

            timerFPS = System.nanoTime();
            timerFPS = (System.nanoTime() - timerFPS) / 1000000;

            if (dividerFPS > timerFPS) {
                sleepTime = (int) (dividerFPS - timerFPS);
            } else {
                sleepTime = 1;
            }
            try {
                thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timerFPS = 0;
            sleepTime = 1;
        }
    }

    public void init() {
        addKeyListener(new MyKeyListener());
        addMouseMotionListener(new ListenersMouse());
        addMouseListener(new ListenersMouse());
    }

    @Override
    public void getUpdate() {
        player.getUpdate();

        if (listener.isFiring()) {
            bullets.add(new Bullet());
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).getUpdate();
            boolean remove = bullets.get(i).remove();
            if (remove) {
                bullets.remove(i);
                i--;
            }
        }

        for (Enemy i : enemies) {
            i.getUpdate();
        }

        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();
            for (int j = 0; j < bullets.size(); j++) {
                Bullet b = bullets.get(j);
                double bx = b.getX();
                double by = b.getY();
                double dx = ex - bx;
                double dy = ey - by;
                double dist = Math.sqrt(dx * dx + dy * dy);
                if (dist <= e.getR() + b.getR()) {
                    e.hit();
                    bullets.remove(j);
                    j--;
                    boolean remove = e.remove();
                    if (remove) {
                        enemies.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();

            double px = player.getX();
            double py = player.getY();
            double dx = ex - px;
            double dy = ey - py;
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist <= e.getR() + player.getR()) {
                e.hit();
                player.hit();

                if (e.remove()) {
                    enemies.remove(i);
                    i--;
                }
            }
        }

        if (player.remove()) {
            GamePanel.state = STATES.GAMEOVER;
        }

        rounds.getUpdate();
    }

    public void gameRender() {

        background.draw(g);

        player.draw(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g);
        }

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g);
        }

        if (rounds.showRounds()) {
            rounds.draw(g);
        }
    }

    private void gameDraw() {

        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }
}

