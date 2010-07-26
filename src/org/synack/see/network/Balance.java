package org.synack.see.network;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public abstract class Balance 
{
	private String router="";
	private String netInterface="";
	private Integer weight = 1;
	
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the router
	 */
	public String getRouter()
	{
		return router;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param router the router to set
	 */
	public void setRouter(String router)
	{
		this.router = router;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the netInterface
	 */
	public String getNetInterface()
	{
		return netInterface;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param netInterface the netInterface to set
	 */
	public void setNetInterface(String netInterface)
	{
		this.netInterface = netInterface;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the weight
	 */
	public Integer getWeight()
	{
		return weight;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param weight the weight to set
	 */
	public void setWeight(Integer weight)
	{
		this.weight = weight;
	}
	
	
}
