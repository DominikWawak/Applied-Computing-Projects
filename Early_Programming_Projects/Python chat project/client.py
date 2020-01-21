import time
import socket
import sys

print("welcome to chat")
print("")
print("waiting...")
time.sleep(1)


s = socket.socket()
print("")
host = input(str("enter server address"))
name = input(str("enter username."))
port = 8080
print("trying to connect", host ,"At port", port)
time.sleep(1)
s.connect((host,port))
print("connected")

s.send(name.encode())
s_name = s.recv(1024)
s_name = s_name.decode()
print(s_name, "has joinedthe chatroom")


while 1:
          message = s.recv(1024)
          message = message.decode()
          print(name, " ", message)
          message = input(str("please enter your message :"))
          s.send(message.encode())
          print("sent")

