package org.synack.see.ipc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.synack.see.See;
import org.synack.see.firewall.Firewall;
import org.synack.see.firewall.IptablesFirewall;
import org.synack.see.xml.Parser;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class FirewallInvoke extends UnicastRemoteObject implements InvokeControl
{
	private static final long serialVersionUID = 1L;
	private Firewall firewall;
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @throws RemoteException
	 * @throws Exception
	 */
	public FirewallInvoke() throws RemoteException, Exception
	{
		super();
		System.out.println("Firewall Invoked: "+super.getClientHost());
		firewall = new IptablesFirewall();
	}

	@Override
	public boolean save(String strXml) throws RemoteException
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(Parser.PATH_FILE_FIREWALL)); 
			out.write(strXml); 
			out.close();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public String retrive() throws RemoteException
	{
		// TODO Auto-generated method stub
		try
		{
			return firewall.getParser().getStrRealDocument();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete() throws RemoteException
	{
		return false;
	}

	@Override
	public boolean run(String option) throws RemoteException
	{
		try
		{
			See.firewallRun(null);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveAndRun(String strXml, String option)
			throws RemoteException
	{
		if(save(strXml) && run(null))
			return true;
		else
			return false;
	}

	@Override
	public boolean disable() throws RemoteException
	{
		try
		{
			See.firewallDisable();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String transformRetrive() throws RemoteException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean translateRetrive() throws RemoteException
	{
		// TODO Auto-generated method stub
		return false;
	}

}
