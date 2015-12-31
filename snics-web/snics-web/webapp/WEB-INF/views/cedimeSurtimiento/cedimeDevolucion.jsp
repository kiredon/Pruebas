<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script
	src="${pageContext.servletContext.contextPath}/js/cedimeSurtimiento/cedimeDevolucionController.js">
	
</script>
<script
	src="${pageContext.servletContext.contextPath}/js/cedimeSurtimiento/cedimeDevolucionService.js">
	
</script>

<meta charset="utf-8">
<title>Motion Unit-Dose System :: Layout</title>
<meta name="description" content="">
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="mobile-web-app-capable" content="yes">
</head>
<body>
	<div ng-controller="cedimeDevolucionController">
		<div class="ui  grid container ng-cloak">

			<!--Barra de opciones-->
			<div class="sixteen wide column">
				<h3>Devoluciones o Mermas de Gabinetes (Sub-Almacenes) a CEDIME
				</h3>
			</div>
			<div class="twelve wide left aligned column">
				<div class="ui breadcrumb">
					<span class="section"
						ng-repeat="(key,value) in devolucionService.getPathUnidadesPrincipal()">
						{{value.nombreUnidadJerarquica}} <i
						class="right chevron icon divider"></i>
					</span>

				</div>
				<div class="ui small buttons">
					<div class="ui button"
						ng-if="devolucionService.getPathUnidadesPrincipal().length > 0"
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
							<strong>Folio:<input type="text" id="buscador" autofocus
								placeholder="folio" ng-model="folioBuscador"
								ng-enter="buscaFolio()"></strong>
						</div>
					</div>
				</div>
			</div>





				<!--resultados de la búsqueda-->

			<table class="ui selectable striped table form">
					<thead>
						<tr>
							<th>Folio de Devolución</th>
							<th>Fecha de Devolución</th>
							<th>Hora de Devolución</th>
							<th>Servicio/Área</th>
							<th>Sub-Almacen</th>
							<th>Estatus</th>
							<th>Motivo de Devolución</th>
							<th class="collapsing">Detalle</th>

						</tr>
					</thead>
					<tbody>
						<tr
							ng-repeat="(key, value) in devolucionService.getListaOrdenes() |  orderBy:'-fechaDevolucion'">
							<td>
							<a href="#" title="Detalles"
							ng-click="detalle(value.idDevolucion,value)">
							{{value.folio}}</a>
							</td>
							<td>{{value.fechaDevolucion | date:'yyyy-MM-dd'}}</td>
							<td>{{value.fechaDevolucion | date:'HH:mm:ss'}}</td>
							<td>{{value.area}}</td>
							<td>{{value.nombreAlmacenOrigen}}</td>
							<td>{{value.nombreStatusDevolucion}}</td>
							<td>{{value.nombreMotivoDevolucion}}</td>
							<td><a href="#" 
								id="bdevolucion" ng-click="detalle(value.idDevolucion,value)">
								<i class="align list icon" title="Detalle"></i></a></td>
								
								
							
						</tr>
					</tbody>

				</table>



			
			<!--row-->





		</div>
		<!--container-->


		<div class="ui  vertical footer segment">
			<div class="ui center aligned container">

				<div class="ui section divider"></div>
				<div class="ui horizontal small divided link list">MotionCorp
				</div>
			</div>
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

		<div class="header">Folio Orden Reabasto
			{{devolucionService.getDevolucionCabeceraActual().folio}}</div>
		<div class="content">

			<div class="ui segments">
				<div class="ui secondary segment">
					<div class="ui segment">
						<span class="section"
							ng-repeat="(key,value) in devolucionService.getPathUnidadesPrincipal()">
							{{value.nombreUnidadJerarquica}} <i
							class="right chevron icon divider"></i>
						</span>
					</div>
					<div class="ui segment">


						<label>Folio Transferencia</label> <input type="text"
							value="{{devolucionService.getDevolucionCabeceraActual().folioTransferencia}}"
							readonly> <label>Sub-Almacen</label> <input
							type="text"
							value="{{devolucionService.getDevolucionCabeceraActual().nombreAlmacenDestino}}"
							readonly> <label>Motivo Devolucion</label> <input
							type="text"
							value="{{devolucionService.getDevolucionCabeceraActual().nombreMotivoDevolucion}}"
							readonly>

					</div>


				</div>




				<table class="ui selectable striped table">
					<thead>
						<tr>
							<th class="collapsing">Re-surtir</th>
							<th>Clave</th>
							<th>Nombre Insumo terapeutico</th>

							<th>Unidad de Distribución</th>
							<th>Presentacion</th>
							<th>Cantidad Devuelta</th>
							<th>Motivo</th>
							<th class="collapsing">Detalle</th>

						</tr>
					</thead>

					<tbody>
						<tr ng-repeat="(key, value) in devolucionService.getListaLineas()">
							
							<td>
								<div class="ui toggle checkbox">	
										<input type="checkbox" id="check{{key}}" ng-disabled="devolucionService.getBotonImprimir()" title="{{value.estadoResurtimiento ? 'Desactivar':'Activar'}}"
										 checked="checked"  ng-model="value.estadoResurtimiento">
										<label for="check{{key}}"></label>
								</div>
							</td>
							
							
							<td>{{value.datosMedicamento.clave}}</td>
							<td>{{value.datosMedicamento.nombrecorto}}</td>
							<td>{{value.datosMedicamento.presentacion}}</td>
							<td>{{value.datosMedicamento.unidadDistribucion}}</td>
							<td>{{value.cantidad }}</td>
							<td>{{value.nombreMotivoDevolucion}}</td>
							<td><div class="ui buttons">
									<button class="ui button"
										ng-disabled="devolucionService.getBotonImprimir()"
										ng-class="validaBotonSeleccion(value.eleccion,1) ? 'blue ui button':'gray ui button'"
										ng-click="value.eleccion=1">Devolución</button>

									<div class="or" data-text="o"></div>

									<button class="ui button"
										ng-disabled="devolucionService.getBotonImprimir()"
										ng-class="validaBotonSeleccion(value.eleccion,2) ? 'red ui button':'gray ui button'"
										ng-click="value.eleccion=2">Merma</button>
								</div></td>
						</tr>
					</tbody>


				</table>
			</div>
			<div class="actions">
				<button class="ui cancel button">Cancelar</button>
				<button ng-show="validaBotones()" class="ui approve  blue button"
					ng-click="crearOden()">Procesar</button>
				<a class="ui approve blue button"
					ng-show="devolucionService.getBotonImprimir()"
					ng-click="imprimir()"><i class="print icon"></i>Imprimir</a>

			</div>
		</div>
	</div>
	<!---------------------------------------------------------------
-----------------------------------------------------------------
          Modal UnidadJerarquica 
-----------------------------------------------------------------
----------------------------------------------------------------->
	<div id="unidadJerarquicaModal" class="ui modal ng-cloak"
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
								ng-Repeat="(key,value) in devolucionService.getPathUnidades()"
								ng-click="actualizarUnidadJerarquica(value.idUnidadJerarquica)">
								{{value.nombreUnidadJerarquica}} <i
								class="right chevron icon divider"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="seven wide left floated column">
						<h1>{{devolucionService.getUnidadJerarquica().nombreUnidadJerarquica}}</h1>

						<h3>
							Tipo:
							{{devolucionService.getUnidadJerarquica().nombreTipoUnidadJerarquica}}
							</h5>

							<h5>Unidades Jerarquicas</h5>

							<div class="ui basic segment">
								<div class="ui list">
									<a class="item"
										ng-Repeat="(key,value) in devolucionService.getUnidadesHijas()"
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
						ng-disabled="(devolucionService.getPathUnidades().length == 0)"
						ng-click="cambiarUnidadJerarquica()">Aceptar</button>
				</div>
			</div>

		</div>
	</div>




</body>
</html>