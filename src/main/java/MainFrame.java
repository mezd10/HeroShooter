import javax.swing.*;
import javax.swing.border.BevelBorder;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("HeroShooter");

        GamePanel panel = new GamePanel();
         // Думаю добавлять ToolBar или нет
        //addKeyListener(new Listeners());

        /*JButton newGame = new JButton("Restart");
        newGame.setRolloverEnabled(true);
        newGame.setBorder(new EmptyBorder(5,5,5,5));
        newGame.addMouseListener(new ListenersMouse(){
            @Override
            public void mouseClicked(MouseEvent e){
                new Main().newGame();
            }
        });

        JToolBar toolBar = new JToolBar();
        toolBar.setPreferredSize(new Dimension(50,30));
        toolBar.add(newGame);
        toolBar.setFloatable(false);

        getContentPane().add(toolBar, BorderLayout.NORTH);*/

        JPanel field = new GamePanel();

        field.setBorder(new BevelBorder(BevelBorder.LOWERED));
        getContentPane().add(panel);
        panel.start();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
