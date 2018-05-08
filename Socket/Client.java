import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;


public class Client {

    public static void main(String args[]) throws IOException {

        String message, temp;

        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("127.0.0.1", 80);
        Scanner sc1 = new Scanner(s.getInputStream());

        System.out.println("Enter message");
        message = sc.nextLine();

        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(message);
        PrintStream p = new PrintStream(s.getOutputStream());

        p.println(byteBuffer);
        temp = sc1.nextLine();
        
        System.out.println(temp);

    }
}
