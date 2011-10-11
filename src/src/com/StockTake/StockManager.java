package com.StockTake;

import java.net.URL;

import com.google.gdata.client.finance.FinanceService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.finance.PortfolioData;
import com.google.gdata.data.finance.PortfolioEntry;
import com.google.gdata.data.finance.PortfolioFeed;
import com.google.gdata.util.AuthenticationException;

public class StockManager
{
	private static FinanceService myGoogleConnection = null;
	private String portfolioFeedURL = "http://finance.google.com/finance/feeds/default/portfolios";
	private PortfolioFeed portfolioFeed = null;

	public StockManager()
	{
		
	}
/*
	
	public boolean initConnection(String uname, String pword)
	{
		try
		{
			myGoogleConnection = new FinanceService("companyName-applicationName-versionNumber");
			myGoogleConnection.setUserCredentials(uname, pword);
		}
		catch (AuthenticationException e)
		{
			// Do nothing-check validity of connection through
			// isConnectionOkay()
			return false;
		}
		
		return true;
	}*/

	
	public boolean isConnectionOkay()
	{
		return myGoogleConnection == null ? false : true;
	}

	public FinanceService getService()
	{
		return myGoogleConnection;
	}

	public Boolean doesPortfolioExist()
	{
		try
		{
			portfolioFeed = getService().getFeed(new URL(portfolioFeedURL), PortfolioFeed.class);
		}
		catch (Exception e)
		{
			return false;
		}
		if (portfolioFeed == null)
		{
			return false;
		}
		return portfolioFeed.getEntries().isEmpty() ? false : true;
	}


	public boolean createPortfolio()
	{
		if (doesPortfolioExist())
		{
			return false;
		}
		PortfolioEntry entry = new PortfolioEntry();
		entry.setTitle(new PlainTextConstruct("JASS"));
		PortfolioData data = new PortfolioData();
		data.setCurrencyCode("GBP");
		entry.setPortfolioData(data);
		try
		{
			getService().insert(new URL(portfolioFeedURL), entry);
		}
		catch (Exception e)
		{
			// Communication error.
			return false;
		}
		return true;
	}

	public PortfolioFeed getPortfolio()
	{
		if (!doesPortfolioExist())
		{
			return null;
		}
		return portfolioFeed;
	}
}

