<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MUS - Diagnóstico</title>

<script
	src="${pageContext.servletContext.contextPath}/js/admin/diagnostico.js"
	charset="ISO-8859-1"></script>
</head>
<body>

	<div class="ui stackable grid container">

		<div class="sixteen wide column" ng-controller="diagnosticoController">
			<h1>Diagnóstico</h1>
			<!--Buscador-->
		
			<div class="ui fluid action input">

				<input  name="buscador" type="text" ng-model="nombreDiagnostico" id="buscador" autofocus 
					placeholder="Buscar..." ng-enter="obtenerBusquedaDiagnostico(1)"><!-- el uno funciona como bandera  -->
				<button name="buscadorButton" type="submit" class="ui button"
					 ng-click="obtenerBusquedaDiagnostico(1)">Buscar</button>
			</div>
			
			<div class="ui divider"></div>
			
		
			<a href="#" id="formulario"
	            class="small ui primary formulario button "
				ng-click="insertarDiagnostico()"> Agregar nuevo elemento </a>
		
			<div class="ui checkbox">
				<input type="checkbox" ng-model="mostrarTodos.value"
					ng-change="mostrarTodosChange()" id="mostrarTodosCheck" /> <label
					for="mostrarTodosCheck">Mostrar todos</label>
			</div>

			<table class="ui celled blue striped table">
				<thead>
					<tr>
						<th>Diagnóstico</th>
						<th>Nombre Cie</th>
						<th>Clave</th>
						<th>Fecha Creación</th>
						<th>Fecha Edición</th>
						<th>Activo</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="(key,value) in diagnosticoList">
						<td>{{value.nombreDiagnostico}}</td>
						<td>{{value.nombreCie}}</td>
						<td>{{value.clave}}</td>
						<td>{{value.fechaCreacion | date:'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{value.fechaEdicion | date:'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{value.status ? "Activo":"Inactivo"}}</td>
						<td><a href="#"><i class="edit icon" title="Editar"
								ng-click="editarDiagnostico(value)"></i></a> <a href="#"
							ng-click="borrarDiagnostico(value.idDiagnostico,value.status,value.nombreDiagnostico)"><i
								class="icon" title="{{value.status ? 'Desactivar':'Activar'}}" title="{{value.status ? 'Desactivar':'Activar'}}"  ng-class="value.status ? 'toggle on icon':'toggle off icon'"></i></a>
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
			<div class="header">Agregar / Editar Diagnóstico</div>
			<div class="content" ng-form="formDiagnostico">

				<div class="ui form segment">

					<div class="one required field">
						<div class="field"
							ng-class="validate(formDiagnostico.nombreDiagnostico) ? 'error':''">
							<label>Diagnóstico </label> <input placeholder="Diagnóstico"
								type="text" name="nombreDiagnostico"
								ng-model="diagnostico.nombreDiagnostico" required maxlength="300">
							<span ng-show="validate(formDiagnostico.nombreDiagnostico)">
								El nombre es requerido </span>
						</div>

					</div>
					<div class="two required fields">
						<div class="one required field">
							<div class="field"
								ng-class="validate(formDiagnostico.claveDiagnostico) ? 'error':''">
								<label>Clave </label> <input placeholder="Clave" type="text"
									ng-model="diagnostico.clave" required maxlength="10"
									name="claveDiagnostico"> <span
									ng-show="validate(formDiagnostico.claveDiagnostico)">La
									clave es requerida </span>
							</div>
						</div>
					
						<div class="one required field"
							ng-class="validate(formDiagnostico.nombreCie) ? 'error':''">
							<label>Nombre Cie </label> <select id="seleccion"
								ng-model="diagnostico.idCie" placeholder="nombre Cie"
								name="nombreCie" required>
								<option ng-repeat="value in cieList" title="{{value.idCie}}"
									ng-selected="{{value.idCie == diagnostico.idCie}}"
									value="{{value.idCie}}">{{value.nombreCie}}</option>
							</select> <span ng-show="validate(formDiagnostico.nombreCie)">En nombre Cie es
								 requerido </span>

						</div>
					</div>
					<div class="three fields">
						<div class="disabled field">
							<label>Id</label> <input placeholder="ID" type="text"
								disabled="disabled" ng-model="diagnostico.idDiagnostico">
						</div>
						<div class="disabled field">
							<label>Fecha Creación</label> {{diagnostico.fechaCreacion |
							date:'yyyy-MM-dd HH:mm:ss'}}

						</div>
						<div class="disabled field">
							<label>Fecha Edición</label> {{diagnostico.fechaEdicion |
							date:'yyyy-MM-dd HH:mm:ss'}}
						</div>
					</div>

				</div>
				<div class="actions">
					<button class="ui primary button ok"
						ng-disabled="formDiagnostico.$invalid">Guardar</button>
				</div>
			</div>


		</div>

		<div class="ui small test modal">
			<i class="close icon"></i>
			<div class="header"><p id="headerActivacion"></p></div>
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
		<script type="text/javascript">
			$(document).ready(function(){
			    $('#buscador').keypress(function(e){
			      if(e.keyCode==13)
			      $('#buscadorButton').click();
			    });
			});
			</script>
</body>
</html>