package gitservclient;
import java.net.*;
import java.io.*;
import java.util.*;
public class client  {
	private  Socket istemcisocket;//Istemci tarafinin socketi
	private  DataInputStream mesajal;//Veri alma 
	private  DataOutputStream mesajver;//Veri yollama
	public client() throws IOException{//giris/cikis hatasi verme
		istemcisocket=new Socket("localhost",6789);//baglanti adi ve port numarasi belirt
		System.out.println(istemcisocket.getLocalAddress()+"Adresine baglanildi...");
		try {
			while(true){
				mesajver=new DataOutputStream(istemcisocket.getOutputStream());//mesaji göndermek icin yol ac
				Scanner get=new Scanner(System.in);
				System.out.println("Lutfen Gondereceginiz Mesaji Giriniz:");
				String al=get.nextLine();
				mesajver.writeUTF(al);//mesaji yolla
				mesajal=new DataInputStream(istemcisocket.getInputStream());//mesaji al
				System.out.println("<Sunucu:>"+mesajal.readUTF());//ekrani oku ve yaz
			}
		} catch (Exception e) {
			
		}

	}
	
	public static void main(String[] args) throws IOException {
		client nesne=new client();
		
	
		
	}


}

//In my example is establish connect between server and client and provide chatting.



public class server {

	private ServerSocket ss;
	private Socket sunucusoc;
	private DataInputStream mesajal;
	private DataOutputStream mesajver;
	
	public server() throws IOException{
		ss=new ServerSocket(6789);
		System.out.println("Ýstemcinin Baglanmasi Bekleniyor....");
		sunucusoc=ss.accept();
		System.out.println("Ýstemci Baðlandi...");
		try {
			while (true){
				mesajal=new DataInputStream(sunucusoc.getInputStream());
				System.out.println("<Ýstemci:>"+mesajal.readUTF());
				mesajver=new DataOutputStream(sunucusoc.getOutputStream());
				Scanner get=new Scanner(System.in);
				System.out.println("Lutfen Gonderilecek Mesaji Giriniz:");
				String al=get.nextLine();
				mesajver.writeUTF(al);
			}
			
		} catch (Exception e) {
			
		}

	}
	public static void main(String[] args) throws IOException {
		
		server nesne=new server();
		
	}


}
