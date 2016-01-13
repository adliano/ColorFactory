/*
 ******************************************************
 Author      :  Adriano Alves
 Date        : 11/21/15
 Program Name: ColorFactory.java
 Objective   : HW4 CS211S 
               This program mix colors and gives user 
               color base values       
 ******************************************************
*/
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class ColorFactory
{
    JFrame frame;
    JPanel topPanel, lowerPanel, componentsPanel;
    JPanel bannerPanel, innerLeftPanel, innerRightPanel;
    JPanel redValuePanel, greenValuePanel, blueValuePanel;
    JRadioButton decimal, octal, binary, hex;
    JSlider sliderRed, sliderGreen, sliderBlue; 
    int intRed, intGreen, intBlue;

    /****** constructor ******/
    public ColorFactory()
    {
       /******** DRAWS ********/
       DrawOval draw = new DrawOval();
                draw.setBackground(Color.DARK_GRAY);
       DrawRectangle redRect = new DrawRectangle(" RED : ", Color.RED,"decimal");
                     redRect.setBackground(Color.BLACK);
       DrawRectangle greenRect = new DrawRectangle(" GREEN : ", Color.GREEN,"decimal");
                     greenRect.setBackground(Color.BLACK);
       DrawRectangle blueRect = new DrawRectangle(" BLUE : ", Color.BLUE,"decimal");
                     blueRect.setBackground(Color.BLACK);
       /********* FRAME ********/
       frame = new JFrame("Color Factory");
       frame.setLayout(new GridLayout(3,1));
       frame.setSize(750, 600);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       //panel that hold banner
       bannerPanel = new JPanel(new FlowLayout());
       bannerPanel.setBackground(Color.BLACK);
       JLabel banner = new JLabel();
              banner.setIcon(new ImageIcon("CF1.png"));
              bannerPanel.add(banner);
       /******* RADIO BUTTONS **********/
       //panel inside componentsPanel-left radios buttons
       innerLeftPanel = new JPanel(new GridLayout(2,2,10,10));
       String title = "<html><h2 style=\"color:white\">Base Values</h2>";
       innerLeftPanel.setBorder(BorderFactory.createTitledBorder(title));
       innerLeftPanel.setBackground(Color.BLACK);
       String tipColor = "black";
       // DEFAULT / Decimal RadioButton
       decimal = new JRadioButton(mkText("Decimal"),true);
       decimal.setBackground(Color.ORANGE);
       decimal.setToolTipText(tip(" Select it for Decimal base value ",tipColor));
       // Octal RadioButton
       octal = new JRadioButton(mkText("Octal"),false);
       octal.setBackground(Color.WHITE);
       octal.setToolTipText(tip(" Select it for Octal base value ",tipColor));
       // Binary RadioButton
       binary = new JRadioButton(mkText("Binary"),false);
       binary.setBackground(Color.WHITE);
       binary.setToolTipText(tip(" Select it for Binary base value ",tipColor));
       // Hex RadioButton
       hex = new JRadioButton(mkText("Hex"),false);
       hex.setBackground(Color.WHITE);
       hex.setToolTipText(tip(" Select it for Hex base value ",tipColor));
       // ButtonGroup
       ButtonGroup group = new ButtonGroup();
                   group.add(decimal);
                   group.add(octal);
                   group.add(binary);
                   group.add(hex);
       //**** radiobuttons ActionListener ****//
       ActionListener action = new ActionListener()
       {
          /* ****** actionPerformed() ****** */
          public void actionPerformed(ActionEvent e)
          {
             if(decimal.isSelected()) 
             {
                redRect.setBaseType("decimal");
                redRect.repaint();
                greenRect.setBaseType("decimal");
                greenRect.repaint();
                blueRect.setBaseType("decimal");
                blueRect.repaint();
                decimal.setBackground(Color.ORANGE);
             }
             else decimal.setBackground(Color.WHITE);

             if(octal.isSelected())
             {
                redRect.setBaseType("octal");
                redRect.repaint();
                greenRect.setBaseType("octal");
                greenRect.repaint();
                blueRect.setBaseType("octal");
                blueRect.repaint();
                octal.setBackground(Color.ORANGE);
             }
             else octal.setBackground(Color.WHITE);

             if(binary.isSelected())
             {
                redRect.setBaseType("binary");
                redRect.repaint();
                greenRect.setBaseType("binary");
                greenRect.repaint();
                blueRect.setBaseType("binary");
                blueRect.repaint();
                binary.setBackground(Color.ORANGE);
             }
             else binary.setBackground(Color.WHITE);

             if(hex.isSelected())
             {
                redRect.setBaseType("hex");
                redRect.repaint();
                greenRect.setBaseType("hex");
                greenRect.repaint();
                blueRect.setBaseType("hex");
                blueRect.repaint();
                hex.setBackground(Color.ORANGE);
             }
             else hex.setBackground(Color.WHITE);
          }
       };
       // adding Action
       decimal.addActionListener(action);
       octal.addActionListener(action);
       binary.addActionListener(action);
       hex.addActionListener(action);
       // adding to panel
       innerLeftPanel.add(decimal);
       innerLeftPanel.add(octal);
       innerLeftPanel.add(binary);
       innerLeftPanel.add(hex);
       /************** SLIDERS ************/
       //panel inside componentsPanel-right
       innerRightPanel = new JPanel(new GridLayout(3,1,5,5));
       String title2 = "<html><h2 style=\"color:white\">COLORS</h2>";
       innerRightPanel.setBorder(BorderFactory.createTitledBorder(title2)); 
       innerRightPanel.setBackground(Color.BLACK);
       //RED Slider
       sliderRed = new JSlider(0,255,0);
       sliderRed.setBackground(Color.RED);
       sliderRed.setToolTipText(tip(" Red Color Mixer ","red"));
       //GREEN Slider
       sliderGreen = new JSlider(0,255,0);
       sliderGreen.setBackground(Color.GREEN);
       sliderGreen.setToolTipText(tip(" Green Color Mixer ","green"));
       //BLUE Slider
       sliderBlue = new JSlider(0,255,0);
       sliderBlue.setBackground(Color.BLUE);
       sliderBlue.setToolTipText(tip(" Blue Color Mixer ","blue"));
       //****** Sliders ChangeListener ********//
       ChangeListener change = new ChangeListener()
       {
          /* *** stateChanged() *** */
          public void stateChanged(ChangeEvent e)
          {
             intRed = sliderRed.getValue();
             intGreen = sliderGreen.getValue();
             intBlue = sliderBlue.getValue();
             // updating oval color
             draw.setColor(new Color(intRed,intGreen,intBlue));
             draw.repaint();
             // uptating red color vlue
             redRect.setColorAmount(intRed);
             redRect.repaint();
             // updating green color value
             greenRect.setColorAmount(intGreen);
             greenRect.repaint();
             // uodating blue color value
             blueRect.setColorAmount(intBlue);
             blueRect.repaint();
          }
       };
       sliderRed.addChangeListener(change);
       sliderGreen.addChangeListener(change);
       sliderBlue.addChangeListener(change);
       // adding to panel
       innerRightPanel.add(sliderRed);
       innerRightPanel.add(sliderGreen);
       innerRightPanel.add(sliderBlue);
       //panel under banner to hold components
       componentsPanel = new JPanel(new GridLayout(1,2,10,10));
       componentsPanel.setBackground(Color.BLACK);
       componentsPanel.add(innerLeftPanel);
       componentsPanel.add(innerRightPanel);
       // TOP PANEL
       topPanel = new JPanel(new GridLayout(2,1,0,0)); 
       topPanel.setBackground(Color.BLACK);
       topPanel.add(bannerPanel);
       topPanel.add(componentsPanel);
       // set initial color
       intRed = sliderRed.getValue();
       intGreen = sliderGreen.getValue();
       intBlue = sliderBlue.getValue();
       draw.setColor(new Color(intRed,intGreen,intBlue));
       /************ Lower Panel **************/
       lowerPanel = new JPanel(new GridLayout(4,1,5,5));
       lowerPanel.setBackground(Color.BLACK);
       lowerPanel.add(redRect);
       lowerPanel.add(greenRect);
       lowerPanel.add(blueRect);
       String author = "<html><h3 style=\"color:white\">by Adriano</h3>";
       JLabel my = new JLabel(author, SwingConstants.RIGHT);
              my.setBackground(Color.DARK_GRAY);
              my.setOpaque(true);
              my.setBorder(BorderFactory.createLineBorder(Color.WHITE));
       lowerPanel.add(my);

       // adding to JFrame
       frame.add(topPanel);
       frame.add(draw);
       frame.add(lowerPanel);
    }
    /********** tip() ***********/
    public static String tip(String msg, String color)
    {
        return("<html><body style=\"color:"+color+"; background-color:white\">"+
              "<p><b>"+msg+"</p></body></html>");
    }
    /*********** mkText() *********/
    public static String mkText(String txt)
    {
       return "<html><b><h2 style=\"color:black\">"+txt+"</h2>";
    }
    /********** println() ********/
    public static void println(Object o)
    {
       System.out.println(""+o);
    }

/** =============== inner class ================== **/
class DrawOval extends Canvas
{
    Color COLOR ;

    /******** setColor *******/
    public void setColor(Color color)
    {
       COLOR = color;
    }
    /********* paintComponent() *********/
    @Override
    public void paint(Graphics g)
    {
        int diam = Math.min(getWidth(), getHeight())-10;
        int x = getWidth()-10;

        g.setColor(COLOR);
        g.fillOval(5, 5, x, diam);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10));
        g.setColor(Color.WHITE);
        g.drawOval(5, 5, x, diam);
    }
}
/** ================ inner class =============== **/
class DrawRectangle extends Canvas
{
    int COLOR_AMOUNT;
    String COLOR_NAME, BASE_TYPE;
    Color COLOR;

