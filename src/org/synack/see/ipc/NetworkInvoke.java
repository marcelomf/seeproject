package org.synack.see.ipc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.synack.see.network.LinuxNetwork;
import org.synack.see.network.Network;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class NetworkInvoke extends UnicastRemoteObject implements InvokeControl
{
	
	private static final long serialVersionUID = 1L;
	private Network network;
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @throws RemoteException
	 * @throws Exception
	 */
	public NetworkInvoke() throws RemoteException, Exception
	{
		super();
		network = new LinuxNetwork();		
	}

	
	@Override
	public boolean save(String strXml) throws RemoteException
	{
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public String retrive() throws RemoteException
	{
		// TODO Auto-generated method stub
		try
		{
			return network.getParser().getStrRealDocument();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean run(String option) throws RemoteException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAndRun(String strXml, String option)
			throws RemoteException
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean disable() throws RemoteException
	{
		// TODO Auto-generated method stub
		return false;
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
