<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Livres</title>
<link rel="stylesheet"  href="./css/style.css"/>
</head>
<body>
<%@include file="menu.jsp" %>
 <table border="1">
 
 	<caption><h2>LISTE DES LIVRES</h2></caption>
 	
 			<tr>
 			
 				<th>Id_catalogue</th>
 				<th> Titre</th>
 				<th> Action </th>
 			</tr>
 			
 				<c:forEach var="livre" items="${LLivre}"> 
 				
 			<tr>
 				<TD><c:out value="${livre.id_catalogue}"></c:out></TD>
                <TD><c:out value="${livre.titre}"></c:out></TD>
                <td>
               		<form action="ListerLivre" method="post"> 
               			<input type="hidden" name="action" value="supprimer"/>
               			<input type="hidden" name="id_catalogue" value='${Livre.id_catalogue}'/>
               			<input type="submit" value="supprimer"/>
               		</form>
            </td>
            <td>
               		<form action="ListerLivre" method="post"> 
               			<input type="hidden" name="action" value="modifier"/>
               			<input type="hidden" name="id_catalogue" value='${livre.id_catalogue}'/>
               			<input type="submit" value="modifier"/>
               		</form>
               </td>
             </tr>
             
             
             
            </c:forEach>
 
 </table>


<%@ include file="footer.jsp" %>
</body>
</html>