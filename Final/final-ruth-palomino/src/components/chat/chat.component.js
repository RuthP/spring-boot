(function() {
'use strict';

    // Usage:
    // 
    // Creates:
    // 

    angular
        .module('chat')
        .component('chat', {
            templateUrl:'components/chat/chat.html',
            //templateUrl: 'templateUrl',
            controller: 'chatController',
            bindings: {
                Binding: '=',
            },
        });
})();