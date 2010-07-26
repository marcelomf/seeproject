package org.synack.see.ipc;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public interface InvokeControl extends Remote
{
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 * @throws RemoteException
	 */
	public String retrive() throws RemoteException; // get
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 * @throws RemoteException
	 */
	public String transformRetrive() throws RemoteException; // get
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 * @throws RemoteException
	 */
	public boolean translateRetrive() throws RemoteException; // get
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param option
	 * @return
	 * @throws RemoteException
	 */
	public boolean run(String option) throws RemoteException; // get
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 * @throws RemoteException
	 */
	public boolean disable() throws RemoteException; // get
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param strXml
	 * @return
	 * @throws RemoteException
	 */
	public boolean save(String strXml) throws RemoteException; // post
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 * @throws RemoteException
	 */
	public boolean delete() throws RemoteException; // delete
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param strXml
	 * @param option
	 * @return
	 * @throws RemoteException
	 */
	public boolean saveAndRun(String strXml, String option) throws RemoteException; // post
}
