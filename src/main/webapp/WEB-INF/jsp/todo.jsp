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
<form method="post" >
	<fieldset class="form-group">
	<label>Description :</label>
<!-- 	"required" doesn't work in safari -->
	<input name="desc" type="text" 
	class="form-control" required="required"></input>
	
	</fieldset>
	
	 <button type="submit" class="btn btn-success">Add</button>
</form>
</div>
<%-- My first JSP!! Welcome ${name} ! --%>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
