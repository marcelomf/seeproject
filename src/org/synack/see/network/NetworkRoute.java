/*
 * Created on 11/08/2009 02:03:47
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 */
package org.synack.see.network;

import java.util.Collection;
import java.util.Set;

import org.synack.util.Template;

/**
 * 
 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
 *
 */
public abstract class NetworkRoute 
{
	protected String xmlSource = "";
	protected String template = "";
	protected String applicationCmd = "";
	protected String router = "";
	protected String netInterface = "";
	protected String table = "";
	protected String specialRule = "";
	protected Boolean active = true;
	protected Set<String> destination;
	protected Collection<String> routesCommands;
	
	protected void explodeRoutes(String templateElementRoute, Object[] elementsRoute, String preContentElement, String posContentElement)
	{
		routesCommands = Template.explodeCommands(routesCommands, templateElementRoute, elementsRoute, preContentElement, posContentElement);
	}
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the commands
	 */
	public abstract Collection<String> getRoutesCommands();
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the xmlSource
	 */
	public String getXmlSource()
	{
		return xmlSource;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param xmlSource the xmlSource to set
	 */
	public void setXmlSource(String xmlSource)
	{
		this.xmlSource = xmlSource;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the template
	 */
	public String getTemplate()
	{
		return template;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param template the template to set
	 */
	public void setTemplate(String template)
	{
		this.template = template;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the applicationCmd
	 */
	public String getApplicationCmd()
	{
		return applicationCmd;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param applicationCmd the applicationCmd to set
	 */
	public void setApplicationCmd(String applicationCmd)
	{
		this.applicationCmd = applicationCmd;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the router
	 */
	public String getRouter()
	{
		return router;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param router the router to set
	 */
	public void setRouter(String router)
	{
		this.router = router;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the netInterface
	 */
	public String getNetInterface()
	{
		return netInterface;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param netInterface the netInterface to set
	 */
	public void setNetInterface(String netInterface)
	{
		this.netInterface = netInterface;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the table
	 */
	public String getTable()
	{
		return table;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param table the table to set
	 */
	public void setTable(String table)
	{
		this.table = table;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the destination
	 */
	public Set<String> getDestination()
	{
		return destination;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param destination the destination to set
	 */
	public void setDestination(Set<String> destination)
	{
		this.destination = destination;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param active the active to set
	 */
	public void setActive(Boolean active)
	{
		this.active = active;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the active
	 */
	public Boolean getActive()
	{
		return active;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param specialRule the specialRule to set
	 */
	public void setSpecialRule(String specialRule)
	{
		this.specialRule = specialRule;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the specialRule
	 */
	public String getSpecialRule()
	{
		return specialRule;
	}
}
