import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main extends JFrame
{
    public static int[] size = {1000, 1000};
    public static int[] origin = {500, 500};

    public static Main frame;

    public static BufferedImage bImage;
    public static Image image;
    public static JLabel label;

    public static int frameNumber;

    public static void main(String[] args)
    {
        try{bImage = ImageIO.read(new File("pictures/javaLogo.png"));}catch(Exception e){}
        image = bImage.getScaledInstance(size[0], size[0], Image.SCALE_DEFAULT);
        label = new JLabel(new ImageIcon(image));
        createGUI();
        try{Thread.sleep(1000);}catch(Exception e){}
        for(frameNumber = 0; frameNumber < 5; frameNumber++)
        {
            iterateFrame();
            try{Thread.sleep(750);}catch(Exception e){}
        }
    }

    private static void createGUI()
    {
        frame = new Main();

        frame.setTitle("Image Animation Prototype");
        frame.setSize(size[0], size[1]);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(label);

        frame.setVisible(true);
    }

    private static void iterateFrame()
    {
        println("Image And Animation Prototype", "Iterated Frame!");
        try{image = ImageIO.read(new File("frames/pixil-frame-" + frameNumber + ".png"));}catch(Exception e){}
        label.setIcon(new ImageIcon(image));
        label.repaint();
    }

    public static void println(String terminalPrefix, String s)
    {
        System.out.println(terminalPrefix + "> " + s);
    }
}