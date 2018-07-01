Day 26 
description 

topics to Learn:

Introduction to networking in Java: Networking Fundamentals, TCP/IP Model, TCP/IP Communication, Internet Protocol (IP), Loopback Interface
I/O streams : FileInputStream, FileOutputStream, DataStream, CharacterStream,BufferedStream, PrintStream, System.in
Java Socket programming - Java Socket Programming Intro, Local Port, Scanner, TCP Server, Multi-user Server, Multithreaded Server, InetAddress class, TCP Client, Remote Port Scanner, Ping, Validate IP addresses, NetworkInterface class, URL and Web Scraping
Java UDP programming: UDP Intro, UDP Client, UDP Server, UDP Timeout

Assignment
write a socket client/server program, where client (Client.java) sends a number (message) to the server, Server receives this number and multiplies it by 2. Server (Server.java) sends back the result (message) to the client (Client.java).

Validation: In case the number sent by the client was not a proper number, server (Server.java) sends back the message “Please send a proper number” to the client (Client.java)
 
 
Implementation
 
 I have used serversocket class to create a socket and socket class to connect.
 For validation i have used wrapper class that throws Exception when we try to convert string to double