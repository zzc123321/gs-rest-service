angular.module('myApp')
  .controller('SearchFromsCtrl', function($scope, $state) {
	  
	  angular.forEach($scope.infos,function(v,k){
		  console.log(v.title);
	  })
  })