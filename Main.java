import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.io.File;

public class Main extends JPanel implements ActionListener, MouseListener, MouseMotionListener{

    private static final int WIDTH = 1700;
    private static final int HEIGHT = 1000;

    /** how much time the player has left in the game*/
    int timeLeft = 240;
    /** Timer to start the program*/
    Timer timer;
    /** Timer to start the actual game*/
    Timer gameTimer;


    public Main(){
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        requestFocus();
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(1,this);
        timer.start();

        gameTimer = new Timer(250, _ -> {
            timeLeft--;
            if(timeLeft <= 0){
                timeLeft = 0;
                gameTimer.stop();
                timer.stop();
            }
            repaint();
        });

        playMusic("HACKMARS/Golden.wav");

    }

    /** * * * * * * * * * * * * * * * * * * * * * * *
     * This method plays background music
     * @param filePath the file of music to be played
     * * * * * * * * * * * * * * * * * * * * * * * */
    public void playMusic(String filePath) {
        try {
            File musicPath = new File(filePath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(0, 0, 0));
        String[] imagesChef = {"chef cat", "speak chef cat 2", "speak chef cat 3"};

        ImageIcon c = new ImageIcon("HACKMARS/background.png");
        g.drawImage(c.getImage(),0,0,WIDTH, HEIGHT, null);

    }

    public void actionPerformed(ActionEvent e){

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        repaint();
    }

    public boolean checkOrder() {
       return true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /** main method, displays the JPanel
     * @param args String[] */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main());
        frame.setVisible(true);
        frame.getContentPane().requestFocusInWindow();
    }
}