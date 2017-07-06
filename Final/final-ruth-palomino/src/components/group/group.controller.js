(function() {
'use strict';

    angular
        .module('chat')
        .controller('groupController', GroupController);

    GroupController.inject = ['groupService'];
    function GroupController(groupService) {
        var vm = this;
        vm.groups = [];

        vm.$onInit = function (){
            vm.groups = groupService.getGroups().then(function(data){
                //vm.users=data.users;
                vm.groups=data;
                console.log("GROUP", vm.groups);
            });          
        };
    }
})();