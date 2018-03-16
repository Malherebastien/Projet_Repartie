import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client{
    private static String pseudo;
    private static PrintWriter ostream;
    private static Socket socket;

    public static void main(String args[]){
        try{
            socket = new Socket("localhost", 2009);
            OutputStream out = socket.getOutputStream();
            ostream = new PrintWriter(out);
            Scanner sc = new Scanner(System.in);
            String str;
            Frame frame = new Frame();
            System.out.print("Veuillez choisir un pseudo : ");

            do
            {
                pseudo = frame.getPseudo();
            } while (pseudo == null);

            sendMsg("Coucou");
            do
            {
                checkForMsg();
            } while (true);
            //socket.close();
        }catch (UnknownHostException err){
            System.err.println ("ClientDateT : " + err);
        }catch (IOException err){System.err.println ("ClientDateT : " + err);
        }
    }

    public static void sendMsg(String str)
    {
        ostream.println(pseudo + " : " + str);
        ostream.flush();
    }

    public static void checkForMsg() throws IOException
    {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        System.out.println("message" + br.readLine());
    }
}
