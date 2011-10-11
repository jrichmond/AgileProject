package com.StockTake;

import android.app.Activity;
import android.os.Bundle;

public class AgileProjectActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try
        {
			StockManager myStockmanager = new StockManager();
			//myStockmanager.initConnection("cqwalker@dundee.ac.uk", "mcdjtotallyrocks");
			myStockmanager.isConnectionOkay();
        }
        // catch (java.lang.reflect.InvocationTargetException e)
        catch (Exception e)
        {
        	System.out.print(e.getMessage());
        }
    }
}