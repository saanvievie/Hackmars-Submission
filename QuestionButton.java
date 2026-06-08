import javax.swing.*;
import java.awt.*;
import java.util.*;

public class QuestionButton {
    private Map<String, String> answerKey;
    private String answer;
    private int x;
    private int y;
    private int width;
    private int height;
    private String color;
    private Rectangle bounds;

    public QuestionButton(int x, int y, Map<String, String> answerKey, int WIDTH, int HEIGHT, String color) {
        this.x = x;
        this.y = y;
        this.answerKey = answerKey;
        width = WIDTH/2 - 50;
        height = 175;
        this.color = color;
    }

    public void draw(Graphics g){
        ImageIcon c = new ImageIcon("HACKMARS/"+color+"Button.png");
        g.drawImage(c.getImage(), bounds.x, bounds.y, bounds.width, bounds.height, null);
    }

    public boolean contains(int x, int y){
        return bounds.contains(x, y);
    }

}
