import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String fileName,fileAddress;
    public Function_File(GUI gui)
    {
        this.gui=gui;
    }
    public void newFile()
    {
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void Open()
    {
        FileDialog fd = new FileDialog(gui.window, "Open",FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile()!=null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        System.out.println("File Name & File Address"+fileAddress+fileName);
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            gui.textArea.setText("");
            String line;
            while((line=br.readLine())!=null)
            {
                gui.textArea.append(line+"\n");
            }
            br.close();

        }
        catch (Exception e){
            System.out.println("File Not Opened");
        }
    }
    
    public void Save()
    {
        if(fileName ==null)
        {
            SaveAs();
        }
        else
        {
            try
            {
                FileWriter fw= new FileWriter(fileAddress+fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            }
            catch (Exception e)
            {
                System.out.println("Something went Wrong");
            }
        }

    }
    
    public void SaveAs()
    {
        FileDialog fd = new FileDialog(gui.window, "SaveAs",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try
        {
            FileWriter fw= new FileWriter(fileAddress+fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("File Not Saved");
        }
    }
    public void print()
    {
        PrinterJob job = PrinterJob.getPrinterJob();
        try
        {
            if (job.printDialog())
            {
             job.print();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void pagesetup()
    {
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf =pj.pageDialog(pj.defaultPage());
    }

    public void Exit()
    {
        System.exit(0);
    }
}
