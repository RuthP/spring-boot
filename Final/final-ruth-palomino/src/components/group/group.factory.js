(function() {
'use strict';

    angular
        .module('chat')
        .factory('groupService', GroupService);

    GroupService.inject = ['$http','$q'];
    function GroupService($http,$q) {
        var service = {
            getGroups:getGroups
        };
        
        return service;

        ////////////////
        function getGroups() {
            return loadJSON();
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

         function loadJSON(jsonFile){
             return $http.get('http://localhost:9090/groups').then(function(response){
                console.log("RESPONSE FROM JSON FILE GROUP",response);
                return response.data;

             },function (error){
                 console.log("FAIL TO LOAD",error);
             });
         } 

         function saveGroup (group){
             return $http.post('http://localhost:9090/groups'+group).then(function(response){
                 console.log("RESPONSE SAVE HTTP",response);
                 return response.data;
             },function (error){
                 console.log('FAIL TO LOAD',error);
             });    
         }
    }
})();