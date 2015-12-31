<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MUS - Rol</title>

<script
	src="${pageContext.servletContext.contextPath}/js/admin/rol.js"></script>
</head>
<body>

	<div class="ui stackable grid container">

		<div class="sixteen wide column" ng-controller="rolController">
			<h1>Rol</h1>
			<div class="ui divider"></div>

			<a href="#" id="formulario"
				class="small ui primary formulario button "
				ng-click="insertarRol()"> Agregar nuevo elemento </a>

			<div class="ui checkbox">
				<input type="checkbox" ng-model="mostrarTodos.value"
					ng-change="mostrarTodosChange()" id="mostrarTodosCheck" /> <label
					for="mostrarTodosCheck">Mostrar todos</label>
			</div>

			<table class="ui celled blue striped table">
				<thead>
					<tr>
						<th>Rol</th>
						<th>Activo</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="(key,value) in rolList">
						<td>{{value.nombreRol}}</td>
						<td>{{value.status ? "Activo":"Inactivo"}}</td>
						<td><a href="#"><i class="edit icon" title="Editar"
								ng-click="showme2=true;showme4=true;editarRol(value)"></i></a> <a href="#"
							    ng-click="borrarRol(value.idRol,value.status,value.nombreRol)"><i
								class="icon" title="{{value.status ? 'Desactivar':'Activar'}}"  ng-class="value.status ? 'toggle on icon':'toggle off icon'"></i></a>
						</td>
					</tr>


				</tbody>
			</table>

			<!--Paginación-->
			<div class="ui borderless pagination menu">
				<a class="item" ng-class="prevPageDisabled()" ng-click="prevPage()">
					<i class="left arrow icon"></i>
				</a> <a class="item" ng-repeat="n in range()"
					ng-class="{active: n == currentPage}" ng-click="setPage(n)">{{n}}</a>

				<a class="item" ng-class="nextPageDisabled()" href
					ng-click="nextPage()"> <i class="icon right arrow"></i>
				</a>
			</div>

		</div>

		<div class="ui modal" id="editarModal"
			ng-controller="editarModalController">

			<i class="close icon"></i>
			<div class="preheader">MOTION UNIT DOSE SYSTEM</div>
			<div class="header">Agregar / Editar Rol</div>
			<div class="content" ng-form="formRol" ng-model="seleccion" >
				
				<div class="ui form segment">
					<div class="two  fields">
						<div class="required field"
							ng-class="validate(formRol.nombreRol) ? 'error':''">
							<label>Rol </label> <input placeholder="Rol"
								type="text" name="nombreRol"
								ng-enter="showme=true"							
								ng-model="rol.nombreRol" required maxlength="50">
							<span ng-show="validate(formRol.nombreRol)">
								El nombre es requerido </span>	
						</div>
						</div>
							<table class="ui celled blue striped table">
								<thead>
									<tr>
										<th>Permiso</th>
										<th>Descripción</th>
										<th>Acciones</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="(key,value) in permisoList">
										<td>{{value.nombrePermiso}}</td>
										<td>{{value.descripcion}}</td>
										<td>
										<a href="#"
							    			ng-click="modificarLinkRol(value.idPermiso,value.status)"><i
											class="icon" title="{{value.status ? 'Desactivar':'Activar'}}"  ng-class="value.status ? 'toggle on icon':'toggle off icon'"></i></a>
										</td>
									</tr>
								</tbody>
							</table>
	
										
						
					
				
					<div class="three fields">
						<div class="disabled field">
							<label>Id</label> <input placeholder="ID" type="text"
								disabled="disabled" ng-model="rol.idRol">
						</div>
						
					
						
						
					</div>

				</div>
			
				<div class="actions">
					<button class="ui primary button ok"ng-disabled="formRol.$invalid"
										ng-click="imprime()"> Guardar</button>
						
				</div>
			</div>


		</div>

		<div class="ui small test modal" >
			<i class="close icon"></i>
			<div class="header">Desactivar Rol</div>
			<div class="content">
				<p id="mensajeActivacion"></p>
			</div>
			<div class="actions">
				<div class="ui negative button">No</div>
				<div class="ui positive right labeled icon button">
					Si <i class="checkmark icon"></i>
				</div>
			</div>
		</div>



	</div>
</body>
</html>