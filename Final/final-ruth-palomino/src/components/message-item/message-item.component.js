(function() {
'use strict';

    // Usage:
    // 
    // Creates:
    // 

    angular
        .module('chat')
        .component('messageItem', {
            templateUrl:'components/message-item/messageItem.html',
            //templateUrl: 'templateUrl',
            controller: 'messageItemController',
            bindings: {
                message: '=',
            },
        });
})();