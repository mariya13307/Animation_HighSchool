import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Name: Mariya M
//Date: May 30, 2024
//Teacher: Mr. Gugliemi
//This class is the scene where the child is going to school and needs to choose the more eco-friendly transportation option

public class Outside extends JFrame
{
    JPanel p;
    Color sky =  new Color(137, 160, 196);
    Color grass = new Color(106, 153, 84);
    Color sun = new Color(237, 186, 57);
    Color path = (Color.GRAY);
    Color school = new Color(196, 194, 188);
    Color door = new Color(105, 93, 75);
    Color frame = new Color(66, 55, 38);
    Color banner = new Color(138, 33, 33);
    Color bannerb = new Color(227, 182, 5);
    Font f = new Font("SansSerif", Font. PLAIN, 25);
    Font text = new Font("SansSerif",Font.PLAIN,17);
    Font title = new Font("Serif",Font.PLAIN,40);
    CommonGraphics co = new CommonGraphics();
    JButton c;
    JButton bike;
    JButton car;
    boolean cont;
    Player newUser;

    Outside(Player player)
    {
        this.newUser = player;
        setSize(700, 600);
        p = new JPanel(null);
        p = new JPanel(null);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        //ActionListenter is for the continue button which the player presses to move onto the next scene
        c = new JButton("Continue");
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cont = true;
                repaint();
                c.setVisible(false);
            }
        });

        //will add 4 points to childs total number points (this aspect of the program will be made later)
        bike = new JButton("Bike");
        bike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                newUser.addHS(4);
            }
        });
        //will add 2 points to childs total number of points  (this aspect of the program will be made later)
        car = new JButton("Car");
        car.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //adds no points to players high score
            }
        });
        p = new JPanel(null);

        p.add(c);
        c.setBounds(575,530,100,25);
        p.add(bike);
        bike.setBounds(390,470,110,25);
        p.add(car);
        car.setBounds(525,470,120,25);

        this.add (p);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

    }

    //paints the background of the frame
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if(!cont)
        {
            //background
            setBackground(sky);
            g2.setColor(grass);
            g2.fillRect(0, 350, 700, 600);
            g2.setColor(sun);
            g2.fillOval(-40, -20, 120, 120);
            //path
            g2.setColor(path);
            int[] x = {250, 450, 550, 150};
            int[] y = {350, 350, 600, 600};
            g2.fillPolygon(x, y, 4);

            //school building
            g2.setColor(school);
            g2.fillRect(150, 100, 400, 250);
            g2.setFont(f);
            g2.setColor(Color.BLACK);
            g2.drawString("Pleasant Valley Middle School", 170, 140);

            //doors
            g2.setColor(door);
            g2.fillRect(310, 260, 80, 90);
            g2.setColor(frame);
            BasicStroke bs = new BasicStroke(3);
            g2.setStroke(bs);
            g2.drawLine(350, 262, 350, 348);
            g2.fillOval(337, 305, 10, 10);
            g2.fillOval(353, 305, 10, 10);

            //banner
            BasicStroke b = new BasicStroke(3);
            g2.setStroke(b);
            g2.setColor(banner);
            int x1[] = {330, 370, 380, 350, 320};
            int y1[] = {160, 160, 170, 240, 170};
            g2.fillPolygon(x1, y1, 5);
            g2.setColor(bannerb);
            g2.drawPolygon(x1, y1, 5);

            //windows
            BasicStroke bbs = new BasicStroke(2);
            g2.setStroke(bbs);

            //top left
            g2.setColor(Color.WHITE);
            g2.fillRect(170, 180, 50, 50);
            g2.setColor(frame);
            g2.drawRect(170, 180, 50, 50);
            g2.drawRect(170, 205, 50, 25);
            g2.drawRect(195, 180, 25, 50);

            //bottom left
            g2.setColor(Color.WHITE);
            g2.fillRect(170, 260, 50, 50);
            g2.setColor(frame);
            g2.drawRect(170, 260, 50, 50);
            g2.drawRect(170, 285, 50, 25);
            g2.drawRect(195, 260, 25, 50);

            //top left middle
            g2.setColor(Color.WHITE);
            g2.fillRect(240, 180, 50, 50);
            g2.setColor(frame);
            g2.drawRect(240, 180, 50, 50);
            g2.drawRect(240, 205, 50, 25);
            g2.drawRect(265, 180, 25, 50);

            //bottom left middle
            g2.setColor(Color.WHITE);
            g2.fillRect(240, 260, 50, 50);
            g2.setColor(frame);
            g2.drawRect(240, 260, 50, 50);
            g2.drawRect(240, 285, 50, 25);
            g2.drawRect(265, 260, 25, 50);

            //top right middle
            g2.setColor(Color.WHITE);
            g2.fillRect(410, 180, 50, 50);
            g2.setColor(frame);
            g2.drawRect(410, 180, 50, 50);
            g2.drawRect(410, 205, 50, 25);
            g2.drawRect(435, 180, 25, 50);

            //bottom right middle
            g2.setColor(Color.WHITE);
            g2.fillRect(410, 260, 50, 50);
            g2.setColor(frame);
            g2.drawRect(410, 260, 50, 50);
            g2.drawRect(410, 285, 50, 25);
            g2.drawRect(435, 260, 25, 50);

            //top right
            g2.setColor(Color.WHITE);
            g2.fillRect(480, 180, 50, 50);
            g2.setColor(frame);
            g2.drawRect(480, 180, 50, 50);
            g2.drawRect(480, 205, 50, 25);
            g2.drawRect(505, 180, 25, 50);

            //bottom right
            g2.setColor(Color.WHITE);
            g2.fillRect(480, 260, 50, 50);
            g2.setColor(frame);
            g2.drawRect(480, 260, 50, 50);
            g2.drawRect(480, 285, 50, 25);
            g2.drawRect(505, 260, 25, 50);

            co.person(320,395,g2);
            //speech bubble to give player instructions and context to the earlier buttons
            BasicStroke bs2 = new BasicStroke(5);
            g2.setStroke(bs2);
            g2.setColor(Color.WHITE);
            int xx[] = {395, 445, 445, 645, 645};
            int yy[] = {430, 410, 330, 330, 430};
            g2.fillPolygon(xx, yy, 5);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(xx, yy, 5);
            g2.setFont(text);
            g2.drawString("Oh no!",455,350);
            g2.drawString("I'm running late!",455,370);
            g2.drawString("Should I bike or drive",455,390);
            g2.drawString("to school?",455,410);
        }
        else
        {
            bike.setVisible(false);
            car.setVisible(false);
            g2.setColor(sky);
            g2.fillRect(0,0,700,600);
            Park1 park = new Park1(newUser);
            park.paint(g2);
            park.repaint();
            park.setVisible (true);
        }
    }
}