    /********* constructor ********/
    public DrawRectangle(String colorName, Color color, String base)
    {
        COLOR_NAME = colorName;
        COLOR = color;
        BASE_TYPE = base;
    }
    /********* setColorAmount() ***********/ 
    public void setColorAmount(int amount)
    {
       COLOR_AMOUNT = amount;
    }
    /*********** setBaseType() ***********/
    public void setBaseType(String base)
    {
       BASE_TYPE = base;
    }
    /********* paintComponent() *********/
    @Override
    public void paint(Graphics g)
    {
       Font font = new Font("Serif", Font.BOLD, 20);
       String temp = null; 
       int W = (getSize().width)-15; // 15 px border
       int T, X;

       g.setColor(COLOR);
       // set X to maximum size of scree
       X = (W*COLOR_AMOUNT)/255;
       g.fill3DRect(10, 10, X, 50, true);
       g.setColor(Color.WHITE);
       g.setFont(font);

       switch(BASE_TYPE)
       {
          case "decimal":
               T = g.getFontMetrics().stringWidth(COLOR_NAME+COLOR_AMOUNT);
               X = (((W-T)*COLOR_AMOUNT)/255);
               g.drawString(COLOR_NAME + COLOR_AMOUNT, (X+10), 30);
               break;
          case "octal":
               temp = Integer.toOctalString(COLOR_AMOUNT);
               T = g.getFontMetrics().stringWidth(COLOR_NAME+temp);
               X = ((W-T)*COLOR_AMOUNT)/255;
               g.drawString(COLOR_NAME + temp, (X+10), 30);
               break;
          case "binary":
               temp = Integer.toBinaryString(COLOR_AMOUNT);
               T = g.getFontMetrics().stringWidth(COLOR_NAME+temp);
               X = ((W-T)*COLOR_AMOUNT)/255;
               g.drawString(COLOR_NAME + temp, (X+10), 30);
               break;
          case "hex":
               temp = Integer.toHexString(COLOR_AMOUNT);
               T = g.getFontMetrics().stringWidth(COLOR_NAME+temp);
               X = ((W-T)*COLOR_AMOUNT)/255;
               g.drawString(COLOR_NAME + temp, (X+10), 30);
               break;
       }

    }
}
    /**************** main() *******************/
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
           public void run()
           {
              new ColorFactory();
           }
        });
    }
}
//END
