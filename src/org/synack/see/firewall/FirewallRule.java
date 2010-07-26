/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 11/08/2009 02:03:47
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.see.firewall;

import java.util.Collection;
import java.util.Set;

import org.synack.util.Template;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public abstract class FirewallRule {
	
	protected String xmlSource="";
	protected String template="";
	protected String applicationCmd="";
	protected String defaultTarget="";
	protected String target="";
	protected String timeLimit="";
	protected String sizeLimit="";
	protected String icmpType="";
	protected String packetState="";
	protected String packetMark="";
	protected String packetPayload="";
	protected String tcpFlag="";
	protected String connectionLimit="";
	protected String logMessage="";
	protected String logLevel="";
	protected String partialRule="";
	protected String sourcePort="";
	protected String destinationPort="";
	protected String toPort="";
	protected String toIp="";
	protected String specialRule="";
	protected Boolean reverseFlow = false;
	protected Boolean active = true;
	protected Boolean newChain = false;
	protected Collection<String> rulesCommands;
	protected Set<String> inputInterface;
	protected Set<String> outputInterface;
	protected Set<String> sourceIp;
	protected Set<String> destinationIp;
	protected Set<String> sourceMac;
	protected Set<String> destinationMac;
	protected Set<String> chain;
	protected Set<String> protocol;
	
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @return
	 */
	public abstract Collection<String> getRulesCommands();
	
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param templateElementRule
	 * @param elementsRule
	 * @param preContentElement
	 * @param posContentElement
	 */
	protected void explodeRules(String templateElementRule, Object[] elementsRule, String preContentElement, String posContentElement)
	{
		rulesCommands = Template.explodeCommands(rulesCommands, templateElementRule, elementsRule, preContentElement, posContentElement);
/*		ArrayList<String> newCommands = new ArrayList<String>();
		ArrayList<String> oldCommands = new ArrayList<String>();
		
		for(String oldCommand : rulesCommands)
		{
			oldCommands.add(oldCommand);
			String newCommand = oldCommand;
			for(Object element : elementsRule)
			{
				newCommands.add(newCommand.replace(templateElementRule, preContentElement+element+posContentElement));	
			}
		}
		rulesCommands.removeAll(oldCommands);
		rulesCommands.clear();
		rulesCommands.addAll(newCommands);*/
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 */
	public String getDefaultTarget() {
		return defaultTarget;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param defaultTarget
	 */
	public void setDefaultTarget(String defaultTarget) {
		this.defaultTarget = defaultTarget;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 */
	public String getTimeLimit() {
		return timeLimit;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param timeLimit
	 */
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 */
	public String getSizeLimit() {
		return sizeLimit;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param sizeLimit
	 */
	public void setSizeLimit(String sizeLimit) {
		this.sizeLimit = sizeLimit;
	}

	public String getIcmpType() {
		return icmpType;
	}

	public void setIcmpType(String icmpType) {
		this.icmpType = icmpType;
	}

	public String getPacketState() {
		return packetState;
	}

	public void setPacketState(String packetState) {
		this.packetState = packetState;
	}

	public String getPacketMark() {
		return packetMark;
	}

	public void setPacketMark(String packetMark) {
		this.packetMark = packetMark;
	}

	public String getTcpFlag() {
		return tcpFlag;
	}

	public void setTcpFlag(String tcpFlag) {
		this.tcpFlag = tcpFlag;
	}

	public String getConnectionLimit() {
		return connectionLimit;
	}

	public void setConnectionLimit(String connectionLimit) {
		this.connectionLimit = connectionLimit;
	}

	public String getPacketPayload() {
		return packetPayload;
	}

	public void setPacketPayload(String packetPayload) {
		this.packetPayload = packetPayload;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getSpecialRule() {
		return specialRule;
	}

	public void setSpecialRule(String specialRule) {
		this.specialRule = specialRule;
	}

	public String getPartialRule() {
		return partialRule;
	}

	public void setPartialRule(String partialRule) {
		this.partialRule = partialRule;
	}

	public String getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(String sourcePort) {
		this.sourcePort = sourcePort;
	}

	public String getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}

	public String getToPort() {
		return toPort;
	}

	public void setToPort(String toPort) {
		this.toPort = toPort;
	}

	public String getToIp() {
		return toIp;
	}

	public void setToIp(String toIp) {
		this.toIp = toIp;
	}

	public String getTemplateRule() {
		return template;
	}

	public void setTemplateRule(String templateRule) {
		this.template = templateRule;
	}

	public String getApplicationCmd() {
		return applicationCmd;
	}

	public void setApplicationCmd(String applicationCmd) {
		this.applicationCmd = applicationCmd;
	}
	
	public Boolean getReverseFlow() {
		return reverseFlow;
	}

	public void setReverseFlow(Boolean reverseFlow) {
		this.reverseFlow = reverseFlow;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getNewChain() {
		return newChain;
	}

	public void setNewChain(Boolean newChain) {
		this.newChain = newChain;
	}
	
	public Set<String> getInputInterface() {
		return inputInterface;
	}

	public void setInputInterface(Set<String> inputInterface) {
		this.inputInterface = inputInterface;
	}

	public Set<String> getOutputInterface() {
		return outputInterface;
	}

	public void setOutputInterface(Set<String> outputInterface) {
		this.outputInterface = outputInterface;
	}

	public Set<String> getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(Set<String> sourceIp) {
		this.sourceIp = sourceIp;
	}

	public Set<String> getDestinationIp() {
		return destinationIp;
	}

	public void setDestinationIp(Set<String> destinationIp) {
		this.destinationIp = destinationIp;
	}

	public Set<String> getSourceMac() {
		return sourceMac;
	}

	public void setSourceMac(Set<String> sourceMac) {
		this.sourceMac = sourceMac;
	}

	public Set<String> getDestinationMac() {
		return destinationMac;
	}

	public void setDestinationMac(Set<String> destinationMac) {
		this.destinationMac = destinationMac;
	}

	public Set<String> getChain() {
		return chain;
	}

	public void setChain(Set<String> chain) {
		this.chain = chain;
	}

	public Set<String> getProtocol() {
		return protocol;
	}

	public void setProtocol(Set<String> protocol) {
		this.protocol = protocol;
	}

	public void setRulesCommands(Collection<String> rulesCommands) {
		this.rulesCommands = rulesCommands;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param xmlSource the xmlSource to set
	 */
	protected void setXmlSource(String xmlSource)
	{
		this.xmlSource = xmlSource;
	}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the xmlSource
	 */
	protected String getXmlSource()
	{
		return xmlSource;
	}

}
