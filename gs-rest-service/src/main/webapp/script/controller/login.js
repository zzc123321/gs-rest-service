'use strice';

angular.module('myApp')
  .controller('LoginCtrl', function($scope, $state) {
    $scope.login = function(event) {
      console.log(event);
      $state.go('index');
    }
  })