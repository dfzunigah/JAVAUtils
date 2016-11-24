import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

class DrawPad extends JComponent {

private Image image;
private Image background;
private Graphics2D graphics;
private int currentX, currentY, oldX, oldY;
private final SizedStack<Image> undoStack = new SizedStack<>(12);

public DrawPad() {
    setDoubleBuffered(false);
    addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            saveToStack(image);
            oldX = e.getX();
            oldY = e.getY();
            System.out.println(undoStack.size());
        }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            currentX = e.getX();
            currentY = e.getY();
            if (graphics != null) {
                graphics.drawLine(oldX, oldY, currentX, currentY);
            }
            repaint();
            oldX = currentX;
            oldY = currentY;
        }
    });
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image == null) {
        image = createImage(getSize().width, getSize().height);
        graphics = (Graphics2D) image.getGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        clear();
    }
    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
}

public void clear() {
    if (background != null) {
        setImage(copyImage(background));
    } else {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setPaint(Color.black);
    }
    repaint();
}

public void undo() {
    if (undoStack.size() > 0) {
        setImage(undoStack.pop());
    }
}

private void setImage(Image img) {
    graphics = (Graphics2D) img.getGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    graphics.setPaint(Color.black);
    image = img;
    repaint();
}

public void setBackground(Image img) {
    background = copyImage(img);
    setImage(copyImage(img));
}

private BufferedImage copyImage(Image img) {
    BufferedImage copyOfImage = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
    Graphics g = copyOfImage.createGraphics();
    g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    return copyOfImage;
}

private void saveToStack(Image img) {
    undoStack.push(copyImage(img));
}

public void red() {
    graphics.setPaint(Color.red);
    repaint();
}

public void black() {
    graphics.setPaint(Color.black);
    repaint();
}

public void magenta() {
    graphics.setPaint(Color.magenta);
    repaint();
}

public void blue() {
    graphics.setPaint(Color.blue);
    repaint();
}

public void green() {
    graphics.setPaint(Color.green);
    repaint();
}
}