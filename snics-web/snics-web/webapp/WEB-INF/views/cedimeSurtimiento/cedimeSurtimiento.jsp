<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script
	src="${pageContext.servletContext.contextPath}/js/cedimeSurtimiento/cedimeSurtimientoService.js">
	
</script>
<script
	src="${pageContext.servletContext.contextPath}/js/cedimeSurtimiento/cedimeSurtimientoControllers.js">
	
</script>




<meta charset="utf-8">
<title>Motion Unit-Dose System :: Layout</title>
<meta name="description" content="">
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="mobile-web-app-capable" content="yes">

<!-- build:css styles/vendor.css -->
<!-- bower:css -->




</head>
<body>

	<div class="ui  grid container ng-cloak" ng-controller="cedimeSurtimientoController">
		<div class="ui  grid container ">

			<div class="sixteen wide column">

				<h3>CEDIME - Reabasto de Sub-almacén</h3>

			</div>
			<div class="twelve wide left aligned column">
				<div class="ui breadcrumb">
					<span class="section"
						ng-repeat="(key,value) in surtimientoService.getPathUnidadesPrincipal()">
						{{value.nombreUnidadJerarquica}} <i
						class="right chevron icon divider"></i>
					</span>

				</div>
				<div class="ui small buttons">
					<div class="ui button"
						ng-if="surtimientoService.getPathUnidadesPrincipal().length > 0"
						ng-click="asignarUnidadJerarquica()"
						title="Asignar Unidad Jerarquica">
						<a href="#"><i class="sitemap icon"> </i>Cambiar</a>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="ui sixteen wide column">
					<div class="ui secondary segment">

						<div class="four wide right aligned column">
							<div>
								<strong>Folio: </strong>
								<input type="text"
								 id="buscador"
									autofocus placeholder="folio" 
									ng-model="folioBuscador"
									ng-enter="buscaFolio()">
							</div>
						</div>
					</div>
				</div>
			</div>
			<table class="ui selectable striped table form">
			<caption align="left"><big> <strong>Ordenes Urgentes</strong></big></caption>
				<thead>
					<tr>
						<th>Folio Orden</th>
						<th>Fecha y Hora de solicitud</th>
						<th>Servicio/Área</th>
						<th>Sub-Almacen</th>
						<th>Estatus</th>
						<th>Tipo de Orden<br /></th>
						<th class="collapsing">Detalle</th>

					</tr>
				</thead>
				<tbody>
					<tr
						ng-repeat="(key, value) in surtimientoService.getListaOrdenesUrgentes() |  orderBy:'fecha'">
						<td>
						 	<a href="#" title="Detalles"
							ng-click="detalle(value.idTransferenciaCabecera,value.nombreAlmacenDestino,value.nombreTipoTransferencia,value)">
							{{value.folio}}</a>
						</td>
						<td>{{value.fecha | date:'yyyy-MM-dd'}} {{value.fecha | date:'HH:mm:ss'}}</td>
						<td>{{value.area}}</td>
						<td>{{value.nombreAlmacenDestino}}</td>
						<td>{{value.nombreStatusTransferencia}}</td>
						
						<td>
						<div class="ui red horizontal circular label ng-scope" ng-if="value.idTipoTransferencia==2">Urgente</div>
						<div class="ui blue horizontal circular label ng-scope" ng-if="value.idTipoTransferencia==1">Normal</div>
						</td>
						<td><a href="#" title="Detalles"
							ng-click="detalle(value.idTransferenciaCabecera,value.nombreAlmacenDestino,value.nombreTipoTransferencia,value)"><i
								class="align list icon"></i></a></td>
					</tr>

				</tbody>

				<tfoot class="full-width">

				</tfoot>
			</table>



			<table class="ui selectable striped table form">
				<caption align="left top"><big> <strong>Ordenes Normales</strong></big></caption>
				<thead>
					<tr>
						<th>Folio Orden</th>
						<th>Fecha y Hora de solicitud</th>
						<th>Servicio/Área</th>
						<th>Sub-Almacen</th>
						<th>Estatus</th>
						<th>Tipo de Orden<br /></th>
						<th class="collapsing">Detalle</th>

					</tr>
				</thead>
				<tbody>
					<tr
						ng-repeat="(key, value) in surtimientoService.getListaOrdenesNormales() |  orderBy:'fecha'">
						<td>
						 	<a href="#" title="Detalles"
							ng-click="detalle(value.idTransferenciaCabecera,value.nombreAlmacenDestino,value.nombreTipoTransferencia,value)">
							{{value.folio}}</a>
						</td>
						<td>{{value.fecha | date:'yyyy-MM-dd'}} {{value.fecha | date:'HH:mm:ss'}}</td>
						<td>{{value.area}}</td>
						<td>{{value.nombreAlmacenDestino}}</td>
						<td>{{value.nombreStatusTransferencia}}</td>
						
						<td>
						<div class="ui red horizontal circular label ng-scope" ng-if="value.idTipoTransferencia==2">Urgente</div>
						<div class="ui blue horizontal circular label ng-scope" ng-if="value.idTipoTransferencia==1">Normal</div>
						</td>
						<td><a href="#" title="Detalles"
							ng-click="detalle(value.idTransferenciaCabecera,value.nombreAlmacenDestino,value.nombreTipoTransferencia,value)"><i
								class="align list icon"></i></a></td>
					</tr>

				</tbody>

				<tfoot class="full-width">

				</tfoot>
			</table>





		</div>

	</div>
	<div class="ui  vertical footer segment">
		<div class="ui center aligned container">
			<div class="ui horizontal small divided link list">MotionCorp</div>
		</div>
	</div>





	<!---------------------------------------------------------------
