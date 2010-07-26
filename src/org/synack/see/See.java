/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * 16/04/2010 19:43:38
 * Code under GPL License Version 2, please respect it. 
 * More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.see;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.synack.see.firewall.IptablesFirewall;
import org.synack.see.firewall.IptablesRule;
import org.synack.see.network.LinuxNetwork;
import org.synack.see.network.LinuxRoute;

public class See
{
	public static boolean DEBUG_MODE = false; 
	
	public static void main(String[] args)
	{
		See see = new See();
		see.control(args);
	}
	

	public void control(String[] args)
	{
		try
		{
			char option = '0';
			String pathFile = null;
			
			if(args.length > 0 && args[0] instanceof String && args[0].length() > 1)
				option = args[0].charAt(1);
			
			if(args.length > 1 && args[1] instanceof String)
				pathFile = args[1];
			
			if(args.length > 2 && args[2] instanceof String && args[2].length() > 1)
				See.DEBUG_MODE = args[2].equals("-d") ? true : false;
			
			switch(option)
			{
				case 'f':
					System.out.println(firewallTranslate(pathFile));
					break;
				case 'n':
					System.out.println(networkTranslate(pathFile));
					break;
				case 'w':
					System.out.println(webfilterTranslate(pathFile));
					break;
				case 'r':
					firewallRun(pathFile);
					break;
				case 'c':
					firewallDisable();
					break;
				default:
					System.out.println("\nInvalid Syntax!\n");
					usageShow();
			}		
		}
		catch(Exception e)
		{
			System.out.println("\nERROR! Please, contact-me: marcelomf[noSpam]gmail[dot]com!\n");
			e.printStackTrace();
			usageShow();
		}
	}
	
	public void usageShow()
	{
		System.out.println("\nUsage:\n" +
				"\tFirewall Translate: see -f [file...] [options]\n" +
				"\tNetwork Translate: see -n [file...] [options]\n" +
				"\tWebfilter Translate: see -w [file...] [options]\n" +
				"\tFirewall Run: see -r [file...]\n" +
				"\tFirewall Clear: see -c\n" +
				"\nOptions:\n" +
				"\tDebug mode: -d\n");
	}
	
	public static String firewallTranslate(String pathFile) throws Exception
	{
		String firewallTranslated = "";
		IptablesFirewall fw = (pathFile != null) ? new IptablesFirewall(pathFile) : new IptablesFirewall();
		ArrayList<IptablesRule> rules = fw.getAllRules();
		
		for(IptablesRule rule : rules)
		{
			if(!rule.getRulesCommands().isEmpty())
			{
				for(String ruleCommand : rule.getRulesCommands())
					firewallTranslated+=ruleCommand+"\n";
			}
		}	
		return firewallTranslated;
	}
	
	public static String networkTranslate(String pathFile) throws Exception
	{
		String networkTranslated = "";
		LinuxNetwork net = (pathFile != null) ? new LinuxNetwork(pathFile) : new LinuxNetwork();
		net.bootLoad();
		ArrayList<LinuxRoute> routes = net.getRoutes();
		
		for(LinuxRoute route : routes)
		{
			if(!route.getRoutesCommands().isEmpty())
			{
				for(String routeCommand : route.getRoutesCommands())
					networkTranslated+=routeCommand+"\n";	
			}
		}		
		return networkTranslated;
	}
	
	public static String webfilterTranslate(String pathFile) throws Exception
	{
		return "";
	}
	
	public static void firewallRun(String pathFile) throws Exception
	{
		See.firewallDisable();
		Process process;
		String line;
		BufferedReader input;
		
		IptablesFirewall fw = (pathFile != null) ? new IptablesFirewall(pathFile) : new IptablesFirewall();
		ArrayList<IptablesRule> rules = fw.getAllRules();
		
		for(IptablesRule rule : rules)
		{
			if(!rule.getRulesCommands().isEmpty())
			{
				for(String ruleCommand : rule.getRulesCommands())
				{
					process = Runtime.getRuntime().exec(ruleCommand);
					input = new BufferedReader(new InputStreamReader(process.getInputStream()));
					while ((line = input.readLine()) != null) 
					{
						System.out.println(line);
					}
				}	
			}
		}	
	}
	
	public static void firewallDisable() throws Exception
	{
		Process process;
		String line;
		BufferedReader input;
		
		IptablesFirewall fw =  new IptablesFirewall();
		ArrayList<String> rules = fw.getClearRules();
		
		for(String ruleCommand : rules)
		{
			process = Runtime.getRuntime().exec(ruleCommand);
			input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((line = input.readLine()) != null) 
			{
				System.out.println(line);
			}
		}	
	}
}
