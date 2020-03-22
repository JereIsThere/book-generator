import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UIClass {
    //start of fields
    //<editor-fold desc="main stuff">
    private final String programName = "Book Generator";
    private final Dimension dms_pnl_main = new Dimension(500, 500);

    private JFrame frame;
    private JPanel pnl_main;
    //</editor-fold>

    //<editor-fold desc="file panel">
    private JPanel pnl_file;

    private JTextField tf_filePath_old;
    private JTextField tf_filePath_new;
    private JButton btn_browse_old;
    private JButton btn_browse_new;
    //</editor-fold>

    //<editor-fold desc="reflow panel">
    private JPanel pnl_reflow;

    private JLabel lbl_linesInfo;
    private JLabel lbl_charsInfo;
    private JLabel lbl_sampleChapterHeader;
    private JLabel lbl_linesPerChapterHeader;

    private JTextField tf_numberOfLines;
    private JTextField tf_numberOfChars;
    private JTextField tf_sampleChapterHeader;
    private JTextField tf_linesPerChapterHeader;
    //</editor-fold>

    //<editor-fold desc="options panel">
    private JPanel pnl_options;
    private JCheckBox cb_generateLineNumbers;
    //</editor-fold>

    private JButton btn_export;

    //<editor-fold desc="misc">
    private List<Image> taskBarIcons;
    //</editor-fold>

    //end of fields
    //<editor-fold desc="initializing stuff">
    private void initVars() {
        initMainStuff();
        initFilePanel();
        initReflowPanel();
        initOptionsPanel();
        initMisc();

        setUpLayout();
    }

    private void setUpLayout() {
        pnl_main.add(pnl_file, "center, pushx, growx, wrap");
        pnl_main.add(pnl_reflow, "center, pushx, growx, wrap");
        pnl_main.add(pnl_options, "center, split 2");
        pnl_main.add(btn_export, "center, grow");
    }

    private void initMainStuff() {
        //init frame
        frame = new JFrame(programName);

        //init main panel
        pnl_main = new JPanel(new MigLayout());
    }

    private void initFilePanel() {
        //panel
        pnl_file = new JPanel();
        Border filePanelBorder = BorderFactory.createTitledBorder("file");
        pnl_file.setBorder(filePanelBorder);
        pnl_file.setLayout(new MigLayout("", "[] []", "[] [] []"));

        //textfields
        tf_filePath_old = new JTextField();
        tf_filePath_old.setText("filepath of old file");

        tf_filePath_new = new JTextField();
        tf_filePath_new.setText("filepath of new file");

        //buttons
        btn_browse_old = new JButton("browse");
        btn_browse_old.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO implement JFileChooser for old
            }
        });

        btn_browse_new = new JButton("browse");
        btn_browse_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO implement JFileChooser for new
            }
        });

        //layout
        pnl_file.add(tf_filePath_old, "growx, pushx, sg 1, split 2");
        pnl_file.add(btn_browse_old, "right, sg 2, wrap");
        pnl_file.add(tf_filePath_new, "growx, pushx, sg 1, split 2");
        pnl_file.add(btn_browse_new, "right, sg 2, wrap");
    }

    private void initReflowPanel() {
        //panel
        pnl_reflow = new JPanel();
        Border reflowBorder = BorderFactory.createTitledBorder("reflow options");
        pnl_reflow.setBorder(reflowBorder);
        pnl_reflow.setLayout(new MigLayout("", "[] []", "[] [] [] []"));

        //labels
        lbl_linesInfo = new JLabel("input number of lines per page:");

        lbl_charsInfo = new JLabel("input number of characters per line:");

        lbl_sampleChapterHeader = new JLabel("input sample chapter header (eg: \"Chapter 1\"");

        lbl_linesPerChapterHeader = new JLabel("input number of lines, a chapter header takes up");

        //textfields
        tf_numberOfLines = new JTextField();
        tf_numberOfLines.setText("number of lines");

        tf_numberOfChars = new JTextField();
        tf_numberOfChars.setText("number of characters");

        tf_sampleChapterHeader = new JTextField();

        tf_linesPerChapterHeader = new JTextField();

        //layout
        pnl_reflow.add(lbl_linesInfo, "split 2, sg 3");
        pnl_reflow.add(tf_numberOfLines, "right, pushx, growx, sg 4, wrap");

        pnl_reflow.add(lbl_charsInfo, "split 2, sg 3");
        pnl_reflow.add(tf_numberOfChars, "right, pushx, growx, sg 4, wrap");

        pnl_reflow.add(lbl_sampleChapterHeader, "split 2, sg 3");
        pnl_reflow.add(tf_sampleChapterHeader, "right, pushx, growx, sg 4, wrap");

        pnl_reflow.add(lbl_linesPerChapterHeader, "split 2, sg 3");
        pnl_reflow.add(tf_linesPerChapterHeader, "right, pushx, growx, sg 4, wrap");
    }

    private void initOptionsPanel() {
        //panel
        pnl_options = new JPanel();
        Border optionsBorder = BorderFactory.createTitledBorder("options");
        pnl_options.setBorder(optionsBorder);
        pnl_options.setLayout(new FlowLayout());

        //checkbox
        cb_generateLineNumbers = new JCheckBox("generate line numbers");

        //layout
        pnl_options.add(cb_generateLineNumbers);
    }

    private void initMisc() {
        //init icons
        taskBarIcons = new ArrayList<>();

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();

        Image mainIcon = defaultToolkit.getImage("resources/taskbar-icon_full.png");
        Image midIcon = defaultToolkit.getImage("resources/taskbar-icon_32x32.png");

        taskBarIcons.add(mainIcon);
        taskBarIcons.add(midIcon);

        //export button
        btn_export = new JButton("Export");
        btn_export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //TODO implement export
            }
        });
        btn_export.setEnabled(false);
    }
    //</editor-fold>

    public void startUI() {
        setLookAndFeel();

        initVars();

        startFrame();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void startFrame() {
        frame.setIconImages(taskBarIcons);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(pnl_main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
