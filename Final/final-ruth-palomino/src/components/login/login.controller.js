(function() {
'use strict';

    angular
        .module('chat')
        .controller('loginController', LoginController);

    LoginController.inject = ['loginService'];
    function LoginController(loginService) {
        var vm = this;
        vm.users=[];
    }
})();