(function() {
'use strict';

    // Usage:
    // 
    // Creates:
    // 

    angular
        .module('chat')
        .component('messageArea', {
            templateUrl:'components/message-area/messageArea.html',
            //templateUrl: 'templateUrl',
            controller: 'messageAreaController',
            bindings: {
                Binding: '=',
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