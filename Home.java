import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Home extends JFrame
{
    Color wall = new Color(201, 182, 212);
    Color floor = new Color(92, 65, 41);
    Color sky =  new Color(137, 160, 196);
    Color bed = new Color(207, 182, 138);
    Color rug = new Color(43, 44, 130);
    Color rugB = new Color(27, 28, 82);
    Color pillow = new Color(223, 247, 247);
    Font text = new Font("SansSerif",Font.PLAIN,17);
    JButton co;
    JPanel p;
    JButton online;
    JButton thrift;
    JButton mall;
    boolean cont;
    Player newUser;
    Home(Player player)
    {
        this.newUser = player;
        JFrame f = new JFrame();
        setSize(700, 600);
        p = new JPanel(null);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        co = new JButton("Continue");
        co.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont = true;
                repaint();
                co.setVisible(false);
            }
        });
        online = new JButton("Online");
        online.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {newUser.addHS(2);//adds 2 points to childs high score
                System.out.println(newUser.getHS());}
        });
        thrift = new JButton("Thrift Store");
        thrift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {newUser.addHS(4);//adds 4 points to childs high score
                System.out.println(newUser.getHS());}
        });
        mall = new JButton("Mall");
        mall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//adds 0 points to childs high score
                System.out.println(newUser.getHS());}
        });
        p = new JPanel(null);

        p.add(co);
        co.setBounds(575,530,100,25);
        p.add(mall);
        mall.setBounds(315, 390, 100, 25);
        p.add(online);
        online.setBounds(315, 430, 100, 25);
        p.add(thrift);
        thrift.setBounds(315, 470, 100, 25);

        this.add(p);
        online.setVisible(true);
        mall.setVisible(true);
        thrift.setVisible(true);
        p.repaint();
        setResizable (false);
        setBounds (0,0,700,600);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if(!cont)
        {
            g2.setColor(wall);
            g2.fillRect(0,0,700,600);
            g2.setColor(floor);
            g2.fillRect(0, 400, 700, 600);
            //window
            BasicStroke s = new BasicStroke(5);
            g2.setStroke(s);
            g2.setColor(sky);
            g2.fillRect(240, 90, 230, 225);
            g2.setColor(floor);
            g2.drawRect(240, 90, 230, 225);
            g2.drawLine(240, 203, 470, 203);
            g2.drawLine(355, 90, 355, 315);

            //carpet
            g2.setColor(rug);
            int XP[] = {52, 142, 542, 452};
            int YP[] = {560, 450, 450, 560};
            g2.fillPolygon(XP, YP, 4);
            BasicStroke bs = new BasicStroke(15);
            g2.setStroke(bs);
            g2.setColor(rugB);
            g2.drawPolygon(XP, YP, 4);

            //bed
            g2.setColor(bed);
            //headboard
            BasicStroke bbs = new BasicStroke(5);
            g2.setStroke(bbs);
            g2.drawLine(132, 510, 132, 455);
            int x[] = {130, 200, 200, 130};
            int y[] = {475, 395, 340, 420};
            g2.fillPolygon(x, y, 4);
            //sheets
            g2.setColor(sky);
            int xP[] = {132, 202, 512, 442};
            int yP[] = {470, 390, 390, 470};
            g2.fillPolygon(xP, yP, 4);
            g2.fillRect(132, 470, 310, 30);
            //pillow
            g2.setColor(pillow);
            int xPP[] = {160, 200, 190, 150};
            int yPP[] = {465, 415, 370, 420};
            g2.fillPolygon(xPP, yPP, 4);
            //backboard
            g2.setColor(bed);
            g2.drawLine(444, 510, 444, 470);
            g2.drawLine(508, 390, 508, 430);
            int xPo[] = {442, 510, 510, 442};
            int yPo[] = {450, 370, 405, 485};
            g2.fillPolygon(xPo, yPo, 4);

            CommonGraphics c = new CommonGraphics();
            c.person(250, 350, g2);
            //speech bubble
            g2.setColor(Color.WHITE);
            int xx[] = {315, 365, 365, 565, 565};
            int yy[] = {380, 360, 280, 280, 380};
            g2.fillPolygon(xx, yy, 5);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(xx, yy, 5);
            g2.setFont(text);
            g2.drawString("I really need new", 375, 305);
            g2.drawString("clothes! Where should", 375, 330);
            g2.drawString("I shop for them?", 375, 355);

        }
        else
        {
            //when continue button is pressed, moves onto the leaderborad
            End e= new End(newUser);
            online.setVisible(false);
            mall.setVisible(false);
            thrift.setVisible(false);
            e.setVisible(true);
            e.repaint();
            e.revalidate();
        }
    }
}
