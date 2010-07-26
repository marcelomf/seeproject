package org.synack.see.firewall;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class KernelSets 
{
	private Boolean kernelRouting = false;
	private Boolean logSpoofing = false;
	private Boolean synCookies = false;
	private Boolean icmpEchoIgnoreAll = false;
	private Boolean icmpEchoIgnoreBroadcast = false;
	private Boolean acceptRedirect = false;
	private Boolean icmpIgnoreBogusErrorResponse = false;
	private Boolean logMartian = false;
	
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the kernelRouting
	 */
	public Boolean getKernelRouting() {
		return kernelRouting;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param kernelRouting the kernelRouting to set
	 */
	public void setKernelRouting(Boolean kernelRouting) {
		this.kernelRouting = kernelRouting;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the logSpoofing
	 */
	public Boolean getLogSpoofing() {
		return logSpoofing;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param logSpoofing the logSpoofing to set
	 */
	public void setLogSpoofing(Boolean logSpoofing) {
		this.logSpoofing = logSpoofing;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the synCookies
	 */
	public Boolean getSynCookies() {
		return synCookies;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param synCookies the synCookies to set
	 */
	public void setSynCookies(Boolean synCookies) {
		this.synCookies = synCookies;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the icmpEchoIgnoreAll
	 */
	public Boolean getIcmpEchoIgnoreAll() {
		return icmpEchoIgnoreAll;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param icmpEchoIgnoreAll the icmpEchoIgnoreAll to set
	 */
	public void setIcmpEchoIgnoreAll(Boolean icmpEchoIgnoreAll) {
		this.icmpEchoIgnoreAll = icmpEchoIgnoreAll;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the icmpEchoIgnoreBroadcast
	 */
	public Boolean getIcmpEchoIgnoreBroadcast() {
		return icmpEchoIgnoreBroadcast;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param icmpEchoIgnoreBroadcast the icmpEchoIgnoreBroadcast to set
	 */
	public void setIcmpEchoIgnoreBroadcast(Boolean icmpEchoIgnoreBroadcast) {
		this.icmpEchoIgnoreBroadcast = icmpEchoIgnoreBroadcast;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the acceptRedirect
	 */
	public Boolean getAcceptRedirect() {
		return acceptRedirect;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param acceptRedirect the acceptRedirect to set
	 */
	public void setAcceptRedirect(Boolean acceptRedirect) {
		this.acceptRedirect = acceptRedirect;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the icmpIgnoreBogusErrorResponse
	 */
	public Boolean getIcmpIgnoreBogusErrorResponse() {
		return icmpIgnoreBogusErrorResponse;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param icmpIgnoreBogusErrorResponse the icmpIgnoreBogusErrorResponse to set
	 */
	public void setIcmpIgnoreBogusErrorResponse(Boolean icmpIgnoreBogusErrorResponse) {
		this.icmpIgnoreBogusErrorResponse = icmpIgnoreBogusErrorResponse;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return the logMartian
	 */
	public Boolean getLogMartian() {
		return logMartian;
	}
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param logMartian the logMartian to set
	 */
	public void setLogMartian(Boolean logMartian) {
		this.logMartian = logMartian;
	}

}
