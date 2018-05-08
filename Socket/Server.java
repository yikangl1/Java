import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String args[]) throws IOException {


        String message, back;

        ServerSocket s1 = new ServerSocket(80);
        Socket s = s1.accept();
        Scanner sc = new Scanner(s.getInputStream());


        message = sc.nextLine();
        System.out.println(message);

        if (message == "Hello Server"){
            back = "Hello Client";
        }else if (message == "Disconnect"){
            back = "Goodbye";
            s.close();
        }else{
            back = "Invalid message";
        }
        PrintStream p = new PrintStream(s.getOutputStream());

        p.println(back);


    }

}
