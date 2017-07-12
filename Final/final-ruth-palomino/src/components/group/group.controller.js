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
        vm.userEdit = null;
        vm.userDelete = null;
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

        //Save Group
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

        // Get Group to update
        vm.getGroup = function(id){
            return $http.get("http://localhost:9090/groups/"+id).then(function(response){
                //console.log("RESPONSE UPDATE HTTP",response);
                vm.groupEdit=response.data;
                vm.enable="1";
            }, function error(response) {
                console.log("ERROR",response);    
            });
        };

        //Update Group
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

        //Delete Group
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

        //See user from group
        vm.seeUsers = function(id){
            vm.users= groupService.getUsersGroup(id).then(function(data){
                vm.users=data;
                vm.enable = "3";
                vm.enableTable = "1";
                vm.idGroup=id;
                console.log("SEE",vm.users);
            });
            
        };

        vm.getUser = function(idUser){
          return $http.get("http://localhost:9090/users/"+idUser).then(function(response){
                console.log("getUser",response);
                var id = vm.idGroup;
                vm.userEdit=response.data;
                vm.enable="4";
                //vm.seeUsers(id);
            }, function error(response) {
                console.log("ERROR",response);    
            });
        };

        vm.getUserDelete = function(idUser){
          return $http.get("http://localhost:9090/users/"+idUser).then(function(response){
                console.log("getUser",response);
                var id = vm.idGroup;
                vm.userDelete=response.data;
                //vm.enable="4";
                //vm.seeUsers(id);
            }, function error(response) {
                console.log("ERROR",response);    
            });
        };


        vm.updateUser = function(){
          var id = vm.userEdit.id;
          var user = {
            email: vm.userEdit.email,
            firstname: vm.userEdit.firstname,
            lastname: vm.userEdit.lastname,
            username: vm.userEdit.username,
            status:"Active"

          }
          console.log("UPDATEUSER",user);
        };

        //save user from group
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
            return $http.post('http://localhost:9090/users',user).then(function(response){
                var id = vm.idGroup;
                var idNewUser = groupService.getMaxUser().then(function(data){
                    var idNewUser = data[0];
                    console.log("NEWUSER",idNewUser);
                    console.log("GROUP"+id+"USER"+idNewUser);

                    var groupUser = {
                    groupId : id,
                    userId :idNewUser
                    };
                    //console.log("GGGGGGGGGGGGG",groupUser);
                    vm.GroupUser = groupService.saveGroupUser(groupUser).then(function(data){
                        console.log('GROUPUSER',data);
                        vm.seeUsers(id);
                    });
                });
                return response.data;
            }, function error(response) {
                 console.log('ERROR SAVEUSER', response);
            });
        };
        vm.deleteUser = function(id){
            //alert(id);
            var user = {
            email: vm.userDelete.email,
            firstname: vm.userDelete.firstname,
            lastname: vm.userDelete.lastname,
            username: vm.userDelete.username,
            status:"Remove"

          }
            return $http.delete("http://localhost:9090/users/deleteUser/"+id,user).then(function(response){
                 console.log("DELETE",response);
                 //var idOwner = vm.idUser;
                 var idG = vm.idGroup;
                 vm.seeUsers(idG);
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