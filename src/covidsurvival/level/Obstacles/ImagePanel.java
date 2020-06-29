package covidsurvival.level.Obstacles;

import java.awt.*;
import javax.swing.JPanel;



class ImagePanel extends JPanel {
    Image image;


    public ImagePanel() {
        image = Toolkit.getDefaultToolkit().createImage("res/tvanimation.gif");

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);

        }
    }

}