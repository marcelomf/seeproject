/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 16/08/2009 19:07:28
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */
package org.synack.see.firewall;

import java.util.ArrayList;
import java.util.HashSet;
import org.synack.see.firewall.IptablesRule;
import org.synack.see.xml.ParserObject;
import org.synack.see.xml.Parser;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class IptablesFirewall extends Firewall
{
	public IptablesFirewall() throws Exception
	{
		// Transform xml firewall
		super();
	}
	
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public IptablesFirewall(String pathFile) throws Exception
	{
		super(pathFile);
	}
	
	public ArrayList<String> getAllCommands() throws Exception
	{
		return null;
		
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IptablesRule> getAllRules() throws Exception
	{
		bootLoad();
		ArrayList<IptablesRule> allRules = new ArrayList<IptablesRule>();
		allRules.addAll((ArrayList<IptablesRule>) getManagementRules());
		allRules.addAll((ArrayList<IptablesRule>) getFilterRules());
		allRules.addAll((ArrayList<IptablesRule>) getNatRules());
		return allRules;
	}
	
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 */
	@SuppressWarnings("unchecked")
	public void loadXmlGlobalOptions() throws Exception
	{
		applicationCmd = getParser().getTransformDocument().getElementsByTagName("application").item(0).
							getAttributes().getNamedItem("cmd").getTextContent();
		moduleApplicationCmd = getParser().getTransformDocument().getElementsByTagName("moduleApplication").item(0).
								getAttributes().getNamedItem("cmd").getTextContent();
							
		Node nodeLoadModules = getParser().getTransformDocument().getElementsByTagName("loadModules").item(0);
		loadModules = new HashSet<String>();
		for(String modulo : nodeLoadModules.getAttributes().getNamedItem("modules").getTextContent().split(","))
			loadModules.add(modulo.trim());
		
		firewallKernelSets = (KernelSets) ParserObject.getObject(
								new KernelSets(), getParser().getTransformDocument().getElementsByTagName("kernelSets").item(0).
									getAttributes());
		
		
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @throws Exception
	 */
	public void bootLoad() throws Exception
	{
		loadXmlGlobalOptions();
		loadXmlManagementRules();
		loadXmlFilterRules();
		loadXmlNatRules();
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public void loadXmlFilterRules() throws Exception
	{
        NodeList nodeListXml = (NodeList) Parser.nodesByXPath(getParser().getTransformDocument(), "//rules[@type='filter']/rule");
        setFilterRules(ParserObject.getObjects(new IptablesRule(), new ArrayList<IptablesRule>(), nodeListXml));        
        
        for(IptablesRule r : getFilterRules())
        {
        	r.setRuleType(IptablesRule.RuleType.FILTER);
        	r.setApplicationCmd(getApplicationCmd());
        }	
	}

	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public void loadXmlManagementRules() throws Exception
	{
        NodeList nodeListXml = (NodeList) Parser.nodesByXPath(getParser().getTransformDocument(), "//rules[@type='management']/rule");
        setManagementRules(ParserObject.getObjects(new IptablesRule(), new ArrayList<IptablesRule>(), nodeListXml));
        
        for(IptablesRule r : getManagementRules())
        {
        	r.setRuleType(IptablesRule.RuleType.MANAGEMENT);
        	r.setApplicationCmd(getApplicationCmd());
        }
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public void loadXmlNatRules() throws Exception
	{
        NodeList nodeListXml = (NodeList) Parser.nodesByXPath(getParser().getTransformDocument(), "//rules[@type='nat']/rule");
        setNatRules(ParserObject.getObjects(new IptablesRule(), new ArrayList<IptablesRule>(), nodeListXml));
        
        for(IptablesRule r : getNatRules())
        {
        	r.setRuleType(IptablesRule.RuleType.NAT);
        	r.setApplicationCmd(getApplicationCmd());
        }
	}
	
	
	
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @see org.synack.see.firewall.FirewallRule#clearFirewall()
	 */
	@Override
	public ArrayList<String> getClearRules() throws Exception
	{
		bootLoad();
		ArrayList<String> clearRules = new ArrayList<String>();
		clearRules.add(getApplicationCmd()+" -F");
		clearRules.add(getApplicationCmd()+" -X");
		clearRules.add(getApplicationCmd()+" -F -t nat");
		clearRules.add(getApplicationCmd()+" -X -t nat");
		clearRules.add(getApplicationCmd()+" -F -t mangle");
		clearRules.add(getApplicationCmd()+" -X -t mangle");
		clearRules.add(getApplicationCmd()+" -P INPUT ACCEPT");
		clearRules.add(getApplicationCmd()+" -P OUTPUT ACCEPT");
		clearRules.add(getApplicationCmd()+" -P FORWARD ACCEPT");
		clearRules.add(getApplicationCmd()+" -t nat -P OUTPUT ACCEPT");
		clearRules.add(getApplicationCmd()+" -t nat -P POSTROUTING ACCEPT");
		clearRules.add(getApplicationCmd()+" -t nat -P PREROUTING ACCEPT");
		return clearRules;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<IptablesRule> getFilterRules()
	{
		return (ArrayList<IptablesRule>) filterRules;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<IptablesRule> getManagementRules()
	{
		return (ArrayList<IptablesRule>) managementRules;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<IptablesRule> getNatRules()
	{
		return (ArrayList<IptablesRule>) natRules;
	}
	
}