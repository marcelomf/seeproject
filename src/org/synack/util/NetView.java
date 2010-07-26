/*
 * @author Marcelo M. Fleury <marcelomf[noSpam]gmail[dot]com>
 * Copyright (c) 16/08/2009 19:07:28
 * Code under gpl v2, please respect it. More information in:
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * Thank you!
 */

package org.synack.util;
import java.util.Scanner;

public class NetView {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		Ip ip = new Ip();

		try
		{
			System.out.println("Digite um ip: ");
			ip.setNumberIp(in.nextLine());
			System.out.println("Digite uma mascara: ");
			ip.setNumberMasc(in.nextLine());
			System.out.println("Ip informado: "+ip.getNumberIp()+" / "+ip.getBinIp());
			System.out.println("Mascara informada: "+ip.getNumberMasc()+" / "+ip.getBinMasc());
			System.out.println("Classe: "+ip.getClasse());
			System.out.println("Broadcast: "+ip.getNumberBroadcast());
			System.out.println("Validade Rede/Mascara: "+ip.validIpRede());
			System.out.println("Numero de sub-redes: "+ip.getNumberOfRedes());
			System.out.println("Numero de hosts: "+ip.getNumberOfHosts());
			if(ip.getNumberOfRedes() > 0 && ip.getClasse() == 'C')
			{
				int i = 0;
				int j = 1;
				int r = 0;
				while(i < ip.getNumberOfRedes())
				{
					r = (i*ip.getNumberOfHosts()+(2*i));
					System.out.println("\rSub-Rede "+i+": "+ip.getNumberIpOctets()[0]+"."+
											ip.getNumberIpOctets()[1]+"."+ip.getNumberIpOctets()[2]+"."+
											r);
					i++;
					j = r+1;
					System.out.print("Hosts: ");
					while(j < (i*ip.getNumberOfHosts()+(2*i)) && j != 255)
					{
						System.out.print(ip.getNumberIpOctets()[0]+"."+
								ip.getNumberIpOctets()[1]+"."+ip.getNumberIpOctets()[2]+"."+
								j+", ");
						j++;
					}
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Erro!!! Envie o registro abaixo para o administrador do sistema:");
			ex.printStackTrace();
		}
	}

}
