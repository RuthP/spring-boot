(function() {
'use strict';

    // Usage:
    // 
    // Creates:
    // 

    angular
        .module('chat')
        .component('messageList', {
            templateUrl:'components/message-list/messageList.html',
            //templateUrl: 'templateUrl',
            controller: 'messageListController',
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