package org.synack.see.restful;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class RestServer extends Application
{
	public static final int PORT = 2001;
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 */
	public RestServer()
	{
    	try 
    	{
			Component component = new Component();  
			component.getServers().add(Protocol.HTTP, RestServer.PORT); 
			component.getDefaultHost().attach("/seed",  this);     
			component.start();
    	} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
	}
	
    
    /**
     * 
     * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
     * @see org.restlet.Application#createInboundRoot()
     */
	@Override  
	public synchronized Restlet createInboundRoot() 
	{  
		Router router = new Router(getContext());
		router.attach("/server/{host}/port/{port}/firewall/{option}", FirewallResource.class);
		router.attach("/server/{host}/port/{port}/firewall/{option}/strXml/{strXml}", FirewallResource.class);
		router.attach("/server/{host}/port/{port}/network/{option}", NetworkResource.class);
		//router.attach("/webfilter", WebfilterResource.class);
		return router;  
	}
}
