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


app.service("loginService",function($http,cfpLoadingBar){
	var snowflake = {}
	var userData = {
			usuario:'',
			contrasenia:''
	}
	
	
	this.getUserData = function(){
		return userData;
	}
	
	this.setUserData = function (value){
		userData = value;
	}
	
	this.login = function(){
		cfpLoadingBar.start();
		$http({
			url : CONTEXT_PATH_SERVICES + '/Snowflake/login.do',
			method : 'POST',
			headers : {
				'Content-Type' : 'application/json',
				'Accept' : 'application/json',
				'x-requested-with' : ''
			},
			data : this.getUserData()
		}).success(function(data, status, headers, config) {
			cfpLoadingBar.complete();
			if(!angular.equals(data.snowflake,"")){
				jQuery.cookie("SNOWFLAKE",data.snowflake);
				window.location.href = "pages/home.do";
			}else{
		
		}
			

		}).error(function(data, status, headers, config) {
			cfpLoadingBar.complete();
			alert("login Incorrecto")
		});
		
	}
	
});