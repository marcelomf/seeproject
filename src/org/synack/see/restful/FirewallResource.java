/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * 16/04/2010 19:41:25
 * Code under GPL License Version 2, please respect it. 
 * More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.see.restful;

import java.io.IOException;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;  
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.synack.see.ipc.IpcClient;
import org.synack.see.ipc.IpcServer;

public class FirewallResource extends ServerResource
{	
	private String option = "";
	private String strXml = "";
	private String host = "localhost";
	private int port = IpcServer.PORT;
	
	public FirewallResource()
	{
	}
	
	@Get   
	public String represent() 
	{  
		try
		{
			host = (getRequestAttributes().get("host") == null) ? host : 
				((String) getRequestAttributes().get("host")).trim();
			
			port = (getRequestAttributes().get("port") == null) ? port : 
				Integer.parseInt(((String) getRequestAttributes().get("port")).trim());
			
			option = (getRequestAttributes().get("option") == null) ? "" : 
				((String) getRequestAttributes().get("option")).trim();
			
			if(option.equals("retrive"))
				return IpcClient.getService(host, port, "Firewall").retrive();
			else if(option.equals("run"))
			{
				if(IpcClient.getService(host, port, "Firewall").run(null))
					return "<message>Firewall running</message>";
				else
					return "<error>Error: running firewall</error>";
			}
			else if(option.equals("disable"))
			{
				if(IpcClient.getService(host, port, "Firewall").disable())
					return "<message>Firewall disabled</message>";
				else
					return "<error>Error: disable firewall</error>";
			}
			else
				return "<error>Invalid Option</error>";
			//return IpcClient.getService("Firewall").retrive();
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "<error>Firewall Error Exception GET</error>";
		}
	}
	
	@Post
	public Representation accept(Representation entity) throws IOException
	{
		
		try
		{
			host = (getRequestAttributes().get("host") == null) ? host : 
				((String) getRequestAttributes().get("host")).trim();
			
			port = (getRequestAttributes().get("port") == null) ? port : 
				Integer.parseInt(((String) getRequestAttributes().get("port")).trim());
			
			option = (getRequestAttributes().get("option") == null) ? "" : 
				((String) getRequestAttributes().get("option")).trim();
			
			strXml = (entity == null) ? null : ((String) entity.getText()).trim();
			
			if(option.equals("saveAndRun"))
			{
				if(IpcClient.getService(host, port, "Firewall").saveAndRun(strXml, null))
					return new StringRepresentation("<message>Firewall saved and running</message>",  MediaType.TEXT_XML);
				else
					return new StringRepresentation("<error>Error: Firewall saved and running</error>",  MediaType.TEXT_XML);
			}
			else if(option.equals("save"))
			{
				if(IpcClient.getService(host, port, "Firewall").save(strXml))
					return new StringRepresentation("<message>Firewall saved</message>",  MediaType.TEXT_XML);
				else
					return new StringRepresentation("<error>Error: firewall saving</error>",  MediaType.TEXT_XML);
			}
			else
				return new StringRepresentation("<error>Invalid Option POST</error>", MediaType.TEXT_XML);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new StringRepresentation("<error>Firewall Error Exception</error>",  MediaType.TEXT_XML);
		}

	}
}
