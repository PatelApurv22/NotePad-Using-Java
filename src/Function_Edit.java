public class Function_Edit {
    GUI gui;
    public Function_Edit (GUI gui)
    {
        this.gui = gui;
    }
    public void undo()
    {
        try
        {
            gui.um.undo();
        }
        catch (Exception e)
        {
            System.out.println("Something Went Wrong");
        }
    }
    public void redo()
    {
        try
        {
            gui.um.redo();
        }
        catch (Exception e)
        {
            System.out.println("Something Went Wrong");
        }

    }
}
