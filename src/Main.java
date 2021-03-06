/**
 * Created by Joonas on 10.5.2017.
 */
import sun.awt.TracedEventQueue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.lang.Thread;


public class Main {

    private static int chosen = 0;
    private static client talker = new client();
    private static ArrayList<String> moves = new ArrayList<>();

    public static void main(String[] args){

        String[] bColors = {"Red", "Blue", "Black", "White", "Cyan", "Magenta", "Yellow", "Green"};
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                Grid grid = new Grid();
                for (int y = 0; y< 72; y++){
                    for(int x = 0; x< 54; x++){
                        grid.fillCell(x,y,"Black");
                    }
                }
                JFrame window = new JFrame();
                window.setSize(600, 700);
                window.getContentPane().setLayout(new GridLayout());
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Box b = new Box(BoxLayout.X_AXIS);
                b.add(grid);
                Box c = new Box(BoxLayout.Y_AXIS);


                JButton blue = new JButton("Blue");
                blue.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosen = 1;
                    }
                });
                JButton red = new JButton("Red");
                red.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosen = 0;
                    }
                });
                JButton black = new JButton("Black");
                black.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosen = 2;
                    }
                });
                JButton white = new JButton("White");
                white.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosen = 3;
                    }
                });
                JButton cyan = new JButton("Cyan");
                cyan.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosen = 4;
                    }
                });
                JButton magenta = new JButton("Magenta");
                magenta.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosen = 5;
                    }
                });
                JButton yellow = new JButton("Yellow");
                yellow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosen = 6;
                    }
                });
                JButton green = new JButton("Green");
                green.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosen = 7;
                    }
                });
                JButton save = new JButton("Save");
                save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ArrayList<String> newmoves = new ArrayList<String>(moves);
                        askName box = new askName(talker, newmoves);
                        System.out.print("flushing\n");
                        moves.clear();
                    }
                });



                c.add(blue);
                c.add(red);
                c.add(black);
                c.add(white);
                c.add(cyan);
                c.add(magenta);
                c.add(yellow);
                c.add(green);
                c.add(save);


                b.add(c);
                window.getContentPane().add(b);

                window.setVisible(true);
                window.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            System.out.print("Button 1 clicked..." + Integer.valueOf(e.getX()) + " " + Integer.valueOf(e.getY())+ "\n");
                            grid.fillCell((e.getX()-20)/9,(e.getY()-40)/9, bColors[chosen]);
                            talker.send("!move " + Integer.valueOf((e.getX()-20)/9) + " - " + Integer.valueOf((e.getY()-40)/9) + " " + bColors[chosen] +"\r\n");
                            moves.add(Integer.valueOf((e.getX()-20)/9) + "-" + Integer.valueOf((e.getY()-40)/9) + " " + bColors[chosen]);
                        }
                        else{
                        }
                    }
                });
            }
        });
    }

}
