<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<title>Car Dealership</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.4/examples/cover/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<!-- Custom styles for this template -->
<link rel="stylesheet" href="styles.css">
</head>


<body class="text-center" style="background-color: gray;">
	<div class="cover-container d-flex w-5 h-5 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand text-white">Joe's Car Dealership</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active text-white" href="/"><button
							type="button" class="btn btn-primary">Home</button></a> <a
						class="nav-link active text-white" href="/inventory"><button
							type="button" class="btn btn-primary">Inventory</button></a> <a
						class="nav-link active text-white" href="/report"><button
							type="button" class="btn btn-primary">Sales Reports</button></a>
				</nav>
			</div>
		</header>
	</div>
	<main>
		<div class="card mx-auto" style="width: 30rem; margin-bottom: 7rem;">
			<img src="${selVeh.picLocation}" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">
					${selVeh.used ? "Used" : "New"}
					<c:out value="${ selVeh.year }" />
					<c:out value="${ selVeh.make }" />
					<c:out value="${ selVeh.model }" />
				</h5>
				<p class="card-text">
					<c:out value="${ selVeh.description }" />
				</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
					<c:choose>
						<c:when test="${selVeh.daysBetween < 120}">
      						Price: <c:out value="${selVeh.price}"/>
        				<br />
						</c:when>
						<c:otherwise>
       						<span style="color:red;text-decoration:line-through">Original Price: <c:out value="${selVeh.price}"/></span> 
       						<br />
       						Now: <c:out value="${selVeh.discountedPrice}"/>
       					 <br />
						</c:otherwise>
					</c:choose>
				</li>
				<li class="list-group-item">Miles: <c:out value="${selVeh.miles}"/></li>
			</ul>
			<div class="card-body">
				<a href="buyer?inventoryId=${selVeh.inventoryId}" class="card-link"><button
							type="button" class="btn btn-primary">Click to buy!!!</button></a> 
			</div>
		</div>
	</main>
</body>

</html>
