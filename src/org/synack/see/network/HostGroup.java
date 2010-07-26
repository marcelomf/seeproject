package org.synack.see.network;

import java.util.ArrayList;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class HostGroup 
{
	private String name = "";
	private ArrayList<String> ip = new ArrayList<String>();
	
	
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
	 * @return the ip
	 */
	public ArrayList<String> getIp()
	{
		return ip;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param ip the ip to set
	 */
	public void setIp(ArrayList<String> ip)
	{
		this.ip = ip;
	}
	
	

}
