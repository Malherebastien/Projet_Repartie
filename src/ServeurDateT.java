/*import java.net.*;

public class ServeurDateT{
    public static void main(String args[]) throws Exception{
        int nbrclient = 1;
        ServerSocket socket = new ServerSocket(2009);
        while(true){
            Socket client_Socket = socket.accept();
            System.out.println("Le client "+nbrclient+ " est connecté !");
            nbrclient++;
            Reception myReception = new Reception(client_Socket);
            myReception.start();
        }
    }
}*/
