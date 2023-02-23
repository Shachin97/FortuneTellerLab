import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl, topPnl, centerPnl, bottomPnl;
    JButton quitBtn, fortuneBtn;

    TextArea fortuneTA;

    JScrollPane pane;

    JLabel iconLbl;
    ImageIcon fortuneIcon;



    String [] fortunes = {"Fortunes awaits you", "Your lucky number is 8", "A friend asks only for your time not your money.","A pleasant surprise is waiting for you."
    ,"A light heart carries you through all the hard times.","A smile is your personal welcome mat.","Allow compassion to guide your decisions.","At the touch of love, everyone becomes a poet.",
            "Believe in yourself and others will too.", "Believe it can be done.","All will go well with your new project.","Do not make extra work for yourself.","Don’t let the past and useless detail choke your existence."};
    int curFortuneDex = -1;
    int newFortuneDex;
    public FortuneTellerFrame()
    {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth * 3/4, 600);
        setLocation(screenWidth / 8, (screenHeight-600)/2);


        createGUI();

        setTitle("FortuneTeller");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void createGUI()
    {

        mainPnl = new JPanel();
        topPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        add(mainPnl);
        createTopPnl();
        createCenterPnl();
        createBottomPnl();

    }

    private void createBottomPnl()
    {
        fortuneBtn = new JButton("Whats today Fortune");
        fortuneBtn.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
        fortuneBtn.addActionListener((ActionEvent ae) -> {

            do {
                Random rand = new Random();
                newFortuneDex = rand.nextInt(fortunes.length);}

            while(newFortuneDex == curFortuneDex);

            curFortuneDex = newFortuneDex;
            fortuneTA.append(fortunes[curFortuneDex]+ "\n");});

        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Serif", Font.BOLD, 14));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.setLayout(new GridLayout(1,2));

        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);

    }

    private void createCenterPnl()
    {
        fortuneTA = new TextArea(10, 40);
        pane = new JScrollPane(fortuneTA);
        centerPnl.add(pane);

    }

    private void createTopPnl()
    {
        fortuneIcon = new ImageIcon("src//FortuneLab.jpg");

        iconLbl = new JLabel("Do read your Fortune", fortuneIcon, JLabel.CENTER );
        iconLbl.setFont(new Font("Serif", Font.PLAIN, 20));

        iconLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconLbl.setVerticalTextPosition(JLabel.BOTTOM);
        topPnl.add(iconLbl);

    }

}
