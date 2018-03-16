package ProjetChat;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientChat
{


	public static void main(String[] args) throws Exception
	{

		MulticastSocket ms = new MulticastSocket();

		InetAddress mcast = InetAddress.getByName("225.1.1.1"); // se connecte au serveur ayant pour nom 225.1.1.1

		Scanner scName = new Scanner( System.in) ;

		String name;

		name = "Name :" + scName.nextLine();

		// envoie le nom en compiler en bytes, la taille du msg,
		DatagramPacket dpName = new DatagramPacket(name.getBytes(), name.length(), mcast, 2009);

		ms.send(dpName); //envoie du msg compilé

		while ( true )
		{

			Scanner sc = new Scanner( System.in) ;

			String message;

			message = sc.nextLine();

			if ( message.equals("Quitter") | message.equals("quitter")) break;

			// crée un Datagram envoyeur, l'envoyeur a 2 parametres
			// envoie le message en bytes, envoie la taille du msg, sur le port 2009
			// si le port est autre que le port du Serveur ( ici : 2009 ) ça fait une erreur ou alors ça fait rien
			DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), mcast, 2009);

			ms.send(dp);
		}
		ms.close();

	}

}