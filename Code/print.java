import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.PrintJob.*;
import java.io.*;


public class print extends JFrame 
	{
   /* public print(int type,String bkname,String custname,String amount)
    	{
        String data1;
        String data0 = "                   Lakshmi Motors(Authorised TVS ShowRoom)                 \n";    
        if(type==1)
             data1 = "                     Sale Bill                       \n\n";
        else
        	 data1 = "                     Service Bill                       \n\n";
        String data2 = "           Bike Name :     "+bkname;
        String data3 = "\n           Customer Name:     "+custname;
        String data4 = "\n           Purchased on:  "+LoginWindow.retDate();
        String data5 = "\n           Bill Amount:  Rs."+amount+"\n\n\n";
        String data6 = LoginWindow.branchdet;   
        String data = data0 + data1 + data2 +  data3 + data4 + data5 +  data6;
        printRecord( data);
     	}*/
    public print(String data)
    	{
    	printRecord(data);	
    	}
	void printRecord (String rec) 
		{
        StringReader sr = new StringReader (rec);
        LineNumberReader lnr = new LineNumberReader (sr);
		Font typeface = new Font ("Times New Roman", Font.PLAIN, 12);
		Properties p = new Properties ();
		PrintJob pJob = getToolkit().getPrintJob (this, "Print Customer Balance Report", p);
		if (pJob != null) 
			{
			Graphics gr = pJob.getGraphics ();
			if (gr != null) 
				{
				FontMetrics fm = gr.getFontMetrics (typeface);
				int margin = 20;
				int pageHeight = pJob.getPageDimension().height - margin;
    			int fontHeight = fm.getHeight();
	    		int fontDescent = fm.getDescent();
    			int curHeight = margin;
				String nextLine;
				gr.setFont (typeface);
				try 
					{
					do 
						{
						nextLine = lnr.readLine ();
						if (nextLine != null) 
							{         
							if ((curHeight + fontHeight) > pageHeight) 
								{	//New Page.
								gr.dispose();
								gr = pJob.getGraphics ();
								curHeight = margin;
								}							
							curHeight += fontHeight;
							if (gr != null) 
								{
								gr.setFont (typeface);
								gr.drawString (nextLine, margin, curHeight - fontDescent);
								}
							}
						}
						while (nextLine != null);					
					}
                catch (Exception E) 
                	{
                	System.err.println(E.toString());
                	}                               
			}
			gr.dispose();
		}
		if (pJob != null)
			pJob.end ();
	}
}	



