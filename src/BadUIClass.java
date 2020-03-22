import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UIClass {
    private JPanel pnl_file;
    private JPanel pnl_reflow;
    private JPanel pnl_options;
    private JTextField tf_filePath_old;
    private JButton btn_browse_old;
    private JTextField tf_filePath_new;
    private JButton btn_browse_new;
    private JLabel lbl_lines_info;
    private JTextField tf_numberOfLines;
    private JLabel lbl_sampleChapterHeader;
    private JTextField tf_sampleChapterHeader;
    private JLabel lbl_linesPerChapterHeader;
    private JTextField tf_linesPerChapterHeader;
    private JCheckBox rb_generateLineNumbers;
    private JButton btn_export;
    private JPanel pnl_main;
    private List<Image> taskBarIcons;
    private JFrame frame;

    public void startUI() {

        setLookAndFeel();

        initIconList();

        initJFrame();
        System.out.println(pnl_file.getLayout());
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void initIconList() {
        taskBarIcons = new ArrayList<>();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();

        Image mainIcon = defaultToolkit.getImage("resources/taskbar-icon_full.png");
        Image midIcon = defaultToolkit.getImage("resources/taskbar-icon_32x32.png");

        taskBarIcons.add(mainIcon);
        taskBarIcons.add(midIcon);
    }

    private void initJFrame() {
        frame = new JFrame("UIClass");
        frame.setIconImages(taskBarIcons);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new UIClass().pnl_main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
