import time
import socket
import sys

print("welcome to chat")
print("")
print("waiting...")
time.sleep(1)


s = socket.socket()
host = socket.getfqdn()
port = 8080
s.bind((host,port))
print("")
print(host)
name = input(str("enter username."))
s.listen(1)
print("waiting for connetion")
print("")
conn, addr = s.accept()
print("recieved connection")


s_name = conn.recv(1024)
s_name = s_name.decode()
print(s_name, "has connected")
print("")
conn.send(name.encode())


while 1:
          message = input(str("please enter your message :"))
          conn.send(message.encode())
          print("sent")
          message = conn.recv(1024)
          message = message.decode()
          print(name, " ", message)
          
          
