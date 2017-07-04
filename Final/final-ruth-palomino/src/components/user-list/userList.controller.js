(function() {
'use strict';

    angular
        .module('chat')
        .controller('userListController', UserListController);

    UserListController.inject = ['userService'];
    function UserListController(userService){
        var vm= this;
        vm.users = [];

        vm.$onInit = function (){
            vm.users = userService.getUsers().then(function(data){
                vm.users=data.users;
                console.log("USERS", vm.users);
            });          
        };

        userService.updateUsers();
        //console.log("ALL RESOLVED");
    }
    /*function UserListController($scope) {
        $scope.displayMessageUserList= false;
    }*/
})();