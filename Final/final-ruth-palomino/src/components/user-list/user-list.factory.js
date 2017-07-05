(function() {
'use strict';

    angular
        .module('chat')
        .factory('userService', UserService);

    UserService.inject = ['$http','$q'];
    function UserService($http,$q) {
        var service = {
            getUsers:getUsers,
            updateUsers:updateUsers
        };
        
        return service;

        ////////////////
        function getUsers() {
            return loadJSON();
         }

         function loadJSON(jsonFile){
             return $http.get('http://localhost:9090/users').then(function(response){
                console.log("RESPONSE FROM JSON FILE",response);
                return response.data;

             },function (error){
                 console.log("FAIL TO LOAD",error);
             });
         }     

         function updateUsers(){
             var promises = [updateA(),updateB(),updateC()];
             $q.all(promises).then(function(values){
                console.log(values[0]);
                console.log(values[1]);
                console.log(values[2]);

             });
         }

         function updateA(){
             var defered = $q.defer();
             var promise = defered.promise;

             defered.resolve('USER A HAS BEEN UPDATE');
             //defered.reject('ERROR UPDATING A');
             return promise;
         }

         function updateB(){
             var defered = $q.defer();
             var promise = defered.promise;

             defered.resolve('USER B HAS BEEN UPDATE');
             //defered.reject('ERROR UPDATING B');
             return promise;
         }

         function updateC(){
             var defered = $q.defer();
             var promise = defered.promise;

             defered.resolve('USER C HAS BEEN UPDATE');
             //defered.reject('ERROR UPDATING C');
             return promise;
         }
  
    }
})();