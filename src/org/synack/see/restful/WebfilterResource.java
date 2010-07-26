/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * 16/04/2010 19:42:00
 * Code under GPL License Version 2, please respect it. 
 * More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.see.restful;

import java.io.IOException;
import java.net.MalformedURLException;
import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class WebfilterResource extends ServerResource
{
	public WebfilterResource() throws MalformedURLException, IOException
	{
        //ClientResource client = new ClientResource("http://localhost:8601/seed/firewall");


	}
	
	@Get   
	public String toString() 
	{  
		Request request = new Request(Method.GET, "http://www.synack.com.br");
		Client client = new Client(Protocol.HTTP);
		client.setContext(getContext());
		Response response = client.handle(request);
		try
		{
			response.getEntity().write(System.out);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "aaa";
	}
	
}
