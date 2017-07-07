(function() {
'use strict';

    angular
        .module('chat')
        .controller('loginController', LoginController);

    LoginController.inject = ['loginService,$scope,userService'];
    function LoginController(loginService,$scope,userService) {
        var vm = this;
        vm.users=[];
        $scope.displayMessage = false;

        $scope.areEmptyFields = function(){
            console.log('click on login');
            if(!$scope.email ||  !$scope.password){
                $scope.displayMessage = true;
                return true;
            }
           // $scope.displayMessage = false;
           //return false;
           vm.users = userService.getUsers().then(function result(data) {
           vm.users = data;
           console.log("Login",vm.users);
           $scope.validationUser = false;

           for(var x=0; x<vm.users.length; x++) {
            $scope.stateUserName = angular.equals($scope.email, vm.users[x].userName);
            $scope.statePassword = angular.equals($scope.password, vm.users[x].password);
            $scope.userName = vm.users[x].userName;

            if ($scope.stateUserName && $scope.statePassword) {
              $scope.displayMessage = false;
              $scope.validationUser = true;
                }
            }
            if ($scope.validationUser) {
                $scope.login($scope.userName);
            }

           }); 
            
        };
    }
})();