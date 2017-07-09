(function() {
'use strict';

    angular
        .module('chat')
        .controller('groupController', GroupController);

    GroupController.inject = ['groupService','loginService','$state','$stateParams'];
    function GroupController(groupService,loginService,$state,$stateParams) {
        var vm = this;
        vm.groups = [];
        vm.user = [];
        vm.idUser = $state.params.idUser;
        console.log("IDINGROUP",vm.idUser);
        vm.enable="0";

        vm.$onInit = function (){
            vm.groups = groupService.getGroups().then(function(data){
                //vm.users=data.users;
                vm.groups=data;
                console.log("GROUP", vm.groups);
            });
           /* vm.user = groupService.getUserGroup(vm.idUser).then(function(data){
                vm.user=data;
                console.log("USER",vm.user);
            });*/
        };
            
    }
})();