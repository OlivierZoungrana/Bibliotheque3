<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"  href="./css/style.css"/>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@800&display=swap" rel="stylesheet">
<title>Inscription</title>
</head>
	<title>Inscription</title>
	</head>
	<body>
	<%@ include file="menu.jsp" %>
	
	<div class="inscription">
		<form method="Post" action="BiblioServlet">
			<fieldset>
				<legend>INSCRIRE ETUDIANT</legend>
					<label for="nom">Nom</label>
	                <input type="text" id="nom" name="nom" size="20" maxlength="20" value="${abonne.nom}" />
	                <br />
	                <label for="prenom">prenom</label>
	                <input type="text" id="prenom" name="prenom" size="20"  value="${abonne.prenom}" />
	                <br/>
	                <label for="email">Email</label>
	                <input type="email" id="email" name="email" size="20"  value="${abonne.email}" />
	                <br/>
	                <label for="adresse">adresse</label>
	                <input type="text" id="adresse" name="adresse" size="20"  value="${abonne.adresse}" />
	                <br/>
	                <label for="DateNaissance">Date de Naissance</label>
	                <input type="date" id="datenaissance" name="dateNaissance" value="${abonne.dateNaissance}"/>
	                <br>
	                <label for="dateAdhesion">Date d'adhesion</label>
	                <input type="date" id="dateAdhesion" name="dateAdhesion" value="${abonne.dateAdhesion}"/>
	                <br/>
	                <label for="tel">telephone</label>
	                <input type="tel" id="telephone" name="telephone" size="20"  value="${abonne.telephone}" />
	                <br>
	                <label for="CategoriePro">catégorie professionnelle</label>
	                <input type="text" id="categoriePro" name="categoriePro" size="20" value="${abonne.categoriPro}" />
	                <br/>
	           		<input type="hidden" name="matricule" value='${abonne.matricule}'>
	                <input type="submit"  value="Envoyer" />
		</fieldset>
		</form>
	</div>		
		    <%@ include file="footer.jsp" %>   
	</body>
</html>