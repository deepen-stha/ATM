
import java.net.*;
import java.io.*;
public class Client {
 
    public static void main (String [] args ) throws IOException {
        int filesize=1022386; 
        int bytesRead ;
        int currentTot = 0;
        Socket socket = new Socket("192.168.0.14",15123);
        byte [] bytearray  = new byte [filesize];
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("D:\\alo.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        is.read(bytearray,0,bytearray.length);
        fos.write(bytearray,0,bytearray.length);
        
        bytesRead = is.read(bytearray,0,bytearray.length);
        currentTot = bytesRead;
 
        do {
           bytesRead =
              is.read(bytearray, currentTot, (bytearray.length-currentTot));
           if(bytesRead >= 0) currentTot += bytesRead;
        } while(bytesRead > -1);
 
        bos.write(bytearray, 0 , currentTot);
        bos.flush();
        bos.close();
        socket.close();
      }
}