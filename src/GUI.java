import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    //File
    JMenu menuFile,menuEdit,menuFormat,menuColor;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit,iPrint,iPageSetUp;
    //Edit
    JMenuItem iUndo,iRedo;
    //Format
    JMenu menuFont,menuFontSize;
    JMenuItem iWarp,iFontArial,iFontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize32,boldMenuItem;
    //Color
    JMenuItem iColor1,iColor2,iColor3;
    boolean wordWarpOn=false;
    Function_File file = new Function_File(this);
    Function_Edit edit =new Function_Edit(this);
    Function_Format format =new Function_Format(this);
    Function_Color color =new Function_Color(this);
    KeyHandler kHandler = new KeyHandler(this);
    UndoManager um = new UndoManager();


    public static void main(String[] args) {
        new GUI();
    }
    public GUI()
    {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenuItem();
        createFormatMenu();
        createColorMenu();
        createEditMenuItem();
        format.selectedFont = "Arial";
        format.selectedFontSize = 10;
        format.createFont(16);
        format.wordWarp();
        color.changeColor("White");
        window.setVisible(true);
    }


    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(1000,600);
        window.setLocation(200,50);
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("NOTEPAD.png"));
        window.setIconImage(icon.getImage());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea()
    {
        textArea = new JTextArea();

        textArea.addKeyListener(kHandler);

        textArea.getDocument().addUndoableEditListener(e -> um.addEdit(e.getEdit()));

        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuFormat = new JMenu("Format");
        menuColor = new JMenu("Color");

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFormat);
        menuBar.add(menuColor);
    }
    public void createFileMenuItem()
    {
        iNew = new JMenuItem("New");
        iOpen = new JMenuItem("Open");
        iSave = new JMenuItem("Save");
        iSaveAs = new JMenuItem("Save As");
        iExit = new JMenuItem("Exit");
        iPrint = new JMenuItem("Print");
        iPageSetUp =new JMenuItem("Page Setup");

        iNew.addActionListener(this);
        iNew.setActionCommand("New");

        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");

        iSave.addActionListener(this);
        iSave.setActionCommand("Save");

        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");

        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");

        iPrint.addActionListener(this);
        iPrint.setActionCommand("Print");

        iPageSetUp.addActionListener(this);
        iPageSetUp.setActionCommand("pagesetup");


        menuFile.add(iNew);
        menuFile.add(iOpen);
        menuFile.add(iSave);
        menuFile.add(iSaveAs);
        menuFile.add(iPrint);
        //menuFile.add(iPageSetUp);
        menuFile.add(iExit);
    }
    public void createEditMenuItem()
    {
        iUndo = new JMenuItem("Undo");
        iRedo = new JMenuItem("Redo");

        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");

        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");

        menuEdit.add(iUndo);
        menuEdit.add(iRedo);

    }
    public void createFormatMenu()
    {
        iWarp = new JMenuItem("Word Warp :Off");
        menuFont  = new JMenu("Font");
        menuFontSize = new JMenu("Font Size");

        iWarp.addActionListener(this);
        iWarp.setActionCommand("Word Warp");


        iFontArial = new JMenuItem("Arial");
        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontTNR = new JMenuItem("Times New Roman");

        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");

        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");

        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");

        boldMenuItem = new JMenuItem(new StyledEditorKit.BoldAction());
        boldMenuItem.addActionListener(this);
        boldMenuItem.setActionCommand("bold");

        menuFont.add(iFontArial);
        menuFont.add(iFontCSMS);
        menuFont.add(iFontTNR);

        iFontSize8 = new JMenuItem("8");
        iFontSize12 = new JMenuItem("12");
        iFontSize16 = new JMenuItem("16");
        iFontSize20 = new JMenuItem("20");
        iFontSize24 = new JMenuItem("24");
        iFontSize32 = new JMenuItem("32");

        iFontSize8.addActionListener(this);
        iFontSize12.addActionListener(this);
        iFontSize16.addActionListener(this);
        iFontSize20.addActionListener(this);
        iFontSize24.addActionListener(this);
        iFontSize32.addActionListener(this);

        iFontSize8.setActionCommand("size8");
        iFontSize12.setActionCommand("size12");
        iFontSize16.setActionCommand("size16");
        iFontSize20.setActionCommand("size20");
        iFontSize24.setActionCommand("size24");
        iFontSize32.setActionCommand("size32");

        menuFontSize.add(iFontSize8);
        menuFontSize.add(iFontSize12);
        menuFontSize.add(iFontSize16);
        menuFontSize.add(iFontSize20);
        menuFontSize.add(iFontSize24);
        menuFontSize.add(iFontSize32);

        menuFormat.add(iWarp);
        menuFormat.add(menuFont);
        menuFormat.add(menuFontSize);
        //menuFormat.add(boldMenuItem);


    }
    public void createColorMenu()
    {
        iColor1 = new JMenuItem("White");
        iColor2 = new JMenuItem("Black");
        iColor3 = new JMenuItem("Blue");

        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");

        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");

        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");

        menuColor.add(iColor1);
        menuColor.add(iColor2);
        menuColor.add(iColor3);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        String command = e.getActionCommand();

        switch (command) {
            case "New" -> file.newFile();
            case "Open" -> file.Open();
            case "Save" -> file.Save();
            case "SaveAs" -> file.SaveAs();
            case "Print" -> file.print();
            case "pagesetup" -> file.pagesetup();
            case "Exit" -> file.Exit();
            case "Word Warp" -> format.wordWarp();
            case "Arial", "Comic Sans MS","Times New Roman" -> format.setFont(command);
            case "size8" -> format.createFont(8);
            case "size12" -> format.createFont(12);
            case "size16" -> format.createFont(16);
            case "size20" -> format.createFont(20);
            case "size24" -> format.createFont(24);
            case "size32" -> format.createFont(32);
            case "bold" -> format.setFontBold();
            case "White","Black","Blue" -> color.changeColor(command);
            case "Undo"-> edit.undo() ;
            case "Redo"-> edit.redo() ;

        }
    }
}
