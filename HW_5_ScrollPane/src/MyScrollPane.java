import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MyScrollPane extends JPanel {

    JScrollBar westScrollBar;
    JScrollBar southScrollBar;
    JPanel scrollPanel;
    Component contentPage;
    final int contentHeight;
    final int contentWidth;

    public MyScrollPane(Component container) {

        //get content dimensions.
        contentPage = container;
        contentHeight = contentPage.getPreferredSize().height;
        contentWidth = contentPage.getPreferredSize().width;
        contentPage.setSize(contentPage.getPreferredSize());

        //creating the main panel for our scroll bar adjustment.
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(contentWidth, contentHeight));

        //creating a containing panel for the content for better control.
        scrollPanel = new JPanel();
        scrollPanel.setLayout(null);
        scrollPanel.setBackground(Color.BLUE);
        scrollPanel.add(container);

        //initialising 2 scroll bars, one horizontal and one vertical with adjustment methods
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

        //adding all components to main panel.
        this.add(westScrollBar, BorderLayout.WEST);
        this.add(southScrollBar, BorderLayout.SOUTH);
        this.add(scrollPanel, BorderLayout.CENTER);

        //adding a listener which handles resizing events.
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                westScrollBar.setMaximum(contentHeight - scrollPanel.getHeight() + southScrollBar.getHeight() / 2);
                westScrollBar.setMinimum(0);

                southScrollBar.setMaximum(contentWidth - scrollPanel.getWidth() + westScrollBar.getWidth() / 2);
                southScrollBar.setMinimum(0);

                westScrollBar.setVisible(scrollPanel.getHeight() <= contentHeight);
                southScrollBar.setVisible(scrollPanel.getWidth() <= contentWidth);

                contentPage.setSize(scrollPanel.getSize());
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

    }
}
