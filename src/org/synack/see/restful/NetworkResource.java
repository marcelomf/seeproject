/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * 16/04/2010 19:41:48
 * Code under GPL License Version 2, please respect it. 
 * More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.see.restful;


import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.synack.see.ipc.IpcClient;
import org.synack.see.ipc.IpcServer;

public class NetworkResource extends ServerResource
{
	
	public NetworkResource()
	{
	}
	
	@Get   
	public String toString() 
	{  
		try
		{
			return IpcClient.getService("localhost", IpcServer.PORT, "Network").retrive();
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	} 
}
