<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MUS - Usuario</title>
<script
	src="${pageContext.servletContext.contextPath}/js/admin/usuario.js"></script>
</head>
<body>

	<div class="container-fluid">
	  <div class="row">
		 <div class="col-md-8 col-md-offset-2">
			<h1 class="text-center">Identidad</h1>

			<div class="row">
            	<div class="well">
                	<form class="form-inline">
                      	<div class="form-group">
                        	<label for="exampleInputName2">Buscar Usuario</label>
                        	<input type="text" class="form-control" id="exampleInputName2" placeholder="Buscar">
                      	</div>
                      	<button type="submit" class="btn btn-default">
                        	<span class="glyphicon glyphicon-search" aria-hidden="true"></span> Buscar
                        </button>
                      	<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Crear
                        </button>
                    </form>
                </div>
            
            
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th scope="col">Nombre Completo</th>
							<th scope="col">Usuario</th>
							<th scope="col">Mail</th>
							<th scope="col">&nbsp;</th>
						</tr>
					</thead>
					<tbody>          		
						<tr>
							<td>José Pérez</td>
							<td>jose1</td>
							<td>jose@mail.com</td>
							<td><a href="#" class="btn btn-sm btn-default"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Editar</a> <a href="#" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
						</tr>
						<tr>
							<td>José Pérez</td>
							<td>jose1</td>
							<td>jose@mail.com</td>
							<td><a href="#" class="btn btn-sm btn-default"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Editar</a> <a href="#" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
						</tr>
                        <tr>
							<td>José Pérez</td>
							<td>jose1</td>
							<td>jose@mail.com</td>
							<td><a href="#" class="btn btn-sm btn-default"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Editar</a> <a href="#" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
						</tr>
                        <tr>
							<td>José Pérez</td>
							<td>jose1</td>
							<td>jose@mail.com</td>
							<td><a href="#" class="btn btn-sm btn-default"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Editar</a> <a href="#" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
						</tr>
				 </tbody>
			  </table>
			</div>             
		 </div>
	  </div>
	</div>
</body>
</html>