<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"  href="./css/style.css"/>
<title>Gestion Livre</title>
</head>
<body>
<%@include file="menu.jsp" %>
 <div class="gestion">
 <ul>
 	<li><a class="bouton" href="/Bibliotheque3/AjouterLivre">Ajouter un livre</a></li>
 	<li><a class="bouton" href="/Bibliotheque3/ListeLivre">Afficher les livres</a></li>
 </ul>
 </div>
	
<%@include file="footer.jsp" %>
</body>
</html>