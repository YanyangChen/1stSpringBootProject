<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class = "container">
<form:form method="post" modelAttribute="todo">
<form:hidden path="id"/>
	<fieldset class="form-group">
	<form:label path="descr">Description :</form:label>
<!-- 	"required" doesn't work in safari -->
	<form:input path="descr" type="text" 
	class="form-control" required="required"/>
	<form:errors path="descr" cssClass="text-warning"></form:errors>
	</fieldset>
	
	<fieldset class="form-group">
	<form:label path="targetDate">Target Date :</form:label>
<!-- 	"required" doesn't work in safari -->
	<form:input path="targetDate" type="text" 
	class="form-control" required="required"/>
	<form:errors path="targetDate" cssClass="text-warning"></form:errors>
	</fieldset>
	
	<fieldset class="form-group">
	<form:label path="done">IS Done :</form:label>
<!-- 	"required" doesn't work in safari -->
	<form:input path="done" type="text" 
	class="form-control" required="required"/>
	<form:errors path="done" cssClass="text-warning"></form:errors>
	</fieldset>
	
	 <button type="submit" class="btn btn-success">Add</button>
</form:form>
</div>
<%@ include file="common/footer.jspf" %>

