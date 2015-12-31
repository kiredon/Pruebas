/**
 * 
 */


app.config(function(cfpLoadingBarProvider) {
    cfpLoadingBarProvider.includeSpinner = false;
});


app.service("EditarUnidadJerarquicaService", function (){
	var idUnidadJerarquica = {
			value:-1
	}
	
	this.get = function (){
		return this.idUnidadJerarquica;
	}
	this.set = function(value){
		this.idUnidadJerarquica = {
				value:value
		}
	}
	
});


app.service("UsuarioService", function() {
	var usuario = {};
	var update = {
		value:false
	}
	this.get = function() {
		return usuario;
	};

	this.set = function(value) {
		usuario = value;
	}
	
	this.isUpdatable = function() {
		return update.value;		
	}
	
	this.update = function (valor){
		update = {
				value:valor
		}
	}
});

app.controller("usuarioController", function($scope, $http,
		UsuarioService,cfpLoadingBar,MensajesService,EditarUnidadJerarquicaService) {

	$scope.init = function() {
		$scope.nombreUsuario="";
		$scope.usuarioList = []
		$scope.estadoActivo=null;
		$scope.estadoActivar=null;
		$scope.estadoActivarUpper=null;
		$scope.itemsPerPage = 10;
		$scope.currentPage = 1;
		$scope.total = 0
		$scope.mostrarTodos = {
			value : false
		};
		$scope.service = UsuarioService
		$scope.mensajeService = MensajesService;
		
		$('.ui.accordion')
		  .accordion()
		;
	}

	$scope.mostrarTodosChange = function() {
		$scope.currentPage = 1;
		$scope.obtenerBusquedaUsuario(2);
		start = $scope.currentPage;
		if (start > $scope.pageCount() - rangeSize) {
			start = $scope.pageCount() - rangeSize;
		}
		if (start <= 0) {
			start = 1;
		}
		if (rangeSize > $scope.pageCount()) {
			rangeSize = $scope.pageCount() - 1;
		}
	}

	$scope.obtenerUsuario = function() {
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Usuario/listar.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : {
				'status' : $scope.mostrarTodos.value,
				pagina : $scope.currentPage,
				tamanio : $scope.itemsPerPage

			}
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
				$scope.usuarioList = data.usuarioVoList.listUsuario;
				$scope.total = data.total				

			}else{
				var mensaje = {
						encabezado:'Mensajes: Usuario',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.usuarioList = [];
				$scope.total = 0
				$scope.mensajeService.setMensaje(mensaje);
			}

			cfpLoadingBar.complete();
		}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Usuario',
					mensaje:'Ocurrió un error al obtener la lista de usuario',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});

	}
	$scope.obtenerBusquedaUsuario = function(bandera) {
		if(bandera==1){
			$scope.currentPage = 1;
		}
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Usuario/listarBusqueda.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : {
				nombre : $scope.nombreUsuario,
				'status' : $scope.mostrarTodos.value,
				pagina : $scope.currentPage,
				tamanio : $scope.itemsPerPage

			}
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
				$scope.usuarioList = data.usuarioVoList.listUsuario;
				$scope.total = data.total				

			}else{
				var mensaje = {
						encabezado:'Mensajes: Usuario',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.usuarioList = [];
				$scope.total = 0
				$scope.mensajeService.setMensaje(mensaje);
			}

			cfpLoadingBar.complete();
		}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Usuario',
					mensaje:'Ocurrió un error al obtener la lista de usuario',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});

	}
	$scope.nextPageDisabled = function() {
		return $scope.currentPage === $scope.pageCount() ? "disabled" : "";
	};
	$scope.restablecerContrasena = function(idUsuario,nombre) {
	//alert(idUsuario)
		jQuery("#mensajeContrasena").text("Introduzca la nueva contraseña para el  usuario: "+nombre)
	    jQuery("#nuevaContrasena" ).val("")
		$('.small.contrasena.modal')
		  .modal('show').modal({
			  onApprove: function (){
				
					cfpLoadingBar.start();
					$http(
							{
								url : CONTEXT_PATH_SERVICES
										+ '/Usuario/cambiarContrasena.do',
								method : 'POST',
								headers : {
									'Content-Type' : 'application/json',
									'Accept' : 'application/json',
									'x-requested-with' : SNOWFLAKE
								},
								data : {
									
									'idUsuario' : idUsuario,
									'nuevaContrasena' : $( "#nuevaContrasena" ).val()
								}
							}).success(
									function(data, status, headers, config) {
										if(angular.equals(data.responseCode,"OK")){
											$scope.obtenerBusquedaUsuario(2);
											var mensaje = {
													encabezado:'Mensajes: Usuario',
													mensaje:'Se cambió correctamente la contraseña',
													positivo:'success',
													show:true
											};
											$scope.mensajeService.setMensaje(mensaje);
										}else{
											var mensaje = {
													encabezado:'Mensajes: Usuario',
													mensaje:data.responseCode,
													positivo:'error',
													show:true
											};
											$scope.mensajeService.setMensaje(mensaje);
										}	

										cfpLoadingBar.complete();
									
									
					}).error(function(data, status, headers, config) {
						var mensaje = {
								encabezado:'Mensajes: Usuario',
								mensaje:'Ocurrió un error al cambiar la contraseña',
								positivo:'error',
								show:true
						};
						$scope.mensajeService.setMensaje(mensaje);
					});
			  }
			  
		  })
		;
		
		
	}
	$scope.borrarUsuario = function(idUsuario,status,nombre) {
		if(status!=true){
			$scope.estadoActivo="activó";
			$scope.estadoActivar="activar";
			$scope.estadoActivarUpper="Activar";
		}else{
			$scope.estadoActivo="desactivó";
			$scope.estadoActivar="desactivar";
			$scope.estadoActivarUpper="Desactivar";
		}		
		
		jQuery("#mensajeActivacion").text("¿Está seguro que desea " + $scope.estadoActivar + " el usuario: "+nombre+"?")
		jQuery("#headerActivacion").text($scope.estadoActivarUpper + " el usuario")
		$('.small.test.modal')
		  .modal('show').modal({
			  onApprove: function (){
				  status=!status;
					cfpLoadingBar.start();
					$http(
							{
								url : CONTEXT_PATH_SERVICES
										+ '/Usuario/cambiarEstado.do',
								method : 'POST',
								headers : {
									'Content-Type' : 'application/json',
									'Accept' : 'application/json',
									'x-requested-with' : SNOWFLAKE
								},
								data : {
									'status' : status,
									'idUsuario' : idUsuario																				
								}
							}).success(
									function(data, status, headers, config) {
										if(angular.equals(data.responseCode,"OK")){
											$scope.obtenerBusquedaUsuario(2);
											var mensaje = {
													encabezado:'Mensajes: Usuario',
													mensaje:'Se '+$scope.estadoActivo+' correctamente el usuario',
													positivo:'success',
													show:true
											};
											$scope.mensajeService.setMensaje(mensaje);
										}else{
											var mensaje = {
													encabezado:'Mensajes: Usuario',
													mensaje:data.responseCode,
													positivo:'error',
													show:true
											};
											$scope.mensajeService.setMensaje(mensaje);
										}	

										cfpLoadingBar.complete();
									
									
					}).error(function(data, status, headers, config) {
						var mensaje = {
								encabezado:'Mensajes: Usuario',
								mensaje:'Ocurrió un error al borrar el usuario',
								positivo:'error',
								show:true
						};
						$scope.mensajeService.setMensaje(mensaje);
					});
			  }
			  
		  })
		;
	}
	
	$scope.insertarUsuario = function(){
		$scope.service.set({
			idUsuario:0
		});
		jQuery('#editarModal').modal('show');
	}

	$scope.editarUsuario = function(usuario) {
		$scope.service.set(angular.copy(usuario));
		jQuery('#editarModal').modal('show');
	}
	
	
	$scope.serviceUnidad = EditarUnidadJerarquicaService
	$scope.asignarUnidadJerarquica = function(usuario) {
		$scope.service.set(angular.copy(usuario));
		$scope.serviceUnidad.set(usuario.idUnidadJerarquica)
	}

	/* Paginacion */
	$scope.range = function() {
		var rangeSize = 7;
		var ret = [];
		var start;

		start = $scope.currentPage;
		if (start > $scope.pageCount() - rangeSize) {
			start = $scope.pageCount() - rangeSize;
		}
		if (start <= 0) {
			start = 1;
		}
		if (rangeSize > $scope.pageCount()) {
			rangeSize = $scope.pageCount()-1;
		}

		for (var i = start; i <= start + rangeSize; i++) {
			ret.push(i);
		}
		return ret;
	};
	$scope.prevPage = function() {
		if ($scope.currentPage > 1) {
			$scope.currentPage--;
		}
	};

	$scope.prevPageDisabled = function() {
		return $scope.currentPage === 1 ? "disabled" : "";
	};

	$scope.nextPage = function() {
		if ($scope.currentPage < $scope.pageCount()) {
			$scope.currentPage++;
		}
	};

	$scope.nextPageDisabled = function() {
		return $scope.currentPage === $scope.pageCount() ? "disabled" : "";
	};

	$scope.pageCount = function() {
		return Math.ceil($scope.total / $scope.itemsPerPage);
	};

	$scope.setPage = function(n) {
		if (n >= 1 && n <= $scope.pageCount()) {
			$scope.currentPage = n;
		}
		//jQuery('.ui.message').transition('fade');
		
	};

	$scope.$watch("currentPage", function(newValue, oldValue) {
		$scope.obtenerBusquedaUsuario(2);

		$scope.pagedItems = $scope.usuarioList
	});

	$scope.$watch("mostrarTodos", function(newValue, oldValue) {
		$scope.obtenerBusquedaUsuario(2);
	});
	
	$scope.$watch("service.isUpdatable()", function(newValue, oldValue) {
		if(newValue == true){
			$scope.obtenerBusquedaUsuario(2);
			$scope.service.update(false);
		}
	});

	$scope.init();
	$scope.obtenerBusquedaUsuario(2);
})

