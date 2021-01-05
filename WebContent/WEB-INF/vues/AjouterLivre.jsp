<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"  href="./css/style.css"/>
<title>Ajouter un livre</title>
</head>
<body>

<%@ include file="menu.jsp" %>

	<div class="livre">
		<form method="Post" action="LivreAddServlet">
			<fieldset>
				<legend>Ajouter un Livre</legend>
					<label for="nom">Titre</label>
	                <input type="text" id="titre" name="titre" size="20" maxlength="20" />
	                <br />
	                 <input type="submit" value="Valider" />
			</fieldset>
		</form>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>