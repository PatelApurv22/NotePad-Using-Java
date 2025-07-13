import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
    GUI gui;
    public KeyHandler(GUI gui)
    {
        this.gui =gui;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {


        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O)
        {
            gui.file.Open();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S)
        {
            gui.file.Save();
        }
        if(e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_S)
        {
            gui.file.SaveAs();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_P)
        {
            gui.file.print();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_W)
        {
            gui.file.Exit();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z)
        {
            gui.edit.undo();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Y)
        {
            gui.edit.redo();
        }
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F)
        {
            gui.menuFile.doClick();
        }
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_E)
        {
            gui.menuEdit.doClick();
        }
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_O)
        {
            gui.menuFormat.doClick();
        }
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_C)
        {
            gui.menuColor.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
