(function() {
'use strict';

    // Usage:
    // 
    // Creates:
    // 

    angular
        .module('chat')
        .component('login', {
            //template:'htmlTemplate',
            templateUrl: 'templateUrl',
            controller: 'loginController',
            bindings: {
               // Binding: '=',
            },
        });

    ControllerController.inject = ['dependency1'];
    function ControllerController(dependency1) {
        var ctrl = this;
        

        ////////////////

        ctrl.onInit = function() { };
        ctrl.onChanges = function(changesObj) { };
        ctrl.onDestory = function() { };
    }
})();