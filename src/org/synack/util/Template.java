package org.synack.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class Template
{

	public static Collection<String> explodeCommands(Collection<String> commands, String templateElementCommand, Object[] elementsCommand, String preContentElement, String posContentElement)
	{
		ArrayList<String> newCommands = new ArrayList<String>();
		ArrayList<String> oldCommands = new ArrayList<String>();
		
		for(String oldCommand : commands)
		{
			oldCommands.add(oldCommand);
			String newCommand = oldCommand;
			for(Object element : elementsCommand)
			{
				newCommands.add(newCommand.replace(templateElementCommand, preContentElement+element+posContentElement));	
			}
		}
		commands.removeAll(oldCommands);
		commands.clear();
		commands.addAll(newCommands);
		return commands;
	}
	
}