-----------------------------------------------------------------
          Modal Devolución Merma
-----------------------------------------------------------------
----------------------------------------------------------------->
	<div id="devolucion" class="ui large modal ng-cloak">
		<i class="close icon"></i>
		<div class="header">
			Prescripción No. 12346378 <span class="ui circular red label">Urgente</span>
		</div>
		<div class="content">
			<div class="ui segments">
				<div class="ui secondary segment">
					<div class="ui horizontal list">
						<span class="item">Cama <strong>123</strong></span> <span
							class="item"><strong>Nombre del Paciente</strong></span> <span
							class="item">Clave Derechohabiencia <strong>18958031587</strong></span>
						<span class="item">Médico <strong>Dr. Julio
								Gutiérrez</strong></span> <span class="item ">
							<div class="ui breadcrumb">
								<div class="active section">Especialidad</div>
								<i class="right angle icon divider"></i>
								<div class="active section">Área o Servicio</div>
							</div>
						</span>

					</div>
				</div>
			</div>

			<table class="ui selectable striped table">
				<thead>
					<tr>
						<th class="collapsing">Re-surtir</th>
						<th class="collapsing">Motivo</th>
						<th>Clave - Medicamento - Presentación</th>
						<th class="collapsing">Fecha</th>
						<th class="collapsing">Cantidad</th>
						<th class="collapsing">Aceptar como</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>
							<div class="ui toggle checkbox">
								<input type="checkbox" name="public">
							</div>
						</td>
						<td>Egreso</td>
						<td>201600 - KETOCONAZOL TAB. 200 mg</td>
						<td>15/08/2018</td>
						<td>1</td>
						<td><div class="ui buttons">
								<button class="ui button">Devolución</button>
								<div class="or" data-text="o"></div>
								<button class="ui button">Merma</button>
							</div></td>
					</tr>

					<tr>
						<td>
							<div class="ui toggle checkbox">
								<input type="checkbox" name="public">
							</div>
						</td>
						<td>Egreso</td>
						<td>201600 - KETOCONAZOL TAB. 200 mg</td>
						<td>15/08/2018</td>
						<td>1</td>
						<td><div class="ui buttons">
								<button class="ui button">Devolución</button>
								<div class="or" data-text="o"></div>
								<button class="ui button">Merma</button>
							</div></td>
					</tr>

				</tbody>
			</table>
		</div>
		<div class="actions">
			<button class="ui cancel button">Cancelar</button>
			<button class="ui approve blue button">Procesar</button>
		</div>
	</div>
	<!---------------------------------------------------------------
-----------------------------------------------------------------
          Modal Detalle 
