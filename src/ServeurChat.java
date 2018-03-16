package ProjetChat;


import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public  class ServeurChat
{

	static HashMap<Integer,String> listeName;

	public static void main(String[] args) throws  Exception
	{
		InetAddress mcast = InetAddress.getByName("225.1.1.1"); // creer une adresse inet ayant pour nom : 225.1.1.1
		MulticastSocket ms = new MulticastSocket(2009); // seul les clients avec le port 2009 peuvent entrée

		listeName = new HashMap<>();

		ms.joinGroup(mcast); // je sais plus MAIS C'EST IMPORTANT, ça marche pas si on enleve

		while ( true)
		{
			DatagramPacket dp = new DatagramPacket( new byte[512],512); // crée un DataGramPacket receveur , le receveur a 2 parametres
			ms.receive(dp); // reçois le msg
			String message = new String( dp.getData() ); // decompile le msg en String

			if ( message.contains("Name :") ) listeName.put(dp.getPort(), message.substring(6));

			System.out.println( listeName.get( dp.getPort() ) + " a envoye : " + message); //dp.getPort sert uniquement pour identifier le client

		}
	}
}