import javax.swing.*;
import java.awt.*;

/**
 * This is a simple Button creator class that is used to create button such as solid color round button and Gradient painter round color.
 *
 * @author Tahir
 * @version 1.0
 */

public class ButtonCreator_Main extends JButton {

    private int height;
    private int width;
    private String buttonName;
    private Color color;
    private Color color1;
    private Color color2;
    private int arcWidth;
    private int arcHeight;
    private boolean isGradient;

    /**
     * Constructor for the ButtonCreator class.
     */

    ButtonCreator_Main() {


    }


    /**
     * Creates a solid color round button.
     *
     * @param width      The width of the button.
     * @param height     The height of the button.
     * @param arcWidth   The width of the button's arc.
     * @param arcHeight  The height of the button's arc.
     * @param buttonName The text to be displayed on the button.
     * @param color      The color of the button.
     */
    public void normalButtonCreator(int width, int height, int arcWidth, int arcHeight, String buttonName, Color color) {
        isGradient = false;
        this.height = height;
        this.width = width;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.buttonName = buttonName;
        this.color = color;
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusable(false);
    }

    /**
     * Creates a gradient painted round button.
     *
     * @param width      The width of the button.
     * @param height     The height of the button.
     * @param arcWidth   The width of the button's arc.
     * @param arcHeight  The height of the button's arc.
     * @param buttonName The text to be displayed on the button.
     * @param color1     The starting color of the gradient.
     * @param color2     The ending color of the gradient.
     */

    public void gradientButtonCreator(int width, int height, int arcWidth, int arcHeight, String buttonName, Color color1, Color color2) {
        isGradient = true;
        this.height = height;
        this.width = width;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.buttonName = buttonName;
        this.color1 = color1;
        this.color2 = color2;
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusable(false);


    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (isGradient) {
            GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
            g2d.setPaint(gp);
        } else {
            g2d.setColor(color);
        }
        g2d.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);
        g2d.setColor(Color.white);
        FontMetrics fontMetrics = g.getFontMetrics(getFont());
        int x = (getWidth() - fontMetrics.stringWidth(buttonName)) / 2;
        int y = ((getHeight() - fontMetrics.getHeight()) / 2) + fontMetrics.getAscent();
        g2d.drawString(buttonName, x, y);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ButtonCreator b = new ButtonCreator();
        ButtonCreator b2 = new ButtonCreator();
        frame.setLayout(null);
        frame.setSize(720, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        b.normalButtonCreator(100, 50, 80, 80, "Click Me", new Color(0x3B1818));
        b.setBounds(500, 100, 100, 50);
        b2.gradientButtonCreator(150, 50, 80, 80, "Gradient", new Color(0xA70EA9), new Color(0x44EFB4));
        b2.setBounds(300, 100, 150, 50);
        frame.add(b);
        frame.add(b2);
        frame.setVisible(true);
    }

}
