/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 16/08/2009 19:07:28
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */
package org.synack.see.firewall;

import java.util.Collection;
import org.synack.see.ServiceType;
import org.synack.see.xml.Parser;


/**
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
@SuppressWarnings("rawtypes")
public abstract class Firewall {
	
	private Parser parser;
	protected String applicationCmd;
	protected String moduleApplicationCmd;
	protected KernelSets firewallKernelSets;
	protected Collection loadModules;
	protected Collection filterRules;
	protected Collection managementRules;
	protected Collection natRules;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public Firewall() throws Exception
	{
		setParser(new Parser(ServiceType.FIREWALL));
		getParser().transformSee();
	}

	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @throws Exception
	 */
	public Firewall(String pathFile) throws Exception
	{
		setParser(new Parser(ServiceType.FIREWALL, pathFile));
		getParser().transformSee();
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public abstract Collection getClearRules() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public abstract Collection getAllRules() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public abstract void bootLoad() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @throws Exception
	 */
	public abstract void loadXmlGlobalOptions() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public abstract void loadXmlFilterRules() throws Exception;

	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public abstract void loadXmlManagementRules() throws Exception;
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public abstract void loadXmlNatRules() throws Exception;
	
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @return the filterRules
	 */
	public Collection getFilterRules() {
		return filterRules;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param filterRules the filterRules to set
	 */
	public void setFilterRules(Collection filterRules) {
		this.filterRules = filterRules;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @return the managementRules
	 */
	public Collection getManagementRules() {
		return managementRules;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param managementRules the managementRules to set
	 */
	public void setManagementRules(Collection managementRules) {
		this.managementRules = managementRules;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @return the natRules
	 */
	public Collection getNatRules() {
		return natRules;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param natRules the natRules to set
	 */
	public void setNatRules(Collection natRules) {
		this.natRules = natRules;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @return the loadModules
	 */
	public Collection getLoadModules() {
		return loadModules;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param loadModules the loadModules to set
	 */
	public void setLoadModules(Collection loadModules) {
		this.loadModules = loadModules;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @return the applicationCmd
	 */
	public String getApplicationCmd() {
		return applicationCmd;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param applicationCmd the applicationCmd to set
	 */
	public void setApplicationCmd(String applicationCmd) {
		this.applicationCmd = applicationCmd;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @return the moduleApplicationCmd
	 */
	public String getModuleApplicationCmd() {
		return moduleApplicationCmd;
	}
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param moduleApplicationCmd the moduleApplicationCmd to set
	 */
	public void setModuleApplicationCmd(String moduleApplicationCmd) {
		this.moduleApplicationCmd = moduleApplicationCmd;
	}

	public KernelSets getKernelSets() {
		return firewallKernelSets;
	}

	public void setKernelSets(KernelSets firewallKernelSets) {
		this.firewallKernelSets = firewallKernelSets;
	}

	
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public void setParser(Parser parser)
	{
		this.parser = parser;
	}

	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 */
	public Parser getParser()
	{
		return parser;
	}
}
