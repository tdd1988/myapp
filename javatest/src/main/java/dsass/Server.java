package dsass;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {  
	
	public static List<ServerThread> list = new ArrayList<>();
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket socket = new ServerSocket(4726);
			while(true){
				Socket accept = socket.accept();
				ServerThread st = new ServerThread(accept);
				st.start();
				list.add(st);
				System.out.println("获得："+st.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}  


