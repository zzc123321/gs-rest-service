'use strice';

angular.module('myApp')
  .controller('SearchCtrl', function($scope,$state,$http) {
    $scope.search = function(event) {
      console.log(event);
      $http({
          method: "POST",
          url: "http://localhost:8080/getSearchResult",
          data: {keyvalue:$scope.form.keyvalue.$viewValue},
          headers:{'Content-Type': 'application/x-www-form-urlencoded'}, 
          transformRequest:function(obj){
        	  var str=[];
        	  for(var s in obj)
        		  str.push(encodeURIComponent(s)+"="+encodeURIComponent(obj[s]));
        	  return str.join("&")
          }
      }).then(function (data){
          $scope.infos = data.data.pager.data;
//          $state.go('searchFroms');
      })

    }
  })