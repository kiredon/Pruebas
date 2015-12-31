<%@  page import="java.io.*,java.util.*" language="java"
	contentType="text/html;                      
charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Administración Cedime</title>
</head>
<body>


<div class="ui stackable grid container">
		<div class="row">
			<div class="five wide column">
				<div class="ui relaxed divided list">
					<div class="item">
						<i class="huge horizontally flipped shipping middle aligned icon"></i>
						<div class="content">
							<a class="header"><a
								href="${pageContext.servletContext.contextPath}/pages/views/cedimeSurtimiento.do">Surtimiento</a>
								<div class="description">Surtimiento de ordenes de reabasto de Sub-almacenes</div>
						</div>
					</div>
					<div class="item">
						<i class="huge shipping middle aligned icon"></i>
						<div class="content">
							<a class="header"><a
								href="${pageContext.servletContext.contextPath}/pages/views/cedimeDevolucion.do">Devolucion</a>
								<div class="description">Devoluciones desde Sub-almacenes</div>
						</div>
					</div>
				</div>
					
			</div>
		</div>
</div>
</body>
</html>