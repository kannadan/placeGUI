/**
 * Created by Joonas on 10.5.2017.
 */
import java.util.List;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {

    private List<Point> fillCells;
    private List<String> colors;
    int width, height, rows, columns;

    public Grid(){
        fillCells = new ArrayList<>(25);
        colors = new ArrayList<>(25);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index = 0;
        for (Point fillCell : fillCells) {
            int cellX = 9 + (fillCell.x * 9);
            int cellY = 9 + (fillCell.y * 9);
            if (colors.get(index) == "Red"){
                g.setColor(Color.RED);
            }
            else if (colors.get(index) == "Blue"){
                g.setColor(Color.BLUE);
            }
            else if (colors.get(index) == "Black"){
                g.setColor(Color.BLACK);
            }
            else if (colors.get(index) == "White"){
                g.setColor(Color.WHITE);
            }
            else if (colors.get(index) == "Cyan"){
                g.setColor(Color.CYAN);
            }
            else if (colors.get(index) == "Magenta"){
                g.setColor(Color.MAGENTA);
            }
            else if (colors.get(index) == "Yellow"){
                g.setColor(Color.YELLOW);
            }
            else{
                g.setColor(Color.GREEN);
            }
            index++;
            g.fillRect(cellX, cellY, 9, 9);
        }
        g.setColor(Color.WHITE);
        g.drawRect(9, 9, 486, 648);

/*        g.drawLine(9, 100, 495, 100);
        g.drawLine(100, 9, 100, 657);*/

        for (int i = 9; i <= 486; i += 9) {
            g.drawLine(i, 9, i, 657);
        }

        for (int i = 9; i <= 648; i += 9) {
            g.drawLine(9, i, 495, i);
        }
    }
    public void fillCell(int x, int y, String c) {
        fillCells.add(new Point(x, y));
        colors.add(c);
        repaint();
    }


}
