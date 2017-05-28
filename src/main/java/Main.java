import javax.swing.*;

public class Main {

    private static JFrame mainFrame;

    public static void main(String[] args) {

        mainFrame = new MainFrame();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame.pack();
                mainFrame.setVisible(true);
            }
        });
    }

    public void newGame() {
        mainFrame.dispose();
        mainFrame = new MainFrame();
    }
}
