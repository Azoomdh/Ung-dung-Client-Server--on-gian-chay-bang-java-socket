## Ứng dụng Client-Server đơn giản chạy bằng java-socket


# khởi tạo clientSocket1

```
// tạo 'socket của client' | 'socket kết nối với server'
Socket clientSocket1 = new Socket(host:'127.0.0.1', port:9999 );
```

# Khởi tạo serverSocket1

```
ServerSocket managerOfServerSocket1 = new ServerSocket(port:9999);

// chấp nhận kết nối 
// tạo 'socket của server' | 'socket kết nối với client'
Socket serverSocket1 = managerOfServerSocket1.accept();
```

# khởi tạo luồng nhập xuất của client

```
// khởi tạo biến đọc từ bàn phím
	Scanner sc1 = new Scanner(System.in);

// khởi tạo biến nhập xuất
	DataInputStream duLieuNhanTuServer1 = null;
	DataOutputStream duLieuGuiLenServer1 = null;

// tạo giá trị của biến nhập xuất
	duLieuNhanTuServer1 = new DataInputStream(clientSocket1.getInputStream() );
	duLieuGuiLenServer1 = new DataOutputStream(clientSocket1.getOutputStream() );
```

# khởi tạo luồng nhập xuất của server

```
// khởi tạo biến đọc từ bàn phím
	Scanner sc1 = new Scanner(System.in);

// khởi tạo biến nhập xuất
	DataInputStream duLieuNhanTuClient1 = null;
	DataOutputStream duLieuGuiToiClient1 = null;

// tạo giá trị của biến nhập xuất
	duLieuNhanTuClient1 = new DataInputStream(clientSocket1.getInputStream() );
	duLieuGuiToiClient1 = new DataOutputStream(clientSocket1.getOutputStream() );
```

# lưu ý

```
/* readLine() là phiên bản cũ hơn, 
dùng readUTF để tiện lợi hơn */
```

# mã giả của client

```
while(1==1){
	// gửi tin nhắn
		String str1 = sc1.nextLine();
		duLieuGuiLenServer1.writeUTF(str1); 
		System.out.println("client đã gửi : "+ str1);

	// đọc tin nhắn
		String str2 = duLieuNhanTuServer1.readUTF(); 
		System.out.println("server đã gửi : "+ str2);
}
```

# mã giả của server
```
while(1==1){
	// đọc tin nhắn
		String str1 = duLieuNhanTuClient1.readUTF();
		System.out.println("client đã gửi : "+ str1);

	// gửi tin nhắn
		String str2 = sc1.nextLine();
		duLieuGuiLenServer1.writeUTF(str2);
		System.out.println("server đã gửi : "+ str2)
}
```