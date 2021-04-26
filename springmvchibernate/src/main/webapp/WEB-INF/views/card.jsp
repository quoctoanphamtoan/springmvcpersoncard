<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<title>Card</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>List card ${namePerson}</h1>

		<div class="row">
			<div class="col-9">
				<table class="table">
					<thead>
						<tr>
							<th>Number</th>
							<th>Type</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listCard}" var="item">
							<tr>
								<td>${item.getNumber() }</td>
								<td>${item.getType() }</td>
								<td> 
									<a href="editCard/${item.getId()}/${personId}" class="btn btn-success"
									role="button">Edit</a> <a href="deletecard/${item.getId()}/${personId}" class="btn btn-danger"
									role="button">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="col-3">
			
			
			<form action="addcard/${personId}" method="post"> 
			<div class="form-group">
				<label for="">Number: </label> <input type="text"
					class="form-control" name="Number" aria-describedby="helpId"
					placeholder="">
			</div>
			<div class="form-group">
				<label for="">Type: </label> <input type="text"
					class="form-control" name="Type" aria-describedby="helpId"
					placeholder="">
			</div>
			 
			<button type="submit" class="btn btn-primary">Add Card</button>
					<a href="home" class="btn btn-info" role="button">Back</a>
				</form>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>


