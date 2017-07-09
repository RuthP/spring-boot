(function() {
'use strict';

    angular
        .module('chat')
        .controller('loginController', LoginController);

    LoginController.inject = ['loginService','$scope','userService', '$state','groupService'];
    function LoginController(loginService,$scope,userService,$state,groupService) {
        var vm = this;
        vm.users=[];
        var userName1 = [];
        var idUser1 = [];
        $scope.displayMessage = false;
        console.log("USERNAME",userName1);

        $scope.areEmptyFields = function(){
            //console.log('click on login');
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
            $scope.stateUserName = angular.equals($scope.email, vm.users[x].username);
            $scope.statePassword = angular.equals($scope.password, vm.users[x].password);
            $scope.userName = vm.users[x].username;
            idUser1= vm.users[x].id;
            


            if ($scope.stateUserName && $scope.statePassword) {
              $scope.displayMessage = false;
              $scope.validationUser = true;

            if ($scope.validationUser) {
                $scope.login($scope.userName,idUser1);
                
            }  
                }
            }
            

           }); 
            return false;
    };
    
    $scope.login = function(UserName,id) {
      userName1 = UserName;  
      var result = { idUser:id};
      console.log("result",result);
      $state.go('group', { idUser:id});       
      //$state.go('chat');
      console.log("UserLogin",userName1);
      //console.log("ID",idUser1);
    };
  }
})();