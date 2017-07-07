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

         function loadJSON(jsonFile){
             return $http.get('http://localhost:9090/groups').then(function(response){
                console.log("RESPONSE FROM JSON FILE GROUP",response);
                return response.data;

             },function (error){
                 console.log("FAIL TO LOAD",error);
             });
         } 
    }
})();