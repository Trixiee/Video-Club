<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en_US" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/still.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pretraga clana po kategoriji</title>
</head>
<body>

<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("/LibraryWeb/administracija/login.jsp");
	}
%>
	<jsp:useBean id="kategorijeBean" class="beans.GetSveKategorijeBean"
		scope="session"></jsp:useBean>
	
		<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="http://localhost:8080/LibraryWeb/administracija/videoclub.jsp">Video Club</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Clan <span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
					
					<li><a href="/LibraryWeb/unos/SaveClan.jsp">Unos clana</a></li>
					<li><a href="/LibraryWeb/remove/IzbrisiClana.jsp">Izbrisi clana</a></li>
					
					
					<li><a href="/LibraryWeb/pretraga/PretragaClanaPoId.jsp">Pretraga clana po id</a></li>
					<li><a href="/LibraryWeb/pretraga/PretragaClanaZaImePrezime.jsp">Pretraga clana po imenu i prezimenu</a></li>
					<li><a href="/LibraryWeb/pretraga/PretragaPoDatumuUpisaKategoriji.jsp">Pretraga clana po kategoriji i datumu upisa</a></li>
					<li><a href="/LibraryWeb/pretraga/PretragaPoKategoriji.jsp">Pretraga clana po kategoriji </a></li>
					
					
					<li><a href="/LibraryWeb/razduzi/RazduziClanaZaFilm.jsp">Razduzi clana za film</a></li>
					<li><a href="/LibraryWeb/razduzi/RazduziClanaZaSeriju.jsp">Razduzi clana za seriju</a></li>
							
	
					<li><a href="/LibraryWeb/prikaz/PrikazClanova.jsp">Prikaz svih clanova</a></li>	
					<li><a href="/LibraryWeb/prikaz/PrikazZaduzenjaFilmovaZaClana.jsp">Prikaz zaduzenih filmova za clana</a></li>
					
							
				</ul></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Film <span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="/LibraryWeb/unos/UnosFilma.jsp">Unos filma</a></li>
					<li><a href="/LibraryWeb/update/AzurirajFilm.jsp">Azuriraj film</a></li>
					
					
					<li><a href="/LibraryWeb/pretraga/PretragaFilmaPoId.jsp">Pretraga filma po id</a></li>
					<li><a href="/LibraryWeb/pretraga/PretragaFilmaZaNaslov.jsp">Pretraga filma za naslov</a></li>
					
					<li><a href="/LibraryWeb/zaduzenja/ZaduziFilm.jsp">Zaduzi film</a></li>
					
					
					<li><a href="/LibraryWeb/prikaz/PrikazFilmova.jsp">Prikaz svih filmova</a></li>
					<li><a href="/LibraryWeb/prikaz/PrikazZaduzenjaFilmovaZaClana.jsp">Lista zaduzenih filmova za clana</a></li>
					
			</ul></li>


			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Serija <span class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="/LibraryWeb/unos/UnosSerija.jsp">Unos serije</a></li>
					<li><a href="/LibraryWeb/update/AzurirajSeriju.jsp">Azuriraj seriju</a></li>
					
		
					<li><a href="/LibraryWeb/pretraga/PretragaSerijePoId.jsp">Pretraga serije po id</a></li>
					<li><a href="/LibraryWeb/pretraga/PretragaSerijeZaNaslov.jsp">Pretraga serije za naslov</a></li>
					
							
					<li><a href="/LibraryWeb/zaduzenja/ZaduziSeriju.jsp">Zaduzi seriju</a></li>
				
					
					<li><a href="/LibraryWeb/prikaz/PrikazSerija.jsp">Prikaz serija</a></li>
					<li><a href="/LibraryWeb/prikaz/PrikaziZaduzenjaSerije.jsp">Lista zaduzenja serija za clana</a></li>
					
				
				</ul></li>
			 
		</ul>

		<ul class="nav navbar-nav navbar-right">
			  <li><a href="/LibraryWeb/administracija/login.jsp">Prijavi se</a></li>
			 <form id="logoffbuttom" class="navbar-form navbar-right" action="/LibraryWeb/LogOffServlet">
				<li><input id="logoffbutton" type="submit" value="Odjavi se"></li>
   			 </form>
   		</ul>
	</div>
	</nav>
	
	<div class="container">
	
		<form action="/LibraryWeb/GetClanoveZaKategoriju" method="get">
			<div class="form-group">
				<label for="Kategorija">Izaberite kategoriju:</label> 
				</br>
				<td><select name="kategorija">
							<c:forEach var="kat" items="${kategorijeBean.sveKategorije}">
								<option value="${kat.idKategorija}">${kat.nazivKategorije}</option>
							</c:forEach>
				</select></td>	
			</div>
			</br>
			<button type="submit" class="btn btn-default">Prikazi</button>
	
	</div>
</body>
</html>