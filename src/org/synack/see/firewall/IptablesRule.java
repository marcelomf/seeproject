/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 13/08/2009 12:04:47
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.see.firewall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */

public class IptablesRule extends FirewallRule 
{
	public enum RuleType {FILTER, NAT, MANAGEMENT};
	
	private RuleType ruleType;

	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 */
	public IptablesRule()
	{
		this.template = "<PROGRAM><TABLE><CHAIN><PROTOCOL><INPUT_INTERFACE><OUTPUT_INTERFACE><SOURCE_IP>" +
		 "<DESTINATION_IP><SOURCE_PORT><DESTINATION_PORT><SIZE_LIMIT><ICMP_TYPE><PACKET_STATE><TCP_FLAG><CONNECTION_LIMIT>" +
		 "<TIME_LIMIT><PACKET_PAYLOAD><PARTIAL_RULE><TARGET><LOG_LEVEL><LOG_MESSAGE><TO_IP><TO_PORT><PACKET_MARK>";
		this.applicationCmd = "/sbin/iptables";
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 */
	public IptablesRule(String applicationCmd)
	{
		this.template = "<PROGRAM><TABLE><CHAIN><PROTOCOL><INPUT_INTERFACE><OUTPUT_INTERFACE><SOURCE_IP>" +
		 "<DESTINATION_IP><SOURCE_PORT><DESTINATION_PORT><SIZE_LIMIT><ICMP_TYPE><PACKET_STATE><TCP_FLAG><CONNECTION_LIMIT>" +
		 "<TIME_LIMIT><PACKET_PAYLOAD><PARTIAL_RULE><TARGET><LOG_LEVEL><LOG_MESSAGE><TO_IP><TO_PORT><PACKET_MARK>";
		this.applicationCmd = applicationCmd;
	}
	
	/**
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @see org.synack.see.firewall.FirewallRule#getRulesCommands()
	 */
	public Collection<String> getRulesCommands()
	{
		ArrayList<String> realRulesCommands = new ArrayList<String>();
		
		if(!getActive().booleanValue())
		{
			return realRulesCommands;
		}
		else if(!getSpecialRule().equals(""))
		{
			realRulesCommands.add(getSpecialRule());
			return realRulesCommands; 
		}
		
		rulesCommands = new ArrayList<String>();
		String ruleCommand = template;
		
		ruleCommand = ruleCommand.replace("<PROGRAM>", getApplicationCmd());
		
		switch(getRuleType())
		{
			case MANAGEMENT:
				ruleCommand = ruleCommand.replace("<TABLE>", " -t mangle");
				break;
			case FILTER:
				ruleCommand = ruleCommand.replace("<TABLE>", " -t filter");
				break;
			case NAT:
				ruleCommand = ruleCommand.replace("<TABLE>", " -t nat");
				break;
		}
		
		setChain((getChain() == null) ? new HashSet<String>() : getChain());
		
		for(String chain : getChain())
		{	
			String rule = ruleCommand;
				
			if(getDefaultTarget().equals(""))
			{
				if(!chain.equals("") && getNewChain() == false)
					rule = rule.replace("<CHAIN>", " -A "+chain.toUpperCase());
				else if(getNewChain() == true)
				{
					rule = rule.replace("<CHAIN>", " -N "+chain.toUpperCase());
					rulesCommands.add(rule);
					continue;
				}
				
				HashSet<String> protocolsForMultiport = new HashSet<String>();
				protocolsForMultiport.add("tcp");
				protocolsForMultiport.add("udp");
				
				if(!getSourcePort().equals(""))
				{
					if(getSourcePort().contains(","))
					{
						rule = rule.replace("<SOURCE_PORT>", " -m multiport --sport "+getSourcePort().replace(" ", "").trim());
						if(getProtocol() == null)
							setProtocol(protocolsForMultiport);
					}
					else
						rule = rule.replace("<SOURCE_PORT>", " --sport "+getSourcePort().replace(" ", "").trim());
				}
				
				if(!getDestinationPort().equals(""))
				{
					if(getDestinationPort().contains(","))
					{
						rule = rule.replace("<DESTINATION_PORT>", " -m multiport --dport "+getDestinationPort().replace(" ", "").trim());
						if(getProtocol() == null)
							setProtocol(protocolsForMultiport);
					}
					else
						rule = rule.replace("<DESTINATION_PORT>", " --dport "+getDestinationPort().replace(" ", "").trim());
				}
				
				if(!getIcmpType().equals(""))
					rule = rule.replace("<ICMP_TYPE>", " --icmp-type "+getIcmpType().toLowerCase());
				if(!getTimeLimit().equals(""))
					rule = rule.replace("<TIME_LIMIT>", " -m limit --limit "+getTimeLimit().toLowerCase());
				if(!getPacketState().equals(""))
					rule = rule.replace("<PACKET_STATE>", " -m state --state "+getPacketState().toLowerCase());
				if(!getTcpFlag().equals(""))
				{
					if(getTcpFlag().contains(","))
						rule = rule.replace("<TCP_FLAG>", " --tcp-flags "+getTcpFlag().toUpperCase());
					else
						rule = rule.replace("<TCP_FLAG>", " --"+getTcpFlag().toLowerCase());
				}
				if(!getPartialRule().equals(""))
					rule = rule.replace("<PARTIAL_RULE>", " "+getPartialRule());
				if(!getTarget().equals(""))
					rule = rule.replace("<TARGET>", " -j "+getTarget().toUpperCase().trim());
				if(!getLogLevel().equals(""))
					rule = rule.replace("<LOG_LEVEL>", " --log-level "+getLogLevel().toLowerCase());
				if(!getLogMessage().equals(""))
					rule = rule.replace("<LOG_MESSAGE>", " --log-prefix \""+getLogMessage()+"\"");
				if(!getPacketMark().equals(""))
					rule = rule.replace("<PACKET_MARK>", " --set-mark "+getPacketMark().toLowerCase());
				if(!getToIp().equals(""))
					rule = rule.replace("<TO_IP>", " --to "+getToIp().toLowerCase().trim());
				if(!getToPort().equals(""))
					rule = rule.replace("<TO_PORT>", " --to-port "+getToPort().toLowerCase().trim());
			}
			else
			{
				if(!chain.equals(""))
					rule = rule.replace("<CHAIN>", " -P "+chain.toUpperCase());
				if(!getDefaultTarget().equals(""))
					rule = rule.replace("<TARGET>", " "+getDefaultTarget().toUpperCase().trim());
			}
			rulesCommands.add(rule);
		}

		if(getInputInterface() != null)
			explodeRules("<INPUT_INTERFACE>", getInputInterface().toArray(), " -i ", "");
		if(getOutputInterface() != null)
			explodeRules("<OUTPUT_INTERFACE>", getOutputInterface().toArray(), " -o ", "");
		if(getProtocol() != null)
			explodeRules("<PROTOCOL>", getProtocol().toArray(), " -p ", "");
		if(getSourceIp() != null)
			explodeRules("<SOURCE_IP>", getSourceIp().toArray(), " -s ", "");
		if(getDestinationIp() != null)
			explodeRules("<DESTINATION_IP>", getDestinationIp().toArray(), " -d ", "");
		
		for(String rule : rulesCommands)
		{
			String cleanRule = rule.replaceAll("<[^>]*>", "");
			realRulesCommands.add(cleanRule.trim());
			String newRule = "";
			if(getReverseFlow().booleanValue())
			{
				if(getRuleType() == RuleType.FILTER)
				{
					newRule = cleanRule.replaceAll(" INPUT ", " OUTPUTTT ").replaceAll(" OUTPUT ", " INPUT ").replaceAll(" OUTPUTTT ", " OUTPUT ").
					replaceAll(" -i ", " -ooo ").replaceAll(" -o ", " -i ").replaceAll(" -ooo ", " -o ").
					replaceAll(" -d ", " -sss ").replaceAll(" -s ", " -d ").replaceAll(" -sss ", " -s ").
					replaceAll(" --sport ", " --dporttt ").replaceAll(" --dport ", " --sport ").replaceAll(" --dporttt ", " --dport ");
				} 
				else if(getRuleType() == RuleType.NAT)
				{
					newRule = cleanRule.replaceAll(" PREROUTING ", " POSTROUTINGGG ").replaceAll(" POSTROUTING ", " PREROUTING ").replaceAll(" POSTROUTINGGG ", " POSTROUTING ").
					replaceAll(" DNAT ", " SNATTT ").replaceAll(" SNAT ", " DNAT ").replaceAll(" SNATTT ", " SNAT ").
					replaceAll(" -i ", " -ooo ").replaceAll(" -o ", " -i ").replaceAll(" -ooo ", " -o ").
					replaceAll(" -d ", " --tooo ").replaceAll(" --to ", " -s ").replaceAll(" --tooo ", " --to ").
					replaceAll(" --dport ", " --to-porttt ").replaceAll(" --to-port ", " --sport ").replaceAll(" --to-porttt ", " --to-port ");
					if(newRule.contains("-j SNAT") && newRule.contains("POSTROUTING"))
					{
						String inicio = newRule.split("POSTROUTING")[0]+"POSTROUTING";
						String fim = newRule.split("POSTROUTING")[1];
						newRule = inicio+fim.split("-j SNAT")[1]+" -j SNAT"+fim.split("-j SNAT")[0];
					}
					else if(newRule.contains("-j DNAT") && newRule.contains("PREROUTING"))
					{
						String inicio = newRule.split("PREROUTING")[0]+"PREROUTING";
						String fim = newRule.split("POSTROUTING")[1];
						newRule = inicio+fim.split("-j DNAT")[1]+" -j DNAT"+fim.split("-j DNAT")[0];					
					}
									
				}
				realRulesCommands.add(newRule.trim());
			}
		}
		return realRulesCommands;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param ruleType
	 */
	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 */
	public RuleType getRuleType() {
		return ruleType;
	}
}
