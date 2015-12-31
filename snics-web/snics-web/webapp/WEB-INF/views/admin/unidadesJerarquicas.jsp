<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MUS - Unidades Jerárquicas</title>

<script
	src="${pageContext.servletContext.contextPath}/js/admin/unidadesJerarquicas.js"
	charset="ISO-8859-1"></script>

</head>
<body>



	<div class="ui stackable grid container ng-cloak" ng-controller="unidadesJerarquicas">

		<div class="row">
			<div class=" sixteen wide left floated left aligned column">

				<div class="ui breadcrumb">
					<a class="section" ng-Repeat="(key,value) in pathUnidades"
						ng-Click="cambiarUnidadActual(value)">{{value.nombreUnidadJerarquica}}
						<i class="right chevron icon divider"></i>
					</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="seven wide left floated column">


				<h1>{{unidadActual.nombreUnidadJerarquica}}</h1>

				<h3>Tipo: {{unidadActual.nombreTipoUnidadJerarquica}}</h5>
				
				<p>Estado: {{unidadActual.status ? 'Activo':'Inactivo'}}</p>

				<p>No. de camas: {{unidadActual.noCamas}}</p>


				<div class="ui buttons">
					<div class="ui button" ng-click="editarUnidadJerarquica()">
						<i class="edit icon"></i>Editar
					</div>
					<div class="ui button" ng-click="agregarCama()">
						<i class="bed icon"> </i>Agregar Cama
					</div>
					<div class="ui button" ng-click="eliminar()">
						<i class="toggle icon" title="{{value.status ? 'Desactivar':'Activar'}}" ng-class="unidadActual.status ? 'on':'off'">
						</i>{{unidadActual.status ? 'Desactivar':'Activar'}}
					</div>
				</div>

				<h5>Unidades Jerarquicas</h5>

				<div class="ui button" ng-click="agregarUnidad()">
					<i class="add square icon"> </i>Agregar Unidad
				</div>
				<div class="ui checkbox">
					<input type="checkbox" ng-model="mostrarTodos.value"
						ng-change="mostrarTodosChange()" id="mostrarTodosCheck" /> <label
						for="mostrarTodosCheck">Mostrar todos</label>
				</div>

				<div class="ui basic segment" ng-Show="unidadesHijas.length">

					<div class="ui list">
						<a class="item" ng-Repeat="(key,value) in unidadesHijas"
							ng-Click="cambiarUnidadActual(value)"> <i
							class="top aligned right triangle icon"></i>


							<div class="content">
								<div class="description">{{value.nombreUnidadJerarquica}}
								</div>
							</div>
						</a>


					</div>
				</div>


			</div>

			<div class="nine wide column">
				<h1 ng-show="camas.length">Camas</h1>
				<div class="ui divider"></div>
				
				
				<div class="ui three cards" >
					<div class="card" ng-repeat="(key, cama) in camas">
						<div class="content">
							<div class="header">
								<i class="bed icon"> </i>{{cama.nombreCama}}
							</div>
							<div class="description">
								<p>Tipo: {{cama.nombreTipoCama}}</p>
								<p>Ubicación: {{cama.ubicacionCama}}</p>
								<p>Estado: {{cama.nombreStatusCama}}</p>
							</div>
						</div>
						<div class="extra content">
							<span class="right floated like" ng-click="editarCama(cama)"> <i class="edit icon" title="Editar Cama"></i>
								
							</span> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="ui modal" id="editarModalUnidad"
		ng-controller="editarModalUnidadController">

		<i class="close icon"></i>
		<div class="preheader">MOTION UNIT DOSE SYSTEM</div>
		<div class="header">Agregar / Editar Unidad Jerárquica</div>
		<div class="content" ng-form="formUnidad">

			<div class="ui form segment">

				<div class="two required fields">
					<div class="field"
						ng-class="validate(formUnidad.nombreUnidad) ? 'error':''">
						<label>Nombre de Unidad</label> <input
							placeholder="Unidad Jerárquica" type="text" name="nombreUnidad"
							ng-model="unidadJerarquica.nombreUnidadJerarquica" required
							maxlength="50"> <span
							ng-show="validate(formUnidad.nombreUnidad)"> El nombre es
							requerido </span>
					</div>
					<div class="field"
						ng-class="validate(formUnidad.selectTipoUnidad) ? 'error':''">
						<label>Tipo de Unidad </label> <select class="ui dropdown"
							name="selectTipoUnidad"
							ng-options="tipo as tipo.nombreTipoUnidadJerarquica for tipo in tiposUnidades track by tipo.idTipoUnidadJerarquica"
							ng-model="selectedTipo" ng-change="changeTipo()" ng-selected=""
							required>
						</select>
					</div>

				</div>
				<div class="three fields">
					<div class="disabled field">
						<label>Id</label> <input placeholder="ID" type="text"
							disabled="disabled"
							ng-model="unidadJerarquica.idUnidadJerarquica">
					</div>
					<div class="disabled field">
						<label>Fecha Creación</label> {{unidadJerarquica.fechaCreacion |
						date:'yyyy-MM-dd HH:mm:ss'}}

					</div>
					<div class="disabled field">
						<label>Fecha Edición</label> {{unidadJerarquica.fechaEdicion |
						date:'yyyy-MM-dd HH:mm:ss'}}
					</div>
				</div>

			</div>
			<div class="actions">
				<button class="ui primary button ok"
					ng-disabled="formUnidad.$invalid">Guardar</button>
			</div>
		</div>


	</div>



	<div class="ui modal" id="editarModalCama"
		ng-controller="editarModalCamaController">

		<i class="close icon"></i>
		<div class="preheader">MOTION UNIT DOSE SYSTEM</div>
		<div class="header">Agregar / Editar Cama</div>
		<div class="content" ng-form="formCama">

			<div class="ui form segment">

				<div class="two required fields">
					<div class="field"
						ng-class="validate(formCama.nombreCama) ? 'error':''">
						<label>Nombre Cama: </label> <input placeholder="Nombre"
							type="text" name="nombreCama"
							ng-model="cama.nombreCama" required maxlength="50">
						<span ng-show="validate(formCama.nombreCama)">
							El nombre es requerido </span>
					</div>
					
					<div class="field"
						ng-class="validate(formCama.ubicacionCama) ? 'error':''">
						<label>Ubicación </label> <input placeholder="Ubicación"
							type="text" name="ubicacionCama"
							ng-model="cama.ubicacionCama" required maxlength="50">
						<span ng-show="validate(formCama.ubicacionCama)">
							La ubicación es requerida </span>
					</div>
					
					
					</div>
					<div class="two required fields">
					
					
					<div class="field"
						ng-class="validate(formCama.selectTipoCama) ? 'error':''">
						<label>Tipo de Cama </label> <select class="ui dropdown"
							name="selectTipoCama"
							ng-options="tipoCama as tipoCama.nombreTipoCama for tipoCama in tiposCama track by tipoCama.idTipoCama"
							ng-model="selectedTipoCama" ng-change="changeTipoCama()" ng-selected=""
							required>
						</select>
					</div>
					
					<div class="field"
						ng-class="validate(formCama.selectStatusCama) ? 'error':''">
						<label>Estado de la cama </label> <select class="ui dropdown"
							name="selectStatusCama"
							ng-options="statusCama as statusCama.nombreStatusCama for statusCama in statusCama track by statusCama.idStatusCama"
							ng-model="selectedStatusCama" ng-change="changeStatusCama()" ng-selected=""
							required>
						</select>
					</div>
					
				</div>
				<div class="three fields">
					<div class="disabled field">
						<label>Id</label> <input placeholder="ID" type="text"
							disabled="disabled" ng-model="cama.idCama">
					</div>
					<div class="disabled field">
						<label>Fecha Creación</label> {{cama.fechaCreacion |
						date:'yyyy-MM-dd HH:mm:ss'}}

					</div>
					<div class="disabled field">
						<label>Fecha Edición</label> {{cama.fechaEdicion |
						date:'yyyy-MM-dd HH:mm:ss'}}
					</div>
				</div>

			</div>
			<div class="actions">
				<button class="ui primary button ok"
					ng-disabled="formCama.$invalid">Guardar</button>
			</div>
		</div>


	</div>


	<div class="ui small test modal">
		<i class="close icon"></i>
		<div class="header">Unidad Jerárquica</div>
		<div class="content">
			<p id="mensajeActivar"></p>
		</div>
		<div class="actions">
			<div class="ui negative button">No</div>
			<div class="ui positive right labeled icon button">
				Si <i class="checkmark icon"></i>
			</div>
		</div>
	</div>


</body>
</html>