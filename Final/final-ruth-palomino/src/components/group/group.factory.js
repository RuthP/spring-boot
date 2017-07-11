(function() {
'use strict';

    angular
        .module('chat')
        .factory('groupService', GroupService);

    GroupService.inject = ['$http','$q'];
    function GroupService($http,$q) {
        var service = {
            getGroupsByUser:getGroupsByUser,
            getGroupsByOwner:getGroupsByOwner,
            getGroups:getGroups
        };
        
        return service;

        function getGroups(id){
            return $http.get("http://localhost:9090/groups/isOwner/"+id).then(function(response){
                //var owner =valueOf(data);
                //vm.owner=data.data;
                if(response.data===false){
                    console.log("FALSE","0");
                    return getGroupsByUser(id);  
                }else {
                    console.log("TRUE","1"); 
                    return getGroupsByOwner(id);
                }
            }, function error(response) {
            console.log('ERROR GROUPS', response);
            });
        }

        function getGroupsByUser(id) {
            return user(id);
         }

         function getGroupsByOwner(id) {
            return owner(id);
         }

         function getUserGroup(id){
             console.log("iddd",id);
             return getUser(id);
         }

         function getUser(id){
             console.log("ID",id);
             return $http.get('http://localhost:9090/users/'+id).then(function(response){
                 console.log("User by groups",response);
                 return response.data;
             },function (error){
                 console.log("FAIL TO LOAD",error);
             });
         }

         function user(id){
             return $http.get('http://localhost:9090/groups/user/'+id).then(function(response){
                console.log("RESPONSE FROM JSON FILE GROUP",response);
                return response.data;

             },function (error){
                 console.log("FAIL TO LOAD",error);
             });
         } 

         function owner(id){
             return $http.get('http://localhost:9090/groups/owner/'+id).then(function(response){
                console.log("RESPONSE FROM JSON FILE GROUP",response);
                return response.data;

             },function (error){
                 console.log("FAIL TO LOAD",error);
             });
         } 

         /*function saveGroup (group){
             return $http.post('http://localhost:9090/groups'+group).then(function(response){
                 console.log("RESPONSE SAVE HTTP",response);
                 return response.data;
             },function (error){
                 console.log('FAIL TO LOAD',error);
             });    
         }*/
    }
})();