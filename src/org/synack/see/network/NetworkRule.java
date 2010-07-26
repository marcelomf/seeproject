package org.synack.see.network;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public abstract class NetworkRule 
{
	private String name = "";
	private String from = "";
	private String mark = "";
	private String table = "";
	private Integer prio = 1;
	
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the from
	 */
	public String getFrom()
	{
		return from;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param from the from to set
	 */
	public void setFrom(String from)
	{
		this.from = from;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the mark
	 */
	public String getMark()
	{
		return mark;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param mark the mark to set
	 */
	public void setMark(String mark)
	{
		this.mark = mark;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the table
	 */
	public String getTable()
	{
		return table;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param table the table to set
	 */
	public void setTable(String table)
	{
		this.table = table;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the prio
	 */
	public Integer getPrio()
	{
		return prio;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param prio the prio to set
	 */
	public void setPrio(Integer prio)
	{
		this.prio = prio;
	}
	
	

}
