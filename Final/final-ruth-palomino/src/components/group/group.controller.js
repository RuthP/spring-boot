(function() {
'use strict';

    angular
        .module('chat')
        .controller('groupController', GroupController);

    GroupController.inject = ['groupService','loginService','$state','$stateParams','$http','$scope'];
    function GroupController(groupService,loginService,$state,$stateParams,$http,$scope) {
        var vm = this;
        vm.groups = [];
        vm.user = [];
        vm.idUser = $state.params.idUser;
        vm.groupEdit = null;
        console.log("IDINGROUP",vm.idUser);
        vm.enable="0";
        $scope.displayMessage = false;

        $scope.areEmptyFields = function(){
            //console.log('click on login');
            if(!vm.groupName ||  !vm.groupLogo){
                $scope.displayMessage = true;
                return true;
            }
        };
        vm.save = function(){
             var group = {
                create_date:new Date(),
                //create_date:"2017-07-09T14:58:39.990Z",
                logo : vm.groupLogo, 
                name : vm.groupName,             
                ownerId   : vm.idUser
            };
            console.log("SAVE",group);
            
            return $http.post('http://localhost:9090/groups',group).then(function(response){
                 //console.log("RESPONSE SAVE HTTP",response);
                 var id = vm.idUser;
                 vm.groups = groupService.getGroups(id).then(function(data){
                 vm.groups=data;
                 console.log("GROUP", vm.groups);
                 });
                 return response.data;
             },function (error){
                 console.log('FAIL TO LOAD',error);
             });

            
        };
        vm.getGroup = function(id){
            return $http.get("http://localhost:9090/groups/"+id).then(function(response){
                console.log("RESPONSE UPDATE HTTP",response);
                vm.groupEdit=response.data;
                vm.enable="1";
            }, function error(response) {
                console.log("ERROR",response);    
            });
        };

        vm.updateGroup = function(){
            var id = vm.idGroup;
            alert("id",id);
            var group = {
                createdate:new Date(),
                logo : vm.editName,
                name : vm.editLogo,
                ownerId : vm.idUser
            };
            console.log("UPDATE",group);

        };
        vm.deleteGroup = function(id){
            //alert(id);
            return $http.delete("http://localhost:9090/groups/deleteGroup/"+id).then(function(response){
                 console.log("DELETE",response);
                 var id = vm.idUser;
                 vm.groups = groupService.getGroups(id).then(function(data){
                 vm.groups=data;
                 console.log("GROUP", vm.groups);
                 });
            }, function error(response) {
                 console.log('ERROR DELETE GROUP', response);
            });
        };
        vm.$onInit = function (){
            var id = vm.idUser;
            vm.groups = groupService.getGroups(id).then(function(data){
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