import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientDateT{
    public static void main(String args[]){
        try{
            Socket socket = new Socket("localhost", 2009);
            OutputStream out = socket.getOutputStream();
            PrintWriter ostream = new PrintWriter(out);
            Scanner sc = new Scanner(System.in);
            String str;
            System.out.print("Veuillez choisir un pseudo : ");
            String pseudo = sc.nextLine();
            do
            {
                str = sc.nextLine();
                ostream.println(pseudo + " : " + str);
                ostream.flush();
            } while (!str.equals("stop"));
            socket.close();
        }catch (UnknownHostException err){
            System.err.println ("ClientDateT : " + err);
        }catch (IOException err){System.err.println ("ClientDateT : " + err);
        }
    }
}
