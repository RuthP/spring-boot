(function() {
'use strict';

    // Usage:
    // 
    // Creates:
    // 

    angular
        .module('chat')
        .component('userItem', {
            templateUrl:'components/user-item/userItem.html',
            //templateUrl: 'templateUrl',
            controller: 'userItemController',
            bindings: {
                user: '=',
            },
        });
})();