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
        })
        
        .state('group',{
            url:'/group',
            params:{
                idUser:null
            },
            templateUrl:'components/group/group.html'
            //controller: 'groupController'
        });

    });
})();