<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MUS - Almacén</title>

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/search.min.css">

<script
	src="${pageContext.servletContext.contextPath}/js/admin/almacen.js"
	charset="ISO-8859-1"></script>


<script
	src="${pageContext.servletContext.contextPath}/js/search.min.js"
	charset="ISO-8859-1"></script>

</head>
<body>



	<div class="ui stackable grid container ng-cloak" ng-controller="almacen">

		<div class="row">
			<div class=" sixteen wide left floated left aligned column">

				<div class="ui breadcrumb">
					<a class="section" ng-Repeat="(key,value) in pathAlmacen"
						ng-Click="cambiarAlmacenActual(value)">{{value.nombreAlmacen}}
						<i class="right chevron icon divider"></i>
					</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="eight wide left floated column">


				<h1>{{almacenActual.nombreAlmacen}}</h1>

				<h3 ng-show="almacenActual.nombreUnidadJerarquica.length">Unidad Jerárquica: {{almacenActual.nombreUnidadJerarquica}}</h5>
				
				<p>Estado: {{almacenActual.status ? 'Activo':'Inactivo'}}</p>



				<div class="ui small buttons">
					<div class="ui  button" ng-click="editarAlmacen()" title="Editar almacén">
						<a href="#"><i class="edit icon" ></i>Editar</a>
					</div>
					<div class="ui button" ng-click="agregarAlmacenMedicamento()" title="Puntos de Control">
						<a href="#"><i class="lab icon"> </i>Puntos de Control</a>
					</div>
					
					<div class="ui button" ng-click="eliminar()" title="{{almacenActual.status ? 'Desactivar almacén':'Activar almacén'}}">
						<a href="#"><i class="toggle icon" ng-class="almacenActual.status ? 'on':'off'">
						</i>{{almacenActual.status ? 'Desactivar':'Activar'}} </a>
					</div>
					
					<div class="ui button" ng-click="asignarUnidadJerarquica(almacenActual)" title="Asignar Unidad Jerárquica">
						<a href="#"><i class="sitemap icon">  </i>Asignar</a>
					</div>
				</div>

				<h5>Almacenes</h5>

				<div class="ui button" ng-click="agregarAlmacen()">
					<a href="#"><i class="add square icon"> </i>Agregar Almacén </a>
				</div>
				<div class="ui checkbox">
					<input type="checkbox" ng-model="mostrarTodos.value"
						ng-change="mostrarTodosChange()" id="mostrarTodosCheck" /> <label
						for="mostrarTodosCheck">Mostrar todos</label>
				</div>

				<div class="ui basic segment" ng-Show="almacenesHijos.length">

					<div class="ui list">
						<a class="item" ng-Repeat="(key,value) in almacenesHijos"
							ng-Click="cambiarAlmacenActual(value)"> <i
							class="top aligned right triangle icon"></i>


							<div class="content">
								<div class="description">{{value.nombreAlmacen}}
								</div>
							</div>
						</a>


					</div>
				</div>


			</div>
  
			<div class="eight wide column" ng-show="almacenMedicamento.length">
				<h3 >Medicamentos</h3>
				<div class="ui three cards">
					<div class="card" ng-repeat="(key, value) in almacenMedicamento">
						<div class="content">
							<div class="header">
								<i class="lab icon"> </i>{{value.medicamentoVo.nombreCorto}}
							</div>
							<div class="description">
								<p>Mínimo: {{value.minimo}}</p>
								<p>Máximo: {{value.maximo}}</p>
								<p>Reorden: {{value.reorden}}</p>
							</div>
						</div>
						<div class="extra content">
				  			<span class="right floated like" ng-click="editarAlmacenMedicamento(value)"> <a href="#"><i class="edit icon" title="Editar Punto de control"></i></span></a>  
							<span class="right floated like" ng-click="eliminarAlmacenMed(value)"> <a href="#"><i class="trash icon" title="Eliminar Punto de control"></i></span> </a>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>

	
	<div class="ui modal" id="editarModalAlmacen"
		ng-controller="editarModalAlmacenController">

		<i class="close icon"></i>
		<div class="preheader">MOTION UNIT DOSE SYSTEM</div>
		<div class="header">Agregar / Editar Almacén</div>
		<div class="content" ng-form="formAlmacen">

			<div class="ui form segment">

				<div class="two required fields">
					  
					<div class="field"
						ng-class="validate(formAlmacen.nombreAlmacen) ? 'error':''">
						<label>Nombre del almacén</label> <input
							placeholder="Nombre del almacén" type="text" name="nombreAlmacen"
							ng-model="almacen.nombreAlmacen" required
							maxlength="50"> <span
							ng-show="validate(formAlmacen.nombreAlmacen)"> El nombre del almacén es requerido </span>
					</div>
					<div class="field">
						<label>Tipo de Almacén </label> <select class="ui dropdown"
							name="selectTipoAlmacen"
							ng-options="tipo as tipo.nombreTipoAlmacen for tipo in tiposAlmacenes track by tipo.idTipoAlmacen"
							ng-model="selectedTipo" required ng-change="changeTipo()" >
						</select>
					</div>
					
					
				</div>
				<div class="field">
					<div class="ui checkbox">
						<input type="checkbox" ng-model="almacen.transferenciaAutomatica"
							ng-change="transferenciaAutomaticaChange()" id="transferenciaAutomaticaCheck" /> <label
							for="transferenciaAutomaticaCheck">Transferencia Automática</label>
					</div>
					</div>
				<div class="two fields">
					<div class="disabled field">
						<label>Id Almacén</label> <input placeholder="Id Almacén" type="text"
							disabled="disabled"
							ng-model="almacen.idAlmacen">
					</div>
					<div class="disabled field">
						<label>Id Almacén Padre</label> <input placeholder="Id Almacén Padre" type="text"
							disabled="disabled"
							ng-model="almacen.idAlmacenPadre">
					</div>
				</div>

			</div>
			<div class="actions">
				<button class="ui primary button ok"
					ng-disabled="formAlmacen.$invalid">Guardar</button>
			</div>
		</div>


	</div>  


	   
	<div class="ui modal" id="editarModalAlmacenMedicamento"
		ng-controller="editarModalAlmacenMedicamentoController">

		<i class="close icon"></i>
		<div class="preheader">MOTION UNIT DOSE SYSTEM</div>
		<div class="header">Agregar / Editar Puntos de Control de Inventario</div>
		<div class="content" ng-form="formAlmacenMedicamento">

			<div class="ui form segment">



			<div class="required field">
			<div class="ui search" id="autocompleteMedicamento">
  				<input class="prompt" type="text" placeholder="Medicamento" ng-model="autocomplete.value" ng-disabled="almacenMedicamento.idMedicamento!=0">
  				<div class="results"></div>
			</div>
			
			</div>


				<div class="three required fields">
					<div class="field"
						ng-class="validate(formAlmacenMedicamento.minimo) ? 'error':''">
						<label>Mínimo: </label> <input placeholder="mínimo" type="number" name="minimo" id="minimo"
							ng-model="almacenMedicamento.minimo">
					</div>
					
					
					<div class="field"
						ng-class="validate(formAlmacenMedicamento.reorden) ? 'error':''">
						<label>Reorden </label> <input placeholder="Reorden" type="number" name="reorden" id="reorden"
							ng-model="almacenMedicamento.reorden">
					</div>
					
					<div class="field"
						ng-class="validate(formAlmacenMedicamento.maximo) ? 'error':''">
						<label>Máximo </label> <input placeholder="Máximo" type="number" name="maximo" id="maximo"
							ng-model="almacenMedicamento.maximo">
					</div>
					
					</div>
				<div class="three fields">
					<div class="disabled field">
						<label>IdMedicamento</label> <input placeholder="ID" type="text"
							disabled="disabled" id="idMedicamento" ng-model="almacenMedicamento.idMedicamento">
					</div>
					<div class="disabled field">
						<label>IdAlmacén</label> <input placeholder="ID" type="text"
							disabled="disabled" ng-model="almacenMedicamento.idAlmacen">
					</div>
				</div>

			</div>
			<div class="actions">
				<button class="ui primary button ok"
					ng-disabled="!(validarRangos() == false && formAlmacenMedicamento.$invalid == false)">Guardar</button>
			</div>
		</div>


	</div> 


	<div class="ui modal" id="asociarUnidadJerarquicaAlmacenModal" ng-controller="asociarUnidadJerarquicaAlmacenModalController">

		<i class="close icon" ></i>
		<div class="preheader">MOTION UNIT DOSE SYSTEM</div>
		<div class="header">Asignar Unidad Jerárquica a Almacén</div>
		<div class="content" ng-form="formAsociarAlmUnidJerarquica">
			<div class="ui form segment">
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

						<h3>
							Tipo: {{unidadActual.nombreTipoUnidadJerarquica}}
							</h5>

							<h5>Unidades Jerarquicas</h5>

							<div class="ui basic segment" ng-Show="unidadesHijas.length">
								<div class="ui list">
									<a class="item" ng-Repeat="(key,value) in unidadesHijas"
										ng-Click="cambiarUnidadActual(value)"> <i
										class="top aligned right triangle icon"></i>
										{{value.nombreUnidadJerarquica}}
									</a>
								</div>
							</div>
					</div>
				</div>
				<div class="actions">
					<button class="ui primary button ok"
						ng-disabled="(pathUnidades.length == 0)">Asociar</button>
				</div>
			</div>

		</div>
	</div>


	<div class="ui small test modal">
		<i class="close icon"></i>
		<div class="header">Almacén</div>
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

	<div class="ui small test modal" id="EliminarAlmacenMedicamento">
		<i class="close icon"></i>
		<div class="header">Medicamento</div>
		<div class="content">
			<p id="mensajeEliminar"></p>
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