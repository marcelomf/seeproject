package org.synack.see.network;

import java.util.Collection;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
@SuppressWarnings("rawtypes")
public class LoadBalance 
{
	private String destination = "";
	private String scope = "";
	private Collection balances;
	
	
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * @return the balances
	 */
	public Collection getBalances() {
		return balances;
	}
	/**
	 * @param balances the balances to set
	 */
	public void setBalances(Collection balances) {
		this.balances = balances;
	}

}
