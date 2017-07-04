(function() {
'use strict';

    // Usage:
    // 
    // Creates:
    // 

    angular
        .module('chat')
        .component('userList', {
            templateUrl:'components/user-list/userList.html',
            //templateUrl: 'templateUrl',
            controller: 'userListController',
            bindings: {
            },
        });
})();