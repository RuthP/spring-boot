(function() {
'use strict';

    angular
        .module('chat')
        .factory('loginService', LoginService);

    LoginService.inject = [''];
    function LoginService() {
        var service = {
            loginIn:loginIn
        };
        
        return service;

        ////////////////
        function loginIn() { }
    }
})();