<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>
Add a todo page
</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>

<div class = "container">
<form:form method="post" modelAttribute="todo">
<form:hidden path="id"/>
	<fieldset class="form-group">
	<form:label path="desc">Description :</form:label>
<!-- 	"required" doesn't work in safari -->
	<form:input path="desc" type="text" 
	class="form-control" required="required"/>
	<form:errors path="desc" cssClass="text-warning"></form:errors>
	</fieldset>
	
	<fieldset class="form-group">
	<form:label path="targetDate">Target Date :</form:label>
<!-- 	"required" doesn't work in safari -->
	<form:input path="targetDate" type="text" 
	class="form-control" required="required"/>
	<form:errors path="targetDate" cssClass="text-warning"></form:errors>
	</fieldset>
	
	 <button type="submit" class="btn btn-success">Add</button>
</form:form>
</div>
<%-- My first JSP!! Welcome ${name} ! --%>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
</body>
</html>
