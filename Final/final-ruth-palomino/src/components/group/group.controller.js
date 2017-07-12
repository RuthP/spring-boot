(function() {
'use strict';

    angular
        .module('chat')
        .controller('groupController', GroupController);

    GroupController.inject = ['groupService','loginService','$state','$stateParams','$http','$scope'];
    function GroupController(groupService,loginService,$state,$stateParams,$http,$scope) {
        var vm = this;
        vm.groups = [];
        vm.users = [];
        vm.idUser = localStorage.getItem("IdUser");
        vm.idGroup = null;
        vm.GroupUser = null;
        vm.idUserList = null;
        //localStorage.clear(); //Para borrar datos
        vm.groupEdit = null;
        console.log("IDINGROUP",vm.idUser);
        vm.enable = "0";
        vm.enableTable = "0";
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
                createdate:new Date(),
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
                 console.log("GROUPS SAVE",vm.groups);
                 });
                 return response.data;
             },function (error){
                 console.log('FAIL TO LOAD',error);
             });

            
        };
        vm.getGroup = function(id){
            return $http.get("http://localhost:9090/groups/"+id).then(function(response){
                //console.log("RESPONSE UPDATE HTTP",response);
                vm.groupEdit=response.data;
                vm.enable="1";
            }, function error(response) {
                console.log("ERROR",response);    
            });
        };

        vm.updateGroup = function(){
            var id = vm.groupEdit.id;
            //console.log("IDDD",vm.groupEdit.id);
           // alert("id",id);
            var group = {
                createdate:new Date(),
                logo : vm.groupEdit.name,
                name : vm.groupEdit.logo,
                ownerId : vm.idUser
            };
            console.log("UPDATE",group);
            return $http.put("http://localhost:9090/groups/updateGroup/"+id,group).then(function(response){
              console.log("UPDATE",response);
              var id = vm.idUser;
              vm.groups = groupService.getGroups(id).then(function(data){
              vm.groups=data;
              console.log("GROUPS UPDATE",vm.groups);
              });
              vm.enable="0";
            },function error(response){
              console.log("ERROR",response);       
            });
        };
        vm.deleteGroup = function(id){
            //alert(id);
            return $http.delete("http://localhost:9090/groups/deleteGroup/"+id).then(function(response){
                 console.log("DELETE",response);
                 var id = vm.idUser;
                 vm.groups = groupService.getGroups(id).then(function(data){
                 vm.groups=data;
                 console.log("GROUPS DELETE",vm.groups);
            });
            }, function error(response) {
                 console.log('ERROR DELETE GROUP', response);
            });
        };
        vm.seeUsers = function(id){
            vm.users= groupService.getUsersGroup(id).then(function(data){
                vm.users=data;
                vm.enable = "3";
                vm.enableTable = "1";
                vm.idGroup=id;
                console.log("SEE",vm.users);
            });
            
        };
        vm.saveUser = function(){
            var user = {
                email:vm.email,
                firstName:vm.fisrtName,
                lastName:vm.lastName,
                password:vm.password,
                status:"Active",
                userName:vm.userName
            };
            console.log("SAVEUSER",user);
            return $http.post('http://localhost:9090/users',user).then(function(data){
                var id = vm.idGroup;
                var idNewUser = groupService.getMaxUser().then(function(data){
                    var idNewUser = data[0];
                    console.log("NEWUSER",idNewUser);
                    console.log("GROUP"+id+"USER"+idNewUser);

                    var groupUser = {
                    groupId : id,
                    userId :idNewUser
                    };
                    console.log("GGGGGGGGGGGGG",groupUser);
                    vm.GroupUser = groupService.saveGroupUser(groupUser).then(function(data){
                        console.log('GROUPUSER',data);
                    });
                });
                var idG = vm.idGroup;
                vm.users= groupService.getUsersGroup(idG).then(function(data){
                    vm.users=data;
                    vm.enable = "3";
                    vm.enableTable = "1";
                    vm.idGroup=id;
                    //console.log("SAVEUSER",vm.users);
                });
            }, function error(response) {
                 console.log('ERROR SAVEUSER', response);
            });
        };
        vm.deleteUser = function(id){
            //alert(id);
            return $http.delete("http://localhost:9090/users/deleteUser/"+id).then(function(response){
                 console.log("DELETE",response);
                 var idOwner = vm.idUser;
                 var idG = vm.idGroup;

                vm.users= groupService.getUsersGroup(idG).then(function(data){
                vm.users=data;
                vm.enable = "3";
                vm.enableTable = "1";
                vm.idGroup=id;
                console.log("DELETE",vm.users);
                });
            }, function error(response) {
                 console.log('ERROR DELETE GROUP', response);
            });
        };
        vm.$onInit = function (){
            var id = vm.idUser;
            vm.groups = groupService.getGroups(id).then(function(data){
                vm.groups=data;
                console.log("GROUPSS",vm.groups);
            });
        };
            
    }
})();