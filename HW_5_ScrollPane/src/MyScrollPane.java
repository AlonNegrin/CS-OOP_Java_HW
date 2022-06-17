import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MyScrollPane {

    JFrame mainFrame;
    JScrollBar westScrollBar;
    JScrollBar southScrollBar;
    JPanel scrollPanel;
    Component contentPage;

    final int contentHeight;
    final int contentWidth;


    public MyScrollPane(Component container) {


        //get content dimensions.
        contentPage = container;
        contentHeight = contentPage.getHeight();
        contentWidth = contentPage.getWidth();

        //creating the main frame for our scroll bar adjustment.
        mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setPreferredSize(new Dimension(contentWidth, contentHeight));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("ScrollPane Test");

        //creating a containing panel for the content for better control.
        scrollPanel = new JPanel();
        scrollPanel.setLayout(null);
        scrollPanel.setBackground(Color.BLUE);
        scrollPanel.add(container);


        //initialising 2 scroll bars, one horizontal and one vertical with adjustment methods.
        westScrollBar = new JScrollBar(Adjustable.VERTICAL);
        westScrollBar.addAdjustmentListener(e -> {
            int value = e.getValue();
            contentPage.setLocation(contentPage.getX(), -value);
            scrollPanel.repaint();
        });

        southScrollBar = new JScrollBar(Adjustable.HORIZONTAL);
        southScrollBar.addAdjustmentListener(e -> {
            int value = e.getValue();
            contentPage.setLocation(-value, contentPage.getY());
            scrollPanel.repaint();
        });


        mainFrame.add(westScrollBar, BorderLayout.WEST);
        mainFrame.add(southScrollBar, BorderLayout.SOUTH);
        mainFrame.add(scrollPanel, BorderLayout.CENTER);

        //adding a listener to catch and handle resizing events.
        mainFrame.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                int mainHeight = mainFrame.getHeight();
                int mainWidth = mainFrame.getWidth();

                westScrollBar.setMaximum(contentHeight);
                westScrollBar.setMinimum(0);
                westScrollBar.setVisibleAmount(mainHeight / 4);

                southScrollBar.setMaximum(contentWidth);
                southScrollBar.setMinimum(0);
                southScrollBar.setVisibleAmount(mainWidth / 4);


                southScrollBar.setVisible(mainHeight <= contentHeight);
                westScrollBar.setVisible(mainWidth <= contentWidth);


            }


            //unimplemented methods that we do not need.
            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });

        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
