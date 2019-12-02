package com.mine;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;

/**
 * @ClassName: ImageViewer
 * @Desc:   windows 10 not support
 * @author: yanyimin
 * @date: 2019/11/24
 * @version: v1.0
 */
public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }


}

/**
 *
 */
class ImageViewerFrame extends JFrame {
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=400;

    public ImageViewerFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //use a label to display the images
        label = new JLabel();
        add(label);

        //set up the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        //set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //add menu
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        //add menu item
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);


        openItem.addActionListener(event -> {
            //show file chooser dialog
            int result = chooser.showOpenDialog(null);

            //if file selcted, set it as icon of the label
            if(result == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}
