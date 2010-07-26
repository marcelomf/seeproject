/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 16/08/2009 19:07:28
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.see.xml;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.synack.see.ServiceType;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 *
 */
public class Parser
{	
	public static final String PATH_FILE_FIREWALL = "./data/firewall.xml";
	public static final String PATH_FILE_NETWORK = "./data/network.xml";
	public static final String PATH_FILE_WEBFILTER = "./data/webfilter.xml";
	
	private Document realDocument;
	private Document transformDocument;
	private File xmlFile;
	private String strRealDocument;
	
	public Parser(){}

	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param serviceType
	 * @throws XPathExpressionException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public Parser(ServiceType serviceType) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException
	{
		getDocumentService(serviceType);
	}
	
	/**
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param serviceType
	 * @param pathFile
	 * @throws XPathExpressionException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public Parser(ServiceType serviceType, String pathFile) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException
	{
		getDocumentService(serviceType, pathFile);
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 * @throws FileNotFoundException
	 */
	public String getStrRealDocument() throws FileNotFoundException
	{
		strRealDocument="";
		Scanner read = new Scanner(xmlFile);
		while(read.hasNext())
			strRealDocument+=read.nextLine()+"\n";			

		return strRealDocument;
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param serviceType
	 * @param pathFile
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 */
	public Document getDocumentService(ServiceType serviceType, String pathFile) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException
	{	
		switch (serviceType) 
		{
			case NETWORK:
				pathFile = (pathFile == null) ? Parser.PATH_FILE_NETWORK : pathFile;
				xmlFile = new File(pathFile);
				realDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
				break;
			case FIREWALL:
				Document network = getDocumentService(ServiceType.NETWORK);
				pathFile = (pathFile == null) ? Parser.PATH_FILE_FIREWALL : pathFile;
				xmlFile = new File(pathFile);
				realDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
				Node noMestre = realDocument.getFirstChild();
				while (network.hasChildNodes()) 
				{
					Node kid = network.getFirstChild();
					network.removeChild(kid);
					kid = realDocument.importNode(kid, true);
					noMestre.appendChild(kid);
				}
				break;
			case WEBFILTER:
				pathFile = (pathFile == null) ? Parser.PATH_FILE_WEBFILTER : pathFile;
				break;
			default:
				pathFile = null;
				break;
		}
		
        return realDocument;   
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param serviceType
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 */
	public Document getDocumentService(ServiceType serviceType) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException
	{	
		return this.getDocumentService(serviceType, null);
	}

	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param doc
	 * @return
	 * @throws XPathExpressionException
	 */
	public Document transformSee() throws XPathExpressionException
	{
		transformDocument = realDocument;
		NodeList nodes = Parser.nodesByXPath(transformDocument, "//@*[starts-with(., '@')]");

		for(int i =0; i < nodes.getLength(); i++)
		{
			Node nodeValue = nodes.item(i);
			String newStringNodeValue = "";
			for(String nameValue : nodeValue.getTextContent().split(","))
			{
				String attributeNameValue = "";
				if(nameValue.contains("["))
				{
					attributeNameValue = nameValue.substring((nameValue.indexOf("[")+1), nameValue.indexOf("]"));
					nameValue = nameValue.substring(1, nameValue.indexOf("[")); 
				}
				else
				{
					if(nodeValue.getNodeName().toLowerCase().contains("interface"))
						attributeNameValue = "physical";
					else if(nodeValue.getNodeName().toLowerCase().contains("ip"))
						attributeNameValue = "ip";
					else if(nodeValue.getNodeName().toLowerCase().contains("port"))
						attributeNameValue = "port";
					else if(nodeValue.getNodeName().toLowerCase().contains("router"))
						attributeNameValue = "ip";
					else
						continue;
					/*else
						attributeNameValue = "ip";*/
					
					nameValue = nameValue.substring(1);
				}
					
				NodeList newNodeList = Parser.nodesByXPath(transformDocument, "//*[@name='"+nameValue+"']");
				if(newNodeList.getLength() > 0)
				{
					Node newNodeValue = newNodeList.item(0);
					newNodeValue = newNodeValue.getAttributes().getNamedItem(attributeNameValue);
					nameValue = newNodeValue.getTextContent();
				}
				
				if(newStringNodeValue.equals(""))
					newStringNodeValue = nameValue; 
				else
					newStringNodeValue += ","+nameValue;
			}
			nodeValue.setTextContent(newStringNodeValue);
		}
		return transformDocument;
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param doc
	 * @param xPath
	 * @return
	 * @throws XPathExpressionException
	 */
	public static NodeList nodesByXPath(Document doc, String xPath) throws XPathExpressionException
	{
		XPath xpath = XPathFactory.newInstance().newXPath();
		return (NodeList) xpath.evaluate(xPath, doc, XPathConstants.NODESET);
	}
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param doc
	 * @param xPath
	 * @param constant
	 * @return
	 * @throws XPathExpressionException
	 */
	public static NodeList nodesByXPath(Document doc, String xPath, QName constant) throws XPathExpressionException
	{
		XPath xpath = XPathFactory.newInstance().newXPath();
		return (NodeList) xpath.evaluate(xPath, doc, constant);
	}

	
	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param realDocument
	 */
	public void setRealDocument(Document realDocument)
	{
		this.realDocument = realDocument;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 */
	public Document getRealDocument()
	{
		return realDocument;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param transformDocument
	 */
	public void setTransformDocument(Document transformDocument)
	{
		this.transformDocument = transformDocument;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 */
	public Document getTransformDocument()
	{
		return transformDocument;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @param xmlFile
	 */
	public void setXmlFile(File xmlFile)
	{
		this.xmlFile = xmlFile;
	}

	/**
	 * 
	 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
	 * @return
	 */
	public File getXmlFile()
	{
		return xmlFile;
	}

}
