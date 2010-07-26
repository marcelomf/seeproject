package org.synack.see.network;

import java.util.ArrayList;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class PortGroup 
{
	private String name;
	private ArrayList<String> port;
	
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the port
	 */
	public ArrayList<String> getPort()
	{
		return port;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param port the port to set
	 */
	public void setPort(ArrayList<String> port)
	{
		this.port = port;
	}
	
	

}
