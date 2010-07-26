/*
 * Created on 09/10/2009 16:29:17
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 */
package org.synack.see.network;

import java.util.ArrayList;
import org.synack.see.xml.ParserObject;
import org.w3c.dom.NodeList;

/* 
ip rule add from 111.111.111.111/29 table link1 prio 1
ip rule add from 0/0 fwmark 300 table Embratel prio 1
ip rule add from 0/0 fwmark 301 table Virtua   prio 1
ip rule add from 0/0 fwmark 302 table Speedy   prio 1

ip route add 222.222.222.222 dev ppp0 table link1 
ip route add 111.111.111.111/29 via 200.163.71.176 dev eth0 table link1
ip route add default via 111.111.111.1 dev eth0 table link1

ip route add 222.222.222.222 dev ppp0 table link2
ip route add 111.111.111.111/29 via 111.111.111.1 dev eth0 table link2
ip route add default dev ppp0 table link2
ip route add default via 222.222.222.2 dev ppp0 table link2
          
ip route add default scope global nexthop via 200.100.xxx.1 dev eth1 weight 1 nexthop via 200.100.yyy.2 dev eth2 weight 1 nexthop via 200.100.zzz.3 dev eth3 weight 1
ip route add default scope global nexthop via $P1 dev $IF1 weight 1 nexthop via $P2 dev $IF2 weight 1
*/

/**
 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
 *
 */
public class LinuxNetwork extends Network 
{

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	public LinuxNetwork() throws Exception
	{
		super();
	}
	
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	public LinuxNetwork(String pathFile) throws Exception
	{
		super(pathFile);
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void loadXmlGlobalOptions() throws Exception
	{
		applicationCmd = getParser().getTransformDocument().getElementsByTagName("application").item(0).
			getAttributes().getNamedItem("cmd").getTextContent();
		
	}
	
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void loadXmlRoutes() throws Exception
	{
        NodeList nodeListXml = getParser().getTransformDocument().getElementsByTagName("route");
        setRoutes(ParserObject.getObjects(new LinuxRoute(), new ArrayList<LinuxRoute>(), nodeListXml));        
        
        for(LinuxRoute r : getRoutes())
        	r.setApplicationCmd(getApplicationCmd());
        	
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void loadXmlHosts() throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void loadXmlPorts() throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void loadXmlTablesRoute() throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void loadXmlRules() throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void loadXmlLoadBalance() throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void loadXmlInterfaces() throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 *
	 */
	@Override
	public void bootLoad() throws Exception
	{
		loadXmlGlobalOptions();
		loadXmlHosts();
		loadXmlPorts();
		loadXmlInterfaces();
		loadXmlRoutes();
		loadXmlRules();
		loadXmlLoadBalance();
		loadXmlTablesRoute();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<LinuxRoute> getRoutes()
	{
		return (ArrayList<LinuxRoute>) routes;
	}
	

}
