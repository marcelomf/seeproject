package org.synack.util;
/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 16/08/2009 19:07:28
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */
public class Network 
{
	
	public Network()
	{
	}
	
	public static boolean validNumber(String[] numberOctets) throws Exception 
	{
		if(numberOctets.length != 4)
			return false;
		
		for(String numberOct : numberOctets) 
			if(Integer.parseInt(numberOct) < 0 || Integer.parseInt(numberOct) > 255)
				return false;

		if(!padLeft(toBin(numberOctets[3]), 8, '0').substring((toBin(numberOctets[3]).length()-2), toBin(numberOctets[3]).length()).equals("00"))
			return false;
		
		return true;
	}
	
	public static String[] toArray(String number)
	{
		return number.split("\\.");
	}
	
	public static String toBin(String number)
	{
		return padLeft(Integer.toBinaryString(Integer.parseInt(number)), 8, '0');
	}
	
	public static String[] toBin(String[] numberOctets)
	{
		String number = new String();
		
		for(int i = 0; i < numberOctets.length; i++)
		{
			if(i != (numberOctets.length-1))
				number += toBin(numberOctets[i]) + ".";
			else
				number += toBin(numberOctets[i]);
		}
		
		return number.split("\\.");
	}
	
	public static String padLeft(String str, int fullLength, char ch)
	{
		return (fullLength > str.length()) ? 
				buildString(ch, fullLength-str.length()).concat(str) : 
						str;
	}
	
	public static String buildString(char ch, int length)
	{
		char newStr[] = new char[length];
		for(int i = 0 ; i < length ; ++i) 
			newStr[i] = ch;
		return new String(newStr);
	} 
}
