app.controller("loginController", function($scope, $http,
		loginService,cfpLoadingBar){
	
	$scope.loginService = loginService
	$scope.buscar = function(){
		if(!$scope.formLogin.$invalid){
			$scope.loginService.login();	
		}
	}
	
});