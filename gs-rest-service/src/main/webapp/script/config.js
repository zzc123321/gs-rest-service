'use strict';

angular.module('myApp').config(function($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('/search');
  $stateProvider.state('login', {
    url : '/login',
    data : {
      authorities : [],
      title : '登录',
    },
    views : {
      'main@' : {
        templateUrl : 'views/login.html',
        controller : 'LoginCtrl',
      }
    }
  })
  .state('index', {
    url: '/index',
    views : {
      'main@' : {
        templateUrl : 'views/dashboard.html',
        controller : 'DashboardCtrl',
      }
    }
  })
   .state('searchFroms', {
    url: '/searchFroms',
    views : {
      'main@' : {
        templateUrl : 'views/searchFroms.html',
        controller : 'SearchFromsCtrl',
      }
    }
  })
  .state('search', {
	    url: '/search',
	    views : {
	      'main@' : {
	        templateUrl : 'views/search.html',
	        controller : 'SearchCtrl',
	      }
	    }
	  });
});