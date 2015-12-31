function getQueryVariable(variable) {
    	  var query = window.location.search.substring(1);
    	  var vars = query.split("&");
    	  for (var i=0;i<vars.length;i++) {
    	    var pair = vars[i].split("=");
    	    if (pair[0] == variable) {
    	      return pair[1];
    	    }
    	  } 
    	}

app.controller("usuarioController", function($scope,usuarioService,MensajesService) {

	$scope.idPaciente=getQueryVariable("idPaciente");
	$scope.itemsPerPage =10;
	$scope.currentPage = 1;
	$scope.total = 0
	$scope.folioBuscador;

	/*********************Funciones llamadas para paginacion*******************/
	$scope.usuarioService=usuarioService;
	$scope.devolucionService.obtenerUnidadJerarquicaUsuario();
	
	$scope.buscaUsuario=function(){

	}
	
	$scope.detalle=function(valor){
		
	}
});

app.controller("DetalleController", function($scope,cedimeDevolucionService,MensajesService) {
	$scope.devolucionService=cedimeDevolucionService;	
	
/************************************Validaciones*****************************************************/	

});