app.controller("editarModalController", function($scope, $http,
		UsuarioService,cfpLoadingBar,MensajesService) {

	$scope.service = UsuarioService;
	$scope.usuarioAnterior = {};
	$scope.rolList = []
	
	$scope.datosMedico={}
	$scope.Usuario2={};
	$scope.bandera=true;
	$scope.mensajeService = MensajesService;
	$scope.nombreRol = ""
	
	
	$scope.cambiarRol = function (){
		var nombreRol = $("#seleccionRol option:selected").text();
		$scope.nombreRol = nombreRol
		
	}
	
	
	
	$scope.guardar = function() {
		if($scope.usuario.idUsuario == 0){
			$scope.insertar();
//			$scope.datosMedico.idUsuario=$scope.Usuario2.idUsuario;
//			$scope.actualizarDatosMedico();
		}else{
			$scope.actualizar();
			$scope.datosMedico.idUsuario=$scope.usuario.idUsuario;
			
			if($scope.nombreRol == "Médico"){
				$scope.actualizarDatosMedico();
			}
		}
	}
	
	$scope.obtenerDatosMedico = function() {
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Usuario/listarDatosMedico.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : {
				'idUsuario' : $scope.usuario.idUsuario
				
			}
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
			$scope.datosMedico = data.datosMedicoVo;
			}else{
				var mensaje = {
						encabezado:'Mensajes: DatosMedico',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.datosMedico = {};
			}
			cfpLoadingBar.complete();
		}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: DatosMedico',
					mensaje:'Ocurrió un error al obtener la lista de datos médico',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});


	}
	
	
	$scope.obtenerRol = function() {
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Rol/listar.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : {
				'status' : false,
				'pagina' : 1,
				'tamanio':100
			}
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
			$scope.rolList = data.rolVoList.listRol;
			}else{
				var mensaje = {
						encabezado:'Mensajes: Rol',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.rolList = [];
			}
			cfpLoadingBar.complete();
		}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Rol',
					mensaje:'Ocurrió un error al obtener la lista de rol',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});


	}
	$scope.obtenerRol();
	$scope.actualizar = function(){
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Usuario/actualizar.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : $scope.usuario
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
				$scope.service.update(true);
				var mensaje = {
						encabezado:'Mensajes: Usuario',
						mensaje:'Se Actualizó correctamente el Usuario',
						positivo:'success',
						show:true
				};
				$scope.mensajeService.setMensaje(mensaje);	
			}else{
				var mensaje = {
						encabezado:'Mensajes: Usuario',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.mensajeService.setMensaje(mensaje);
			}

			cfpLoadingBar.complete();

			}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Usuario',
					mensaje:'Ocurrió un error al guardar el usuario',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});
	}
	$scope.actualizarDatosMedico = function(){
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Usuario/actualizarDatosMedico.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : $scope.datosMedico
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
				$scope.service.update(true);
				var mensaje = {
						encabezado:'Mensajes: Datos Médico',
						mensaje:'Se Actualizaron los datos del médico',
						positivo:'success',
						show:true
				};
				$scope.mensajeService.setMensaje(mensaje);	
			}else{
				var mensaje = {
						encabezado:'Mensajes: Datos Médico',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				if($scope.nombreRol == "Médico"){
					$scope.mensajeService.setMensaje(mensaje);
				}
			}

			cfpLoadingBar.complete();

			}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Datos Médico',
					mensaje:'Ocurrió un error al guardar el datosMedico',
					positivo:'error',
					show:true
			};
			if($scope.nombreRol == "Médico"){
				$scope.mensajeService.setMensaje(mensaje);
			}
		});
	}
	$scope.funcion= function(){
		alert("hola");
	}
	$scope.validaBandera = function(usuario){
		
		//$scope.bandera=true;
		
		if(usuario != undefined && usuario.nombreRol=="Médico"){
			$scope.bandera=true;
			
		}
	}
	$scope.insertar = function(){
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Usuario/insertar.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : $scope.usuario	
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
				$scope.service.update(true);			
				$scope.datosMedico.idUsuario=data.usuarioVo.idUsuario;
				$scope.actualizarDatosMedico();
				//alert(usuario2);
				//alert(data.usuarioVo.idUsuario);
				var mensaje = {
						encabezado:'Mensajes: Usuario',
						mensaje:'Se insertó correctamente el Usuario',
						positivo:'success',
						show:true
				};
				$scope.mensajeService.setMensaje(mensaje);

			}else{
				var mensaje = {
						encabezado:'Mensajes: Usuario',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.mensajeService.setMensaje(mensaje);
			}

			cfpLoadingBar.complete();
		}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Usuario',
					mensaje:'Ocurrió un error al guardar el usuario',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});
	}

	$scope.insertarDatosMedico = function(){
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Usuario/insertarDatosMedico.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : $scope.datosMedico	
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
				$scope.service.update(true);
				var mensaje = {
						encabezado:'Mensajes: Datos Médico',
						mensaje:'Se insertaron correctamente los Datos del Médico',
						positivo:'success',
						show:true
				};
				$scope.mensajeService.setMensaje(mensaje);

			}else{
				var mensaje = {
						encabezado:'Mensajes: Datos Médico',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				if($scope.nombreRol == "Médico"){
					$scope.mensajeService.setMensaje(mensaje);
				}
				
			}

			cfpLoadingBar.complete();
		}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Datos Médico',
					mensaje:'Ocurrió un error al guardar los datos del médico',
					positivo:'error',
					show:true
			};
			if($scope.nombreRol == "Médico"){
				$scope.mensajeService.setMensaje(mensaje);
			}
		});
	}
	$("#acordeon").hide();
	
	
	
	jQuery('#editarModal').modal({
			//closable:false,
			onApprove:function (){
				if($scope.formUsuario.$valid){
					$scope.guardar()
				}else{
					return false;
				}
		  }	
	});
	
	$scope.validate = function (field){
		//return field.$dirty && field.$error.required
	}
	
	$scope.$watch("service.get()", function(newValue, oldValue) {
		$scope.usuario = newValue;
		if($scope.usuario.idUsuario!=undefined){
		$scope.obtenerDatosMedico();
	}
		$scope.nombreRol = $scope.usuario.nombreRol
		$scope.usuarioAnterior = oldValue;
		
	})
});





