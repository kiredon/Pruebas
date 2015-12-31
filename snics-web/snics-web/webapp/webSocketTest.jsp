<%@  page import="java.io.*,java.util.*" language="java" contentType="text/html;                      
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Test alertas web socket</title>
<script type="text/javascript">


         
      // Let us open a web socket
      var ws = new WebSocket("ws://192.168.1.99:8001/");
		
      ws.onopen = function()
      {
         // Web Socket is connected, send data using send()
         //ws.send("Message to send");
         //alert("Message is sent...");
      };
		
      ws.onmessage = function (evt) 
      { 
         var received_msg = evt.data;
         alert("Message is received..."+received_msg);
      };
		
      ws.onclose = function()
      { 
         // websocket is closed.
         alert("Connection is closed..."); 
      };
   
   
  

</script>
</head>
<body>

<h1><center>alertas web socket</center></h1>

</body>

</html>