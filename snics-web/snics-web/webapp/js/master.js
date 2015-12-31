/**
 * 
 */

//var app = angular.module("mus", ['chieffancypants.loadingBar', 'ngAnimate','smart-table']);
var app = angular.module("snics", ['chieffancypants.loadingBar', 'ngAnimate']);


app.directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.ngEnter);
                });

                event.preventDefault();
            }
        });
    };
});

app.service("MensajesService", function(){
	var mensaje = {
			
	};
	
	this.setMensaje = function(value) {
		mensaje = value;
	}
	this.getMensaje = function(){
		return mensaje;
	}
});
//app.directive('ngEnter', function () {
//    return function (scope, element, attrs) {
//        element.bind("keydown keypress", function (event) {
//            if(event.which === 13) {
//                scope.$apply(function (){
//                    scope.$eval(attrs.ngEnter);
//                    
//                });
//
//                event.preventDefault();
//            }
//        });
//    };
//});


app.controller("mensajeriaController",function($scope,$timeout,MensajesService){
	$scope.mensajeService = MensajesService;
	
	$scope.fadeOutMessage = function (){
		jQuery('.ui.message').transition('fade out');
	}
	$scope.$watch("mensajeService.getMensaje()", function(newValue,oldValue){
		
		//$scope.mensaje = newValue;
		if($scope.mensajeService.getMensaje().show){
			$scope.mensajeService.getMensaje().show = false;
			$scope.mensaje = angular.copy($scope.mensajeService.getMensaje())
			jQuery('.ui.message').transition('show');
			$timeout($scope.fadeOutMessage,3000);
		}
	},true);
	
});

// interceptor
app.factory('sessionRecoverer', ['$q', '$injector', function($q, $injector) {  
    var sessionRecoverer = {
        responseError: function(response) {
            // Session has expired
            if (response.status == 513){ 
            	//alert(CONTEXT_PATH_WEB+"/pages/logout.do")
            	location.href=CONTEXT_PATH_WEB+"/pages/logout.do"
            	return
            }
            return response
        }
    };
    return sessionRecoverer;
}]);
app.config(['$httpProvider', function($httpProvider) {  
    $httpProvider.interceptors.push('sessionRecoverer');
}]);



