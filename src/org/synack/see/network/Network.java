/*
 * Created on 09/10/2009 16:12:29
 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
 */
package org.synack.see.network;

import java.util.Collection;

import org.synack.see.ServiceType;
import org.synack.see.xml.Parser;

/**
 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
 *
 */
@SuppressWarnings("rawtypes")
public abstract class Network 
{
	
	private Parser parser;
	protected String applicationCmd;
	protected LoadBalance loadBalance;
	protected Collection hosts;
	protected Collection ports;
	protected Collection tableRoutes;
	protected Collection interfaces;
	protected Collection routes;
	protected Collection rules;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public Network() throws Exception
	{
		setParser(new Parser(ServiceType.NETWORK));
		getParser().transformSee();
	}

	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public Network(String pathFile) throws Exception
	{
		setParser(new Parser(ServiceType.NETWORK, pathFile));
		getParser().transformSee();
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @throws Exception
	 */
	public abstract void loadXmlGlobalOptions() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public abstract void loadXmlHosts() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public abstract void loadXmlPorts() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public abstract void loadXmlTablesRoute() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public abstract void loadXmlRules() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public abstract void loadXmlLoadBalance() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public abstract void loadXmlInterfaces() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public abstract void loadXmlRoutes() throws Exception;

	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public abstract void bootLoad() throws Exception;
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the loadBalance
	 */
	public LoadBalance getLoadBalance()
	{
		return loadBalance;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param loadBalance the loadBalance to set
	 */
	public void setLoadBalance(LoadBalance loadBalance)
	{
		this.loadBalance = loadBalance;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the hosts
	 */
	public Collection getHosts()
	{
		return hosts;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param hosts the hosts to set
	 */
	public void setHosts(Collection hosts)
	{
		this.hosts = hosts;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the ports
	 */
	public Collection getPorts()
	{
		return ports;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param ports the ports to set
	 */
	public void setPorts(Collection ports)
	{
		this.ports = ports;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the tableRoutes
	 */
	public Collection getTableRoutes()
	{
		return tableRoutes;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param tableRoutes the tableRoutes to set
	 */
	public void setTableRoutes(Collection tableRoutes)
	{
		this.tableRoutes = tableRoutes;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the interfaces
	 */
	public Collection getInterfaces()
	{
		return interfaces;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param interfaces the interfaces to set
	 */
	public void setInterfaces(Collection interfaces)
	{
		this.interfaces = interfaces;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the routes
	 */
	public Collection getRoutes()
	{
		return routes;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param routes the routes to set
	 */
	public void setRoutes(Collection routes)
	{
		this.routes = routes;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the rules
	 */
	public Collection getRules()
	{
		return rules;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param rules the rules to set
	 */
	public void setRules(Collection rules)
	{
		this.rules = rules;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the parser
	 */
	public Parser getParser()
	{
		return parser;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param parser the parser to set
	 */
	public void setParser(Parser parser)
	{
		this.parser = parser;
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
	
	
}
