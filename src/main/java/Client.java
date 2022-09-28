import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5555);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            String msg = "Hello";
            output.writeUTF(msg);
            output.flush();

            msg = input.readUTF();
            System.out.println("Answer: " + msg);

            input.close();
            output.close();
            socket.close();
        } catch (Exception ignore) {

        }
    }
}
