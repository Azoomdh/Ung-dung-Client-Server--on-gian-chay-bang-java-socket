
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class clientSock {
    public static void main(String[] args) {
        try {
            Socket client1Socket1 = new Socket("127.0.0.1", 9999);
            
            // khai bao bien nhap xuat
                DataInputStream duLieuNhanTuServer1 = null;
                DataOutputStream duLieuGuiLenServer1 = null;
            
            // khai bao gia tri cua bien nhap xuat
                duLieuNhanTuServer1 = new DataInputStream(client1Socket1.getInputStream());
                duLieuGuiLenServer1 = new DataOutputStream(client1Socket1.getOutputStream());

            // chao hoi nhau
                String str1= duLieuNhanTuServer1.readUTF();
                System.out.println("Server said : "+ str1);
                String str2= "received your message, hello i m client";
                duLieuGuiLenServer1.writeUTF(str2);
                System.out.println("ban da gui : "+ str2);
                
            // server lap lai client
            Scanner sc1= new Scanner(System.in);
            while (true) { 
                String str3 = sc1.nextLine();
                duLieuGuiLenServer1.writeUTF(str3);
                System.out.println("Ban da gui : "+ str3);

                String str4 = duLieuNhanTuServer1.readUTF();
                System.out.println("server said : "+ str4);
            }
            
        } catch (IOException ex) {
            System.out.println("IOexception : "+ ex.getMessage());
        }
    }
}