app.controller("unidadJerarquicaModalController",function($scope, $http,
		EditarUnidadJerarquicaService,cfpLoadingBar,MensajesService,UsuarioService) {
	
	$scope.init = function (){
		$scope.mensajeService = MensajesService;
		$scope.usuarioService = UsuarioService;
		$scope.pathUnidades = {};
		$scope.unidadesHijas = {};
		$scope.unidadActual = {
				idUnidadJerarquica:0
		};
	};
	
	$scope.serviceUnidad = EditarUnidadJerarquicaService
	
	$scope.pathUnidades
	
	$scope.$watch ("serviceUnidad.get()", function (newValue,oldValue){
		
		if(newValue != undefined){
			$scope.unidadActual = {
					idUnidadJerarquica:newValue.value
			};
			$scope.obtenerUnidadJerarquica();
			return false;
		}

	});
	
	$scope.obtenerPath = function(){
		$http({
			url : CONTEXT_PATH_SERVICES + '/UnidadJerarquica/listarPath.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : {
				idUnidadJerarquica:$scope.unidadActual.idUnidadJerarquica
			}
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
				$scope.pathUnidades = data.unidadJerarquicaVoList.listUnidadJerarquica;

			}else{
				var mensaje = {
						encabezado:'Mensajes: Unidad Jerárquica',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.pathUnidades = [];
				$scope.mensajeService.setMensaje(mensaje);
			}

			jQuery('#unidadJerarquicaModal').modal({
				closable:false,
				onApprove:$scope.asociarUnidad,
				onDeny:function (){return false}
			}).modal('show')
			//cfpLoadingBar.complete();
		}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Unidad Jerárquica',
					mensaje:'Ocurrió un error al obtener la lista de Unidades Jerárquicas',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});
	};
	
	$scope.obtenerUnidadJerarquica = function (){
//		cfpLoadingBar.start();

		$http({
			url : CONTEXT_PATH_SERVICES + '/UnidadJerarquica/obtenerPorId.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : {
				idUnidadJerarquica:$scope.unidadActual.idUnidadJerarquica,
				status:false
			}
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){

				$scope.unidadActual = data.unidadJerarquicaVo
				$scope.obtenerPath();

				$scope.unidadesHijas = data.unidadesJerarquicasHijas;
			}else{
				var mensaje = {
						encabezado:'Mensajes: Unidad Jerárquica',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.pathUnidades = [];
				$scope.mensajeService.setMensaje(mensaje);
			}

		}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Unidad Jerárquica',
					mensaje:'Ocurrió un error al obtener la lista de Unidades Jerárquicas',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});
	};
	
	$scope.asociarUnidadUsuario = function(){
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Usuario/asociar.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : SNOWFLAKE
			},
			data : {
				idUnidad:$scope.unidadActual.idUnidadJerarquica,
				idUsuario:$scope.usuarioService.get().idUsuario				
			}
		}).success(function(data, status, headers, config) {
			if(angular.equals(data.responseCode,"OK")){
				$scope.usuarioService.update(true);
				var mensaje = {
						encabezado:'Mensajes: Usuario',
						mensaje:'Se Asoció correctamente el Usuario',
						positivo:'success',
						show:true
				};
				$scope.mensajeService.setMensaje(mensaje);	
			}else{
				var mensaje = {
						encabezado:'Mensajes: Usuario',
						mensaje:data.responseCode,
						positivo:'error',
						show:true
				};
				$scope.mensajeService.setMensaje(mensaje);
			}

			cfpLoadingBar.complete();

			}).error(function(data, status, headers, config) {
			var mensaje = {
					encabezado:'Mensajes: Usuario',
					mensaje:'Ocurrió un error al guardar el usuario',
					positivo:'error',
					show:true
			};
			$scope.mensajeService.setMensaje(mensaje);
		});
	}
	
	
	$scope.cambiarUnidadActual = function (unidadActual){
		$scope.unidadesHijas = []
		$scope.unidadActual = unidadActual;
		$scope.obtenerUnidadJerarquica();
	}
	
	$scope.asociarUnidad = function (){
		
		$scope.asociarUnidadUsuario()
	}
	
	$scope.init()
	
});