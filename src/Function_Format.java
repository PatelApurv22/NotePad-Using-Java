import java.awt.*;
import java.text.Format;

public class Function_Format {

    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;
    int selectedFontSize;
    public Function_Format(GUI gui)
    {
        this.gui = gui;
    }

    public void wordWarp()
    {
        if (!gui.wordWarpOn)
        {
            gui.wordWarpOn=true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWarp.setText("Word Warp :ON");
        }
        else
        {
            gui.wordWarpOn=false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWarp.setText("Word Warp :Off");

        }
    }

    public void createFont(int fontSize)
    {
        selectedFontSize = fontSize;
        arial= new Font("Arial",Font.PLAIN,selectedFontSize);
        comicSansMS = new Font("Comic Sans MS",Font.PLAIN, selectedFontSize);
        timesNewRoman = new Font("Times New Roman",Font.PLAIN, selectedFontSize);
        setFont(selectedFont);
    }

    public void setFont(String font)
    {
        selectedFont =font;
        switch(selectedFont)
        {
            case "Arial" -> gui.textArea.setFont(arial);
            case "Comic Sans MS" -> gui.textArea.setFont(comicSansMS);
            case "Times New Roman" -> gui.textArea.setFont(timesNewRoman);

        }
    }

    public void setFontBold()
    {

      gui.textArea.getSelectedText();

    }

}
