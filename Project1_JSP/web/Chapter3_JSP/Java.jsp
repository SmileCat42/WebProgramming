<%-- 
    Document   : Java
    Created on : Dec 1, 2025, 7:42:33 PM
    Author     : Windows10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java</title>
    </head>
    <body>
        <h1>Scriptlet</h1>
        <% 
            int x=10;
            double d=10.50;
            String s="Testing JSP String";
            int sum=x+100; 
            out.println(sum+" "+x+" "+d+" "+s); 
        %><br><br>
        
        <h1>Declarations</h1>
        <%! 
        public String showName(String s){ 
            return "สวัสดีคุณ : "+s;
        } 
        String g="golf";%>
        <%
        out.println(""+showName(g));
        %> <br><br>
        
        <h1>If Condition</h1>
        <%
            int p = 5;
            if (p > 10) { 
            out.println("OK."); 
            } else { 
            out.println("Not OK."); 
            }
        %> 
        
        <h1>Switch</h1>
        <% 
        int m = 5;
        switch (m) { 
        case 1 : {out.println("Banana");  break;} 
        case 2 : {out.println("Apple");  break;} 
        case 3 : {out.println("Lemon");  break;} 
        case 4 : {out.println("Orange"); break;} 
        default : {out.println("Should be 1-4");} 
        } 
        %> 
        
        <h1>For Loop</h1>
        <% 
        for (int i=1;i<=20;i++){ 
        out.println(i); 
        } 
        %> 
        
        <h1>While Loop</h1>
        <% 
        int i=0; 
        while (i<= 10) { 
        out.println(i); 
        i++; 
        } 
        %> 
        
        <h1>Do Loop</h1>
        <% 
        int t =0; 
        do { 
        out.println(t); 
        t++; 
        } while (t<= 100); 
        %> 
    </body>
</html>
