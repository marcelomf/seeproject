/*
 * Created on 13/08/2009 12:06:47
 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
 */
package org.synack.see.network;

import java.util.ArrayList;
import java.util.Collection;


/**
 * 
 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
 *
 */
public class LinuxRoute extends NetworkRoute 
{

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 */
	public LinuxRoute()
	{
		this.template = "<PROGRAM><OPTION><DESTINATION><ROUTER><NET_INTERFACE><TABLE>";
		this.applicationCmd = "/sbin/ip route";
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 */
	public LinuxRoute(String applicationCmd)
	{
		this.template = "<PROGRAM><OPTION><DESTINATION><ROUTER><NET_INTERFACE><TABLE>";
		this.applicationCmd = applicationCmd;
	}
	
	
	@Override
	public Collection<String> getRoutesCommands()
	{
		ArrayList<String> realRoutesCommands = new ArrayList<String>();
		
		if(!getActive().booleanValue())
		{
			return realRoutesCommands;
		}
		else if(!getSpecialRule().equals(""))
		{
			realRoutesCommands.add(getSpecialRule());
			return realRoutesCommands; 
		}
		
		routesCommands = new ArrayList<String>();
		String routeCommand = template;
		
		routeCommand = routeCommand.replace("<PROGRAM>", getApplicationCmd());
		routeCommand = routeCommand.replace("<OPTION>", " add");
		if(!getRouter().equals(""))
			routeCommand = routeCommand.replace("<ROUTER>", " via "+getRouter());
		if(!getNetInterface().equals(""))
			routeCommand = routeCommand.replace("<NET_INTERFACE>", " dev "+getNetInterface());
		if(!getTable().equals(""))
			routeCommand = routeCommand.replace("<TABLE>", " table "+getTable());
		
		routesCommands.add(routeCommand);
		
		if(getDestination() != null)
			explodeRoutes("<DESTINATION>", getDestination().toArray(), " ", "");
			
		for(String realRouteCommand : routesCommands)
		{
			realRouteCommand = realRouteCommand.replaceAll("<[^>]*>", "");
			realRoutesCommands.add(realRouteCommand.trim());
		}
		
		return realRoutesCommands;
	}

}
