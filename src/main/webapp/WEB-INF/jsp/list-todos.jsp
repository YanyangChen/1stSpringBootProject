<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class = "container">
<!-- <form method="post"> -->
<H1>Your todos</H1>
<table class="table table-striped">
	<caption>your todos are</caption>
	<thead>
		<tr>
			<th>Description</th>
			<th>Target date</th>
			<th>Is it done?</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
<!-- 	JSTL for loop -->
<!-- 	for(Item todo : todos) -->
	<c:forEach items = "${todos}" var = "todo">
	
		<tr>
			<td>${todo.desc}</td>
			<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
			<td>${todo.done}</td>
			<td><a type="button" class="btn btn-success" href="/update-todo?id= ${todo.id}">Update</a></td>
			<td><a type="button" class="btn btn-warning" href="/delete-todo?id= ${todo.id}">Delete</a></td>
		</tr>
		</c:forEach>
	
	</tbody>
</table>



<%-- Welcome  ${name} --%>
<!-- Here are the list of your todos 12345 -->
<%-- ${todos} --%>
<!-- <a href="/">Click here</a> to manage your todo list. -->
<!-- </BR> -->


<!-- The href link search for the controller -->
<div><a class="button" href="/add-todo"> Add a todo </a></div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
</div>
<%-- My first JSP!! Welcome ${name} ! --%>

