<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MUS - Escolaridad</title>

<script
	src="${pageContext.servletContext.contextPath}/js/admin/escolaridad.js"></script>
</head>
<body>

	<div class="ui stackable grid container">

		<div class="sixteen wide column" ng-controller="escolaridadController">
			<h1>Escolaridad</h1>
			<div class="ui divider"></div>

			<a href="#" id="formulario"
				class="small ui primary formulario button "
				ng-click="insertarEscolaridad()"> Agregar nuevo elemento </a>

			<div class="ui checkbox">
				<input type="checkbox" ng-model="mostrarTodos.value"
					ng-change="mostrarTodosChange()" id="mostrarTodosCheck" /> <label
					for="mostrarTodosCheck">Mostrar todos</label>
			</div>

			<table class="ui celled blue striped table">
				<thead>
					<tr >
						<th>Escolaridad</th>
						<th>Fecha Creaci�n</th>
						<th>Fecha Edici�n</th>
						<th>Activo</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="(key,value) in escolaridadList">
						<td>{{value.nombreEscolaridad}}</td>

						<td>{{value.fechaCreacion | date:'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{value.fechaEdicion | date:'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{value.status ? "Activo":"Inactivo"}}</td>
						<td><a href="#"><i class="edit icon" title="Editar"
								ng-click="editarEscolaridad(value)"></i></a> <a href="#"
							ng-click="borrarEscolaridad(value.idEscolaridad,value.status,value.nombreEscolaridad)"><i
								class="icon" title="{{value.status ? 'Desactivar':'Activar'}}" title="{{value.status ? 'Desactivar':'Activar'}}" ng-class="value.status ? 'toggle on icon':'toggle off icon'"></i></a>
						</td>
					</tr>


				</tbody>
			</table>

			<!--Paginaci�n-->
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
			<div class="header">Agregar / Editar Escolaridad</div>
			<div class="content" ng-form="formEscolaridad">

				<div class="ui form segment">

					<div class="one required field">
						<div class="field"
							ng-class="validate(formEscolaridad.nombreEscolaridad) ? 'error':''">
							<label>Escolaridad </label> <input placeholder="Escolaridad" id="nombre"
								type="text" name="nombreEscolaridad" ng-enter="clickBoton()"
								ng-model="escolaridad.nombreEscolaridad" required maxlength="50">
							<span ng-show="validate(formEscolaridad.nombreEscolaridad)">
								El nombre es requerido </span>
						</div>
					</div>
					<div class="three fields">
						<div class="disabled field">
							<label>Id</label> <input placeholder="ID" type="text"
								disabled="disabled" ng-model="escolaridad.idEscolaridad">
						</div>
						<div class="disabled field">
							<label>Fecha Creaci�n</label> {{escolaridad.fechaCreacion |
							date:'yyyy-MM-dd HH:mm:ss'}}

						</div>
						<div class="disabled field">
							<label>Fecha Edici�n</label> {{escolaridad.fechaEdicion |
							date:'yyyy-MM-dd HH:mm:ss'}}
						</div>
					</div>
				</div>
				<div class="actions">
					<button class="ui primary button ok" id="submit"
						ng-disabled="formEscolaridad.$invalid">Guardar</button>
				</div>
			</div>


		</div>

		<div class="ui small test modal" ng-enter="clickBotonDesactiva()">
			<i class="close icon"></i>
			<div class="header"><p id="headerActivacion"></p></div>
			<div class="content">
				<p id="mensajeActivacion"></p>
			</div>
			<div class="actions" >
				<div class="ui negative button">No</div>
				<div class="ui positive right labeled icon button"  >
					Si <i class="checkmark icon"></i>
				</div>
			</div>
		</div>



	</div>
</body>
</html>