-----------------------------------------------------------------
----------------------------------------------------------------->
	<div id="detalle" class="ui fullscreen modal ng-cloak"
		ng-controller="DetalleController">
		<i class="close icon"></i>
		<div class="preheader">MOTION UNIT-DOSE SYSTEM</div>
		<div class="header">CEDIME - Reabasto de Sub-almacén</div>

		<div class="content">
			<div class="ui segment">
				<div class="ui form">
					<div class="row">
						<div class="one wide left floated left aligned column">
							<div class="ui breadcrumb">
								<span class="section"
									ng-repeat="(key,value) in surtimientoService.getPathUnidadesPrincipal()">
									{{value.nombreUnidadJerarquica}} <i
									class="right chevron icon divider"></i>
								</span>
								
							</div>
							<div class="fields">
									<div class="eight wide right floated right aligned  field">
										<label>Sub-Almacen</label> <input type="text"
											value="{{surtimientoService.getTransferenciaCabeceraActual().subalmacen}}"
										readonly>
									</div>
									<div class="eight wide  field">
										<label>Tipo de Orden</label> <input type="text"
											value="{{surtimientoService.getTransferenciaCabeceraActual().tipoOrden}}"
										readonly>
									</div>
								</div>
						</div>


					</div>
				</div>
				<div class="nineteen wide column">

					<table class="ui selectable striped table form">
						<thead>
							<tr>
								<th class="collapsing">Surtir</th>
								<th>Clave</th>
								<th WIDTH="200">Nombre Insumo<br />Terapéutico
								</th>
								<th WIDTH="100">Unidad de Distribución</th>
								<th>Presentación</th>
								<th WIDTH="170">Lote <br /></th>
								<th WIDTH="110">Caducidad</th>
								<th WIDTH="70">Cantidad<br />Solicitada
								</th>
								<th>Cantidad<br />Surtida
								</th>
								<th class="collapsing">Linea<br />Adicional
								</th>

							</tr>
						</thead>
						<tbody>
							<tr
								ng-repeat="(key, value) in surtimientoService.getListaLineas()">
								<td>								
									<div class="ui toggle checkbox">
									
										<input type="checkbox" id="check{{key}}" ng-disabled="surtimientoService.getBotonImprimir()" title="{{value.estadoExtraSurtimiento ? 'Desactivar':'Activar'}}"
										ng-click="value.cantidadSurtida=cambiaSurtida(value.cantidadSurtida)"
										 checked="checked"  ng-model="value.estadoExtraSurtimiento">
										<label for="check{{key}}"></label>
									</div>
								</td>														
								<td>{{value.clave}}</td>
								<td><input type="text" value="{{value.nombrecorto}}"
									disabled="disabled"></td>
								<td><input type="text" value="{{value.presentacion}}"
									disabled="disabled"></td>
								<td><input type="text" value="{{value.unidadDistribucion}}"
									disabled="disabled"></td>
								<td ng-disabled="!(value.estadoExtraSurtimiento)"><select
									ng-disabled="validaLotefinal(value.estadoExtraSurtimiento)"
									ng-click="value.totales=10" ng-model="value.datosMedicamento"
									ng-options="item.lote for item in value.listInventarioVo">
										<option value="" disabled selected>Selecciona lote</option>
										<span class="ui red label"
										ng-if="value.datosMedicamento.existenciasTotales==0">Sin
											existencias en inventario</span>
										<span class="ui red label"
										ng-if="value.datosMedicamento=="">Ingresar el lote</span>
										

								</select>
								<span class="ui red label"
										ng-if="checaInv(value.datosMedicamento)">Selecciona otro lote</span>
								</td>
								<td><input type="text" placeholder="0000-00-00"
									value="{{value.datosMedicamento.caducidad | date:'yyyy-MM-dd'}}"
									disabled="disabled"></td>
								<td><input type="text" value="{{value.cantidadSolicitada}}"
									disabled="disabled"></td>
								<td><input
									ng-disabled="checaLote(value.datosMedicamento.caducidad,value.estadoExtraSurtimiento)"
									type="number" step="1" placeholder="0"
									ng-model="value.cantidadSurtida"> <span
									class="ui red label" ng-if="value.cantidadSurtida%1!=0">Solo
										enteros </span> <span class="ui red label"
									ng-if="value.cantidadSurtida>checaSurtidasTotales(value.idTransferenciaLinea,value.cantidadSolicitada,value.cantidadSurtida,key)">No
										puede sobrepasar cantidad solicitada </span> <span
									class="ui red label"
									ng-if="value.cantidadSurtida==0 || value.cantidadSurtida<0 ">Mínimo
										1 pieza</span> <span class="ui red label"
									ng-if="value.cantidadSurtida>checaExistenciasTotales(value.datosMedicamento.idInventario,value.datosMedicamento.existenciasTotales,value.cantidadSurtida,key)">Lote
										sin piezas suficientes</span></td>


								<td class="right aligned"
									ng-disabled="!(value.estadoExtraSurtimiento)"><a href="#"
									title="Eliminar"><i
										ng-show="validaEliminado(key,value.datosMedicamento.caducidad,value.cantidadSurtida,value.estadoExtraSurtimiento,value)"
										class="trash  icon"
										ng-click="surtimientoService.borrarLinea(value,key)"></i></a> <a
									href="#" title="Agregar Linea"
									ng-show="validaLinea(key,value.datosMedicamento.caducidad,value.cantidadSurtida,value.estadoExtraSurtimiento,value)"
									ng-click="surtimientoService.duplicarLinea(value,key)"><i
										class="add square  icon"></i></a></td>


							</tr>
						</tbody>

						<tfoot class="full-width">
							<tr>
								<th colspan="10" class="right aligned"><a class="ui button"
									ng-click="cancelar()">Cerrar</a> <a class="ui blue button"
									ng-show="validaFinal()" ng-click="surtir()">Aceptar</a> <a
									class="ui blue button"
									ng-show="surtimientoService.getBotonImprimir()"
									ng-click="imprimir()"><i class="print icon"></i>Imprimir</a></th>
							</tr>
						</tfoot>
					</table>
				</div>
				
				
				
				
				
				
			</div>
		</div>
				</div>
		
		<!---------------------------------------------------------------
