<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<form:form method="POST" action="/buyer" modelAttribute="buyer">
				<div class="card-body"></div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item"><h5 class="card-title">
					${buyer.car.used ? "Used" : "New"}
					<c:out value="${ buyer.car.year }" />
					<c:out value="${ buyer.car.make }" />
					<c:out value="${ buyer.car.model }" />
				</h5></li>
					<li class="list-group-item"><div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">First Name</span>
							<form:input type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" path="firstName"/>
						</div></li>
					<li class="list-group-item"><div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">Last Name</span>
							<form:input type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" path="lastName"/>
						</div></li>
					<li class="list-group-item"><div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">Email</span>
							<form:input type="text" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" path="email"/>
						</div></li>
					<li class="list-group-item"><div class="input-group mb-3">
							<span class="input-group-text" id="inputGroup-sizing-default">Purchase Price</span>
							<form:input type="text" placeholder="${buyer.car.price}" class="form-control"
								aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-default" path="cost"/>
						</div></li>
				</ul>
				<div class="card-body">
				<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form:form>
		</div>
	</main>
</body>

</html>
