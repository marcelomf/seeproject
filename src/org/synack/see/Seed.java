/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 16/08/2009 19:07:28
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.see;

import org.synack.see.ipc.IpcServer;
import org.synack.see.restful.RestServer;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class Seed
{
	// su user_name -c "comando"
	
	public static void main(String[] args)
	{
		Seed seed = new Seed();
		seed.control(args);
	}
	

	public void control(String[] args)
	{
		try
		{
			char option = '0';
			
			if(args.length > 0 && args[0] instanceof String && args[0].length() > 1)
				option = args[0].charAt(1);
			
			if(args.length > 2 && args[2] instanceof String && args[2].length() > 1)
				See.DEBUG_MODE = args[2].equals("-d") ? true : false;
			
			switch(option)
			{
				case 'b':
					new IpcServer();
					new RestServer();
					break;
				case 'h':
					new RestServer();
					break;
				case 'i':
					new IpcServer();
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
				"\tBoth Httpd(Restful) and Ipc(RMI) start: see -b [options]\n" +
				"\tHttpd(Restful) start: see -h [options]\n" +
				"\tIpc(RMI) start: see -i [options]\n" +
				"\nOptions:\n" +
				"\tDebug mode: -d\n");
	}
}
