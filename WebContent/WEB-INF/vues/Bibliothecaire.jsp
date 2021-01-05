<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"  href="./css/style.css"/>
<title>Bibliothecaire</title>
</head>
<body>
<%@ include file="menu.jsp" %>

	<div class="identifiant">
	<h1>Identification Admin</h1>
		<form method="Post" action="BiblioServlet">
			<fieldset>
				<legend>Identifiez vous</legend>
					<label for="nom">Nom</label>
	                <input type="text" id="nom" name="nom" size="20" maxlength="20" />
	                <br>
	                <label for="mot de passe">password</label>
	                <input type="password" id="password" name="password" size="20" maxlength="12"/>
	                <br />
	                <br/>
	                <input type="submit" value="Valider"/>
	        </fieldset>
	      </form>
	</div>
	
	<div class="gestion">

		<ul>
			<li><a class="bouton" href="/Bibliotheque3/gestionAdherents">Gestion Adhérents</a></li>
			<li><a class = "bouton" href="/Bibliotheque3/gestionLivre">Gestion Livres</a></li>
		</ul>
		
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>