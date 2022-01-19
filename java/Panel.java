import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel{
    public BufferedImage image;
    public Panel(){
        super();
        this.image = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }
    
    public void draw(){
        this.repaint();
    }
}
