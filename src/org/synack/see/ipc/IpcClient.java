package org.synack.see.ipc;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class IpcClient
{
	private static Registry register;
	
	private static Registry getRegister(String host, int port)
	{
		try
		{
			if(IpcClient.register == null)
			{
				IpcClient.register = LocateRegistry.getRegistry(host, port);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return IpcClient.register;
	}
	
	public static InvokeControl getService(String host, int port, String nameLookup)
	{
		System.out.println("Invoke: "+host+":"+port+" -> "+nameLookup);
		try
		{
			return (InvokeControl) IpcClient.getRegister(host, port).lookup(nameLookup);
		}
		catch(Exception e)
		{
			System.out.println("ERROR: Invoke: "+host+":"+port+" -> "+nameLookup);
			e.printStackTrace();
			return null;
		}
	}
}
