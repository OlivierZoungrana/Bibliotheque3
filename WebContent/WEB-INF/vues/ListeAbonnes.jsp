<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"  href="./css/style.css"/>
<title>ListeAbonne</title>
</head>
<body>
<%@include file="menu.jsp" %>

<div class="listeA" align="center">

 
 <TABLE BORDER="1" >
 
 	<caption><h2>LISTE DES ABONNES</h2></caption>

            <TR>
               <TH>matricule</TH>
               <TH>Nom</TH>
               <th>Prenom</th>
               <th>Email</th>
               <th>Adresse</th>
               <th>Date de naissance</th>
               <th>Date d'adhésion</th>
               <th>telephone</th>
               <th>catégorie Pro</th>
			   <th>Action</th>
               
               
            </TR>
           
           <c:forEach var="abonne" items="${LAbonnes}">
           
           <TR>
           	   <TD><c:out value="${abonne.matricule}"></c:out></TD>
               <TD><c:out value="${abonne.nom}"></c:out></TD>
               <TD><c:out value="${abonne.prenom}"></c:out></TD>
               <TD><c:out value="${abonne.email}"></c:out></TD>
               <TD><c:out value="${abonne.adresse}"></c:out></TD>
               <TD><c:out value="${abonne.dateNaissance}"></c:out></TD>
               <TD><c:out value="${abonne.dateAdhesion}"></c:out></TD>
               <TD><c:out value="${abonne.telephone}"></c:out></TD>
               <TD><c:out value="${abonne.categoriPro}"></c:out></TD>
               
               <td>
               		<form action="ListerServlet" method="post"> 
               			<input type="hidden" name="action" value="supprimer"/>
               			<input type="hidden" name="matricule" value='${abonne.matricule}'/>
               			<input type="submit" value="supprimer"/>
               		</form>
            
               </td>
               
               <td>
               		<form action="ListerServlet" method="post"> 
               			<input type="hidden" name="action" value="modifier"/>
               			<input type="hidden" name="matricule" value='${abonne.matricule}'/>
               			<input type="submit" value="modifier"/>
               		</form>
               </td>
               
              
           </TR>
          		 </c:forEach>
          		 
       </TABLE>
   
</div>

<%@ include file="footer.jsp" %>

</body>
</html>