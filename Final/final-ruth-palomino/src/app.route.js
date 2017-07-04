(function (){
    'use strict';

    angular.module('chat')
    .config(function($stateProvider,$urlRouterProvider){

        $urlRouterProvider.otherwise('login');

        $stateProvider
        .state('login',{
            url:'/login',
            templateUrl:'views/login.html'
        })

        .state('chat',{
            url:'/chat',
            templateUrl:'components/chat/chat.html'
        });

    });
})();