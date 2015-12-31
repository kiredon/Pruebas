<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MUS - Medicamento</title>

<script
	src="${pageContext.servletContext.contextPath}/js/admin/medicamento.js"
	charset="ISO-8859-1"></script>
</head>
<body>

	<div class="ui stackable grid container">

		<div class="sixteen wide column" ng-controller="medicamentoController">
			<h1>Medicamento</h1>
			<!--Buscador-->

			<div class="ui fluid action input">

				<input name="buscador" type="text" ng-model="nombreMedicamento"
					placeholder="Buscar..." ng-enter="obtenerBusquedaMedicamento(1)">
				<button name="buscadorButton" type="submit" class="ui button"
					ng-click="obtenerBusquedaMedicamento(1)">Buscar</button>
			</div>

			<div class="ui divider"></div>


			<a href="#" id="formulario"
				class="small ui primary formulario button "
				ng-click="insertarMedicamento()"> Agregar nuevo elemento </a>

			<div class="ui checkbox">
				<input type="checkbox" ng-model="mostrarTodos.value"
					ng-change="mostrarTodosChange()" id="mostrarTodosCheck" /> <label
					for="mostrarTodosCheck">Mostrar todos</label>
			</div>

			<table class="ui celled blue striped table">
				<thead>
					<tr>
						<th>Clave Institucional</th>
						<th>Nombre Sustancia Activa</th>
						<th>Nombre Corto</th>
						<th>Nombre Largo</th>
						<th>Reorden</th>
						<th>Minimo</th>
						<th>Maximo</th>
						<th>Activo</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="(key,value) in medicamentoList">
						<td>{{value.claveInstitucional}}</td>
						<td>{{value.nombreSal}}</td>
						<td>{{value.nombreCorto}}</td>
						<td>{{value.nombreLargo}}</td>
						<td>{{value.reorden}}</td>
						<td>{{value.minimo}}</td>
						<td>{{value.maximo}}</td>
						<td>{{value.status ? "Activo":"Inactivo"}}</td>
						<td><a href="#"><i class="unhide icon" title="Ver"
								ng-click="verMedicamento(value)"></i></a> <a href="#"><i
								class="edit icon" title="Editar"
								ng-click="editarMedicamento(value)"></i></a> <a href="#"
							ng-click="borrarMedicamento(value.idMedicamento,value.status,value.nombreCorto)"><i
								class="icon" title="{{value.status ? 'Desactivar':'Activar'}}"
								ng-class="value.status ? 'toggle on icon':'toggle off icon'"></i></a></td>
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

		<div class="ui modal large" id="editarModal"
			ng-controller="editarModalController">

			<i class="close icon"></i>
			<div class="preheader">MOTION UNIT DOSE SYSTEM</div>
			<div class="header">Agregar / Editar Medicamento</div>
			<div class="content" ng-form="formMedicamento">

				<div class="ui form segment">

					<div class="two required fields">
						<div class="field">
							<div class="required field"
								ng-class="validate(formMedicamento.clave) ? 'error':''">
								<label>Clave Institucional </label> <input class="verEditar"
									id="id" placeholder="Clave Institucional" type="text"
									name="clave" ng-model="medicamento.claveInstitucional" required
									maxlength="15"> <span
									ng-show="validate(formMedicamento.clave)"> La clave es
									requerida </span>
							</div>


							<div class="required field">
								<label>Sustancia Activa </label>
								<div class="ui fluid search" id="autocompleteSal">

									<input class="prompt verEditar" type="text" placeholder="Sustancia Activa"
										required ng-model="autocomplete.value" />
									<div class="results"></div>
								</div>
							</div>


							<div class="required field">
								<label>Via de Administración </label> <select
									class="verEditarSelect"
									ng-model="medicamento.idViaAdministracion" required>
									<option ng-repeat="value in viaAdministracionList"
										title="{{value.idViaAdministracion }}"
										ng-selected="{{value.idViaAdministracion == medicamento.idViaAdministracion}}"
										value="{{value.idViaAdministracion}}">{{value.nombreViaAdministracion}}</option>
								</select>
							</div>
							<div class="field">
								<label>Indivisible </label>
								<div>
									<a href="#" ng-click="indivisible()"><i class="icon"
										ng-class="medicamento.indivisible ? 'big toggle on icon':'big toggle off icon'"></i></a>

								</div>
							</div>

							<!-- 							<div class="required field">
								<label>Nombre Sustancia Activa </label> <select id="seleccion"
									class="verEditarSelect" ng-model="medicamento.idCatSal"
									required>
									<option ng-repeat="value in salList" title="{{value.idSal}}"
										ng-selected="{{value.idSal == medicamento.idCatSal}}"
										value="{{value.idSal}}">{{value.nombreSal}}</option>
								</select>
							</div> -->

						</div>
						<div class="field"></div>
						<div class="field">
							<!-- imagen -->
							<input type='file' id="asd" class="verEditarImagen"
								accept="image/x-png, image/gif, image/jpeg"> <img
								id="img" src="" height="210" width="210" />
							<div id="base"></div>
							<!-- cierra la imagen -->
						</div>
					</div>

					<div class="required field"
						ng-class="validate(formMedicamento.nombreCorto) ? 'error':''">
						<label>Nombre corto </label> <input placeholder="Nombre corto"
							class="verEditar" type="text" ng-model="medicamento.nombreCorto"
							required maxlength="249" name="nombreCorto"> <span
							ng-show="validate(formMedicamento.nombreCorto)">El nombre
							corto es requerido </span>
					</div>
					<div class="field"
						ng-class="validate(formMedicamento.nombreLargo) ? 'error':''">
						<label>Nombre largo</label> <input placeholder="Nombre largo"
							class="verEditar" type="text" ng-model="medicamento.nombreLargo"
							maxlength="320" name="nombreLargo">
					</div>

					<div class="two required fields">
						<div class="field"
							ng-class="validate(formMedicamento.concetracion) ? 'error':''">
							<label>Concentracion</label> <input placeholder="Concentracion"
								required class="verEditar" type="text"
								ng-model="medicamento.concentracion" maxlength="50"
								name="concentracion">
						</div>
						<div class="field">
							<label>Unidad Concentracion </label> <select
								class="verEditarSelect"
								ng-model="medicamento.idUnidadConcentracion" required>
								<option ng-repeat="value in unidadConcentracionList"
									title="{{value.idUnidadConcentracion }}"
									ng-selected="{{value.idUnidadConcentracion == medicamento.idUnidadConcentracion}}"
									value="{{value.idUnidadConcentracion}}">{{value.nombreUnidadConcentracion}}</option>
							</select>
						</div>
					</div>

					<div class="field"
						ng-class="validate(formMedicamento.presentacioLaboratorio) ? 'error':''">
						<label>Presentacion laboratorio</label> <input class="verEditar"
							placeholder="Presentacion laboratorio" type="text"
							ng-model="medicamento.presentacionLaboratorio" maxlength="100">
					</div>
					<div class="field"
						ng-class="validate(formMedicamento.laboratorio) ? 'error':''">
						<label>Laboratorio</label> <input placeholder="Laboratorio"
							class="verEditar" type="text" ng-model="medicamento.laboratorio"
							maxlength="50">
					</div>
					<div class="three required fields">
						<div class="field">
							<label>Presentación entrada </label> <select id="seleccion"
								class="verEditarSelect"
								ng-model="medicamento.idCatPresentacionEntrada" required>
								<option ng-repeat="value in presentacionList"
									title="{{value.idPresentacion}}"
									ng-selected="{{value.idPresentacion == medicamento.idCatPresentacionEntrada}}"
									value="{{value.idPresentacion}}">{{value.nombrePresentacion}}</option>
							</select>

						</div>

						<div class="field"
							ng-class="validate(formMedicamento.clave) ? 'error':''">
							<label>Factor de transformación </label> <input class="verEditar"
								placeholder="Factor de transformación" type="number"
								name="clave" ng-model="medicamento.factorTransformacion"
								required> <span
								ng-show="validate(formMedicamento.factorTransformacion)">
								El factor de transforamción es requerido </span>
						</div>


						<div class="field">
							<label>Presentación salida </label> <select id="seleccion"
								class="verEditarSelect"
								ng-model="medicamento.idCatPresentacionSalida" required>
								<option ng-repeat="value in presentacionList"
									title="{{value.idPresentacion}}"
									ng-selected="{{value.idPresentacion == medicamento.idCatPresentacionSalida}}"
									value="{{value.idPresentacion}}">{{value.nombrePresentacion}}</option>
							</select>
						</div>

					</div>
					<div class="three fields">
						<div class=" required field">
							<label>Categoría medicamento </label> <select id="seleccion"
								class="verEditarSelect"
								ng-change="obtenerSubcategoriaMedicamento(medicamento)"
								ng-model="medicamento.idCategoriaMedicamento" required>
								<option ng-repeat="value in categoriaMedicamentoList"
									ng-selected="{{value.idCategoriaMedicamento == medicamento.idCategoriaMedicamento}}"
									value="{{value.idCategoriaMedicamento}}">{{value.nombreCategoriaMedicamento}}</option>
							</select>
						</div>
						<div class="required field">
							<label>Subcategoría medicamento </label> <select id="seleccion"
								class="verEditarSelect"
								ng-model="medicamento.idCatSubcategoriaMedicamento" required>
								<option ng-repeat="value in subcategoriaMedicamentoList"
									title="{{value.idSubcategoriaMedicamento}}"
									ng-selected="{{value.idSubcategoriaMedicamento == medicamento.idCatSubcategoriaMedicamento}}"
									value="{{value.idSubcategoriaMedicamento}}">{{value.nombreSubcategoriaMedicamento}}</option>
							</select>
						</div>
						<div class="field"
							ng-class="validate(formMedicamento.grupo) ? 'error':''">
							<label>Grupo</label> <input placeholder="Grupo" class="verEditar"
								type="text" ng-model="medicamento.grupo" maxlength="50">
						</div>
					</div>
					<div class="three requerid fields">

						<div class="field"
							ng-class="validate(formMedicamento.minimo) ? 'error':''">
							<label>Mínimo</label> <input placeholder="Mínimo" type="number"
								class="verEditar" id="minimo" ng-model="medicamento.minimo">
						</div>
						<div class="field"
							ng-class="validate(formMedicamento.reorden) ? 'error':''">
							<label>Reorden</label> <input placeholder="Reorden" type="number"
								class="verEditar" id="reorden" ng-model="medicamento.reorden">
						</div>
						<div class="field"
							ng-class="validate(formMedicamento.maximo) ? 'error':''">
							<label>Máximo</label> <input placeholder="Máximo" type="number"
								class="verEditar" id="maximo" ng-model="medicamento.maximo">
						</div>
					</div>
					<div class="three fields">
						<div class="disabled field">
							<label>Id</label> <input placeholder="ID" type="text"
								disabled="disabled" ng-model="medicamento.idMedicamento">
						</div>
						<div class="disabled field">
							<label>Fecha Creación</label> {{medicamento.fechaCreacion |
							date:'yyyy-MM-dd HH:mm:ss'}}

						</div>
						<div class="disabled field">
							<label>Fecha Edición</label> {{medicamento.fechaEdicion |
							date:'yyyy-MM-dd HH:mm:ss'}}
						</div>
					</div>

				</div>
				<div class="actions" id="botonGuardar">
					<button class="ui primary button ok"
						ng-disabled="!(validarRangos() == false && formMedicamento.$invalid == false )">Guardar</button>
					<!-- ng-disabled="formMedicamento.$invalid && validarRangos()">Guardar</button> -->
				</div>
			</div>


		</div>

		<div class="ui small test modal">
			<i class="close icon"></i>
			<div class="header">
				<p id="headerActivacion"></p>
			</div>
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
		$(document).ready(function() {
			$('#buscador').keypress(function(e) {
				if (e.keyCode == 13)
					alert("hola");
				//$('#buscadorButton').click();
			});
		});
	</script>
</body>
</html>