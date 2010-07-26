package org.synack.see.ipc;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class IpcServer
{
	public static final int PORT = 1986;
	
	private Registry register;
	public IpcServer()// contrutor da classe Servidor
	{
		try
		{
			System.out.println("Starting IPC(RMI) server on port "+IpcServer.PORT);
			register = LocateRegistry.createRegistry(IpcServer.PORT);
			register.rebind("Firewall", new FirewallInvoke());
			register.rebind("Network", new NetworkInvoke());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
