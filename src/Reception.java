import java.io.*;
import java.net.*;
class Reception extends Thread {
    private Socket socket;
    private Serveur serveur;
    public Reception(Socket s, Serveur serveur)
    {
        socket = s;
        this.serveur = serveur;
    }
    public void run() {
        try {
            while (true)
            {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String message = br.readLine();

                serveur.newMessage(message);
            }
        }catch (Exception e) {}
        finally {try{socket.close();
        }catch (Exception e) {}
        }
    }
}
