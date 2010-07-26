package org.synack.util;
/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 16/08/2009 19:07:28
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */
public class Ip extends Network
{
	private String numberIp;
	private String numberMasc;
	private String numberRede;
	private String numberBroadcast;
	private String numberIpOctets[] = new String[4];
	private String numberMascOctets[] = new String[4];
	private String binIp;
	private String binMasc;
	private String binIpOctets[] = new String[4];
	private String binMascOctets[] = new String[4];
	private char classe;
	
	public Ip()
	{
	}

	public int getNumberOfRedes()
	{
		int conta = 0;
		int resultado = 0;
		
		for(char bit : binMasc.toCharArray())
			if(bit == '1')
				conta++;
		
		if(getClasse() == 'A')
			resultado = new Double(Math.pow(2, (conta-8))).intValue();
		else if(getClasse() == 'B')
			resultado = new Double(Math.pow(2, (conta-16))).intValue();			
		else if(getClasse() == 'C')
			resultado = new Double(Math.pow(2, (conta-24))).intValue();
		else if(getClasse() == 'D')
			resultado = new Double(Math.pow(2, (conta-25))).intValue();
		else if(getClasse() == 'E')
			resultado = new Double(Math.pow(2, (conta-27))).intValue();

		return (resultado < 0) ? 0 : resultado;
	}
	
	public int getNumberOfHosts()
	{
		int conta = 0;
		for(char bit : binMasc.toCharArray())
			if(bit == '0')
				conta++;
		int resultado = new Double(Math.pow(2, conta)).intValue()-2;
		return (resultado < 0) ? 0 : resultado;
	}
	
	public void gerarBin()
	{
		setBinIpOctets(toBin(getNumberIpOctets()));
		setBinMascOctets(toBin(getNumberMascOctets()));
		setBinIp(getBinIpOctets()[0]+"."+getBinIpOctets()[1]+"."+getBinIpOctets()[2]+"."+getBinIpOctets()[3]);
		setBinMasc(getBinMascOctets()[0]+"."+getBinMascOctets()[1]+"."+getBinMascOctets()[2]+"."+getBinMascOctets()[3]);
	}
	
	public boolean validIpRede()
	{
		if(getBinIp().lastIndexOf('1') > getBinMasc().lastIndexOf('1'))
			return false;
		else
			return true;
	}
	
	public char calcClasse() throws Exception 
	{
		try
		{
			String netid = getBinIpOctets()[0];
			
			if(netid.substring(0, 1).equals("0"))
				return 'A';
			else if (netid.substring(0, 2).equals("10"))
				return 'B';
			else if (netid.substring(0, 3).equals("110"))
				return 'C';
			else if (netid.substring(0, 4).equals("1110"))
				return 'D';
			else if (netid.substring(0, 5).equals("11110"))
				return 'E';
			else
				throw new Exception("Erro! Endereço de rede inválido! Impossível calcular mascara!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return '0';
	}

	public void setNumberIp(String numberIp) throws Exception 
	{
		try
		{
			this.numberIp = numberIp;
			setNumberIpOctets(toArray(this.numberIp));

			if(!validNumber(getNumberIpOctets()))
				throw new Exception("Erro! Endereço de rede inválido!");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public String getNumberIp() {
		return numberIp;
	}


	public void setNumberMasc(String numberMasc) throws Exception 
	{
		try
		{
			this.numberMasc = numberMasc;
			
			setNumberMascOctets(toArray(this.numberMasc));
			
			gerarBin();
			
			setClasse(calcClasse());
			
			if(getClasse() == 'A')
				setNumberBroadcast(getNumberIpOctets()[0]+".255.255.255");
			else if(getClasse() == 'B')
				setNumberBroadcast(getNumberIpOctets()[0]+"."+getNumberIpOctets()[1]+".255.255");
			else
				setNumberBroadcast(getNumberIpOctets()[0]+"."+getNumberIpOctets()[1]+"."+getNumberIpOctets()[2]+".255");
			
			if(!validNumber(getNumberMascOctets()))
				throw new Exception("Erro! Endereço de mascara inválido!");
			else if(!validIpRede())
				throw new Exception("Erro! Endereço de mascara inválido para essa rede!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public String getNumberMasc() {
		return numberMasc;
	}


	public void setNumberRede(String numberRede) {
		this.numberRede = numberRede;
	}


	public String getNumberRede() {
		return numberRede;
	}


	public void setNumberBroadcast(String numberBroadcast) {
		this.numberBroadcast = numberBroadcast;
	}


	public String getNumberBroadcast() {
		return numberBroadcast;
	}


	public void setNumberIpOctets(String[] numberIpOctets) {
		this.numberIpOctets = numberIpOctets;
	}


	public String[] getNumberIpOctets() {
		return numberIpOctets;
	}


	public void setNumberMascOctets(String[] numberMascOctets) {
		this.numberMascOctets = numberMascOctets;
	}


	public String[] getNumberMascOctets() {
		return numberMascOctets;
	}


	public void setClasse(char classe) {
		this.classe = classe;
	}


	public char getClasse() {
		return classe;
	}

	public void setBinIp(String binIp) {
		this.binIp = binIp;
	}

	public String getBinIp() {
		return binIp;
	}

	public void setBinMasc(String binMasc) {
		this.binMasc = binMasc;
	}

	public String getBinMasc() {
		return binMasc;
	}

	public void setBinIpOctets(String[] binIpOctets) {
		this.binIpOctets = binIpOctets;
	}

	public String[] getBinIpOctets() {
		return binIpOctets;
	}

	public void setBinMascOctets(String[] binMascOctets) {
		this.binMascOctets = binMascOctets;
	}

	public String[] getBinMascOctets() {
		return binMascOctets;
	}
	
}
