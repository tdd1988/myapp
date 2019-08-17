package dsass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket;
	private BufferedReader socketReader;
	private BufferedWriter socketWriter;
	
	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		try {
			getClientName();
			while(true){
				String msg;
				msg = socketReader.readLine();
			    if(msg != null && msg.startsWith("@")&&(msg.indexOf("%") != -1)){
			    	System.out.println("信息："+msg);
					int index = msg.indexOf("%");
					if(msg.substring(1, index).equals("MobileRun")){
						System.out.println("Moblie执行命令："+msg.substring(index+1));
						runCase("adb -s DeviceName shell am instrument -e class com.shishike.mobile.testcases."+msg.substring(index+1)+" -w com.shishike.mobile.test/com.zutubi.android.junitreport.JUnitReportTestRunner");
						Server.list.remove(this);
						this.stop();	
					}
					else if(msg.substring(1, index).equals("PosRun")){
						System.out.println("Pos执行命令："+msg.substring(index+1));
						runCase("adb -s DeviceName shell am instrument -e class com.shishike.calm.testcases."+msg.substring(index+1)+" -w com.shishike.calm.test/com.zutubi.android.junitreport.JUnitReportTestRunner");
						Server.list.remove(this);
						this.stop();
					}
					else if(msg.substring(index+1).equals("本次执行结束") || msg.substring(index+1).equals("当前用例执行结束")){
						String hasSendEnd = null;
						while(true){
							for(ServerThread st : Server.list){
								if(st.getName().equals(msg.substring(1, index))){
									st.resume();
									st.sendToClient(msg);
									hasSendEnd = "Send";
									System.out.println("执行结束命令："+msg);
									Server.list.remove(st);
									st.stop();
									Server.list.remove(this);
									break;
								}
							}
							if(hasSendEnd == "Send"){
								break;
							}
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						while(!Server.list.isEmpty()){
							for(int i=0; i< Server.list.size(); i++){
								Server.list.get(i).stop();
								Server.list.remove(i);
							}
						}
						this.stop();
					}
					else {
						String hasSendData = null;
						while(true){
							for(ServerThread st : Server.list){
								if(st.getName().equals(msg.substring(1, index))){
									st.resume();
									st.sendToClient(msg);
									hasSendData = "Send";
									System.out.println("传递信息："+msg);
									Server.list.remove(st);
									st.stop();
									Server.list.remove(this);
									break;
								}
							}
							if(hasSendData == "Send"){
								break;
							}
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}	
						this.stop();
					}
					
				}
			    
			    else {
			    	this.suspend();
			    }
			  
			}
		} catch (IOException e) {
			Server.list.remove(this);
			this.stop();
		}finally {
			ResUtils.closeAll(socket,socketWriter,socketReader);
		}
		
	}
	private void getClientName(){
		String msg;
		try {
			msg = socketReader.readLine();
			if(msg.startsWith("%")&&(msg.indexOf("@") != -1)){
				int index = msg.indexOf("@");
				this.setName(msg.substring(1, index));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
	private void runCase(String commmand){
		try {
			Runtime.getRuntime().exec("/Users/shishike/soft/android/sdk/platform-tools/"+commmand);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void sendToClient (String msg) throws IOException {
		socketWriter.write(msg);
		socketWriter.newLine();
		socketWriter.flush();
		socketWriter.close();		
	}
	
}
