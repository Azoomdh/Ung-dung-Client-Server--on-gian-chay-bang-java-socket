
import java.io.*;
import java.net.*;
import java.util.*;

public class serverSock{
    public static void main(String[] args) {
        try(ServerSocket Manager1OfServer1Socket = new ServerSocket(9999); ){
            // accept ket noi
                Socket server1Socket1 = Manager1OfServer1Socket.accept();
                System.out.println("# accepted to client");

            // khai bao bien thuc thi nhap xuat
                DataInputStream duLieuClientGuiVe1 = null;
                DataOutputStream duLieuGuiToiClient1 = null;

            // khai bao gia tri cua bien thuc thi nhap xuat
                duLieuClientGuiVe1 = new DataInputStream(server1Socket1.getInputStream());
                duLieuGuiToiClient1 = new DataOutputStream(server1Socket1.getOutputStream());

            // chao hoi nhau
                String str0 = " hello client, i m server";
                duLieuGuiToiClient1.writeUTF(str0);
                System.out.println("ban da gui : "+ str0);
                str0= duLieuClientGuiVe1.readUTF();
                System.out.println("client said : "+ str0);

            // server lap lai client
            Scanner sc1 = new Scanner(System.in);
            while(true){
                String str1= duLieuClientGuiVe1.readUTF();
                System.out.println("client said : "+ str1);

                String str2 = sc1.nextLine();
                duLieuGuiToiClient1.writeUTF(str2);
                System.out.println("ban da gui : "+ str2);
            }
        }catch( IOException ex){
            System.out.println("io exception"+ ex.getMessage());
        }
    }
}