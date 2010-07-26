/*
 * Created on 13/08/2009 12:03:47
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 */
package org.synack.see.network;

/**
 * Created on 13/08/2009
 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
 */
public abstract class Interface 
{
	protected String name = "";
	protected String physical = "";
	protected String ip = "";
	protected String netmask = "";
	protected String natOneToOne = "";
	protected String masqueradeTo = "";
	
	/*	public static Set<Interface> getAllInterfaces() throws Exception
	{
        Document doc = Parser.getDocumentService(Type.NETWORK);
        NodeList nodeListXml = (NodeList) Parser.nodesByXPath(doc, "//network/interface");
        return (HashSet<Interface>) ParserObject.getObjects(new Interface(), new HashSet<Interface>(),nodeListXml);
	}*/
	
	
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
	 * @return the physical
	 */
	public String getPhysical()
	{
		return physical;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param physical the physical to set
	 */
	public void setPhysical(String physical)
	{
		this.physical = physical;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the ip
	 */
	public String getIp()
	{
		return ip;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param ip the ip to set
	 */
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the netmask
	 */
	public String getNetmask()
	{
		return netmask;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param netmask the netmask to set
	 */
	public void setNetmask(String netmask)
	{
		this.netmask = netmask;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the natOneToOne
	 */
	public String getNatOneToOne()
	{
		return natOneToOne;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param natOneToOne the natOneToOne to set
	 */
	public void setNatOneToOne(String natOneToOne)
	{
		this.natOneToOne = natOneToOne;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the masqueradeTo
	 */
	public String getMasqueradeTo()
	{
		return masqueradeTo;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param masqueradeTo the masqueradeTo to set
	 */
	public void setMasqueradeTo(String masqueradeTo)
	{
		this.masqueradeTo = masqueradeTo;
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @return Set<Interface>
	 */
	
}
