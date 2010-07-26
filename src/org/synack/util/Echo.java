package org.synack.util;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class Echo 
{
	FileOutputStream file;

	/**
	 * 
	 */
	public Echo()
	{
		
	}
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param filePath
	 * @param content
	 */
	public Echo(String filePath, String content)
	{
		
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param filePath
	 */
	private void openFile(String filePath, boolean isNewContent)
	{
		try
		{
			file = new FileOutputStream(filePath, isNewContent);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 */
	private void closeFile()
	{
		try 
		{
			if(file != null)
				file.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param filePath
	 * @param content
	 */
	public void content(String filePath, String content)
	{
		this.openFile(filePath, false);
		try 
		{
			file.flush();
			file.write(content.getBytes());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeFile();
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param filePath
	 * @param content
	 */
	public void add(String filePath, String content)
	{
		this.openFile(filePath, true);
		try 
		{
			file.flush();
			file.write(content.getBytes());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closeFile();
	}
	
}
