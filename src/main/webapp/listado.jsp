<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" import="model.Tienda,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%ArrayList<Tienda> productos=(ArrayList<Tienda>)request.getAttribute("productos");%>
	<center>
		<table border='1'><tr><th>Nombre</th><th>Precio</th><th>Stock</th></tr>
			<%for(int i=0;i<productos.size();i++) {
				Tienda pd=productos.get(i);%>
				<tr><td><%=pd.getNombre()%></td><td><%=pd.getPrecio() %></td><td><%=pd.getStock() %></td></tr>	
			<%}%>
		
		</table>
		<br>
		<a href='datos.jsp'>Volver</a>
	</center>
</body>
</html>