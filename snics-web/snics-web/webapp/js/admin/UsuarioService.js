

app.service("cedimeDevolucionService", function($http,$timeout,MensajesService) {
	var ambiente=this;	
	//variables pantalla principal
	var listaOrdenesUrgentes=[]
	var listaOrdenesNormales
	var devolucionCabeceraActual={}


	this.getTotal=function(){
		return ambiente.total
	}
	this.setTotal=function(tot){
		ambiente.total=tot
	}
	
	this.mensajeNoFolio=function(){
		mostrarMensaje = {
				encabezado:'Mensajes: Busqueda de Folio',
				mensaje:'El folio ingresado no tiene coincidencias',
				positivo:'error',
				show:true
		};
		MensajesService.setMensaje(mostrarMensaje);
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
		
	


	
	
this.parserDate=function(dateOriginal){
		var fecha = new Date(dateOriginal)
		var yyyy = fecha.getFullYear().toString();
		var mm = (fecha.getMonth()+1).toString(); // getMonth() is zero-based
		var dd  = fecha.getDate().toString();
		return yyyy +"-"+ (mm[1]?mm:"0"+mm[0]) +"-"+ (dd[1]?dd:"0"+dd[0]); // padding
	}
	
this.parserHora=function(dateOriginal){
		var fecha = new Date(dateOriginal)
		var horas;
		var minutos
		var segundos
		if(fecha.getHours()<=9)
			horas="0"+fecha.getHours()
		if(fecha.getHours()>9)
			horas=fecha.getHours()
		if(fecha.getMinutes()<=9)
			minutos="0"+fecha.getMinutes()
		if(fecha.getMinutes()>9)
			minutos=fecha.getMinutes()
		if(fecha.getSeconds()<=9)
			segundos="0"+fecha.getSeconds()
		if(fecha.getSeconds()>9)
			segundos=fecha.getSeconds()
		return horas+":"+minutos+":"+segundos
}
	

	
	
});
	
	
	
