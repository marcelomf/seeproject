/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 16/08/2009 19:07:28
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */
package org.synack.see.xml;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

@SuppressWarnings("rawtypes")
public class ParserObject {
	
	/**
	 * 
	 * @author Marcelo M. Fleury marcelomf[noSpam]gmail[dot]com
	 * @param object
	 * @param resultObject
	 * @param serviceType
	 * @return Collection
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Collection getObjects(Object object, Collection resultObject, NodeList nodeListXml) throws Exception
	{
		//for (int i = nodeListXml.getLength()-1; i >= 0; i--)
		for (int i = 0; i < nodeListXml.getLength(); i++)
        {
            Element xmlElement = (Element) nodeListXml.item(i);
            object = object.getClass().newInstance();
            //System.out.println(xmlElement.getTextContent());
            object = ParserObject.getObject(object,  xmlElement.getAttributes());
            resultObject.add(object);
        }
        return resultObject;
	}
	
	public static Object getObject(Object object, NamedNodeMap attributes) throws Exception
	{
        //for (int j = xmlElement.getAttributes().getLength()-1; j >= 0; j--)
        for (int j = 0; j < attributes.getLength(); j++) 
        {
            String attributeName = attributes.item(j).getNodeName();
            String attributeValue = attributes.item(j).getNodeValue();
            String methodName = "set"+Character.toUpperCase(attributeName.charAt(0))+attributeName.substring(1);
    
            Class reflectionClass = Class.forName(object.getClass().getName().toString());
            Field reflectionField;
            try
            {
            	reflectionField = reflectionClass.getDeclaredField(attributeName);
            }
            catch(NoSuchFieldException e)
            {
            	Class reflectionSuperClass = reflectionClass.getSuperclass();
            	reflectionField = reflectionSuperClass.getDeclaredField(attributeName);	
            }
            
            reflectionField.setAccessible(true);
            @SuppressWarnings("unchecked")
			Method reflectionMethod = reflectionClass.getMethod(methodName, reflectionField.getType());
            
            reflectionMethod.setAccessible(true);
            if(reflectionField.getType().isInterface())
            {
            	if(reflectionField.getType() == Set.class)
            	{
            		HashSet<String> valores = new HashSet<String>(); 
            		for(String elemento : attributeValue.split(","))
            			valores.add(elemento);
            		
            		reflectionMethod.invoke(object, valores);                		
            	}

            }
            else
            {
            	if(reflectionField.getType() == Boolean.class) 
            		reflectionMethod.invoke(object, new Boolean(attributeValue));
            	else
            		reflectionMethod.invoke(object, attributeValue);
            }		
        }
		return object;
	}
	
/*	public static void teste()
	{
		String nomeElemento = object.getClass().getSimpleName().toLowerCase().toLowerCase();
        Document doc = Parser.getDocumentService(serviceType);
        NodeList nodeListXml = doc.getElementsByTagName(nomeElemento);
	}*/
}
