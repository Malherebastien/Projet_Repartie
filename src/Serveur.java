import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

public class Serveur{
    Socket client_Socket;
    public Serveur() throws IOException
    {
        int nbrclient = 1;
        ServerSocket socket = new ServerSocket(2009);
        while(true){
            client_Socket = socket.accept();
            System.out.println("Le client "+nbrclient+ " est connecté !");
            nbrclient++;
            Reception myReception = new Reception(client_Socket, this);
            myReception.start();
        }
    }

    public void newMessage(String message)
    {
        PrintWriter flux = null;
        try
        {
            flux = new PrintWriter(client_Socket.getOutputStream());
            flux.println(message);
            flux.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception
    {
        new Serveur();
    }
}