-----------------------------------------------------------------
          Modal UnidadJerarquica 
-----------------------------------------------------------------
----------------------------------------------------------------->
		<div id="unidadJerarquicaModal" class="ui  modal ng-cloak"
			ng-controller="UnidadJerarquicaController">

			<i class="close icon"></i>
			<div class="preheader">MOTION UNIT DOSE SYSTEM</div>
			<div class="header">Seleccionar Unidad Jerárquica</div>
			<div class="content" ng-form="formAsociarAlmUnidJerarquica">
				<div class="ui form segment">
					<div class="row">
						<div class=" sixteen wide left floated left aligned column">
							<div class="ui breadcrumb">
								<a class="section"
									ng-Repeat="(key,value) in surtimientoService.getPathUnidades()"
									ng-click="actualizarUnidadJerarquica(value.idUnidadJerarquica)">
									{{value.nombreUnidadJerarquica}} <i
									class="right chevron icon divider"></i>
								</a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="seven wide left floated column">
							<h1>{{surtimientoService.getUnidadJerarquica().nombreUnidadJerarquica}}</h1>

							<h3>
								Tipo:
								{{surtimientoService.getUnidadJerarquica().nombreTipoUnidadJerarquica}}
								</h5>

								<h5>Unidades Jerarquicas</h5>

								<div class="ui basic segment">
									<div class="ui list">
										<a class="item"
											ng-Repeat="(key,value) in surtimientoService.getUnidadesHijas()"
											ng-Click="actualizarUnidadJerarquica(value.idUnidadJerarquica)">
											<i class="top aligned right triangle icon"></i>
											{{value.nombreUnidadJerarquica}}
										</a>
									</div>
								</div>
						</div>
					</div>
					<div class="actions">
						<button class="ui approve blue button"
							ng-disabled="(surtimientoService.getPathUnidades().length == 0)"
							ng-click="cambiarUnidadJerarquica()">Aceptar</button>
					</div>
				</div>

			</div>
		</div>
</body>
</html>