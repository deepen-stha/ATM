import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class JavaSMS {
	String message;
	int temp;
	public void SMS(String code) throws Exception {
		
		
		//checking if the message can be parse to int or not
		try {
			temp = Integer.parseInt(code);
			message = "this is yor verification id "+code;				 
		}
		catch(Exception e){
			//if the code cannot be parse then the user has givenn wrong verification id
		
			message = code;
		}

		//it will run at last instead of whether try or catch blocks run
		finally {
		// TODO Auto-generated method stub
			
			//sending no
			//you can even send the message to police station if someone is interfering your account
				String phone = "+917676446438";
				String username = "deepen";
				String password = "1234";
				String address = "http://192.168.0.12";
				String port = "8090";
				
				URL url = new URL(
						address+":"+port+"/SendSMS?username="+username+"&password="+password+
						"&phone="+phone+"&message="+URLEncoder.encode(message,"UTF-8"));
				
				URLConnection connection = url.openConnection();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				while((inputLine = bufferedReader.readLine()) !=null){
					System.out.println(inputLine);
				}
				bufferedReader.close();
				
			}

	}
}

