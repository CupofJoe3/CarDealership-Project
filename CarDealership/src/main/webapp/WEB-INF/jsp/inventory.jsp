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


<body class="text-center" style="background-color: gray">
	<div class="cover-container d-flex w-5 h-5 p-3 mx-auto flex-column ">
		<header class="masthead mb-auto" style="color: white">
			<div class="inner">
				<h3 class="masthead-brand">Joe's Car Dealership</h3>
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
	<main class="container">
		<div class="row row-cols-2 row-cols-md-3 g-4" style="margin: 3rem;">
			<c:forEach items="${ vehInv }" var="vehicle">
				<div class="card m-2 d-flex mx-auto">
					<img src="${vehicle.picLocation}" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">
						${vehicle.used ? "Used" : "New"}
						<%-- <c:set var="Used" value="${vehicle.used}"/>
						<c:choose>
						<c:when test="${Used == 'true'}">
      						Used 
        				<br />
						</c:when>
						<c:otherwise>
       							New
       					 <br />
						</c:otherwise>
					</c:choose> --%>
							<c:out value="${ vehicle.year }" />
							<c:out value="${ vehicle.make }" />
							<c:out value="${ vehicle.model }" />
						</h5>
						<%-- 		<p class="card-text">Description: <c:out value="${ vehicle.description }"/></p>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Price: 
					
					</li>
					<li class="list-group-item">A second item</li>
					<li class="list-group-item">A third item</li>
				</ul>
				<div class="card-body"> --%>
						<a
							href="details?inventoryId=${vehicle.inventoryId}"
							class="card-link "><button class="btn btn-primary btn-md">Details</button></a>
					</div>
				</div>

			</c:forEach>

		</div>
	</main>
</body>

</html>
