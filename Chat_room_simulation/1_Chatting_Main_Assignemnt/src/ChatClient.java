import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class ChatClient extends Frame implements Runnable, ActionListener{
	TextField txt_Msg;
	TextArea txt_History;
	Button btn_SendMsg;
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader reader;
	BufferedWriter writer;
	
	ChatClient(){
		super();
		txt_Msg=new TextField();
		txt_Msg.setColumns(30);
		txt_History=new TextArea();
		btn_SendMsg=new Button("Send");
		btn_SendMsg.addActionListener(this);
		setLayout(new FlowLayout());
		add(new Label("Chat Application - Client Window"));
		add(new Label("560 Assignment - FALL 2014"));
		add(txt_History);
		add(txt_Msg);
		add(btn_SendMsg);
		setSize(450,400);
		setVisible(true);
		startClient();		
	}
	public void run(){
		try{
			
			String str=null;
			while((str=reader.readLine())!=null){			
				txt_History.append("\nServer: "+str);
			}
			socket.close();
		}catch(Exception e){
			System.out.println("Error on Server");
		}
	}
	public void startClient(){
		try{
			Socket socket = new Socket("localhost",4444);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			Thread t = new Thread(this);	
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void sendMsg(){
		try{
			if(txt_Msg.getText()!=null){
				writer.write(txt_Msg.getText());
				writer.newLine();
				writer.flush();
			}	
		}catch(Exception e){
			System.out.println("Error while sending the messaage");
		}
	}
	public void actionPerformed(ActionEvent e){
		sendMsg();
		txt_History.append("\nClient: "+txt_Msg.getText());
		txt_Msg.setText("");
	}
	public static void main(String args[]) throws Exception{
		new ChatClient();
	}
}
