(function() {
'use strict';

    angular
        .module('chat')
        .factory('messageService', MessageService);

    MessageService.inject = ['$http'];
    function MessageService($http) {
        var service = {
            getMessages:getMessages
        };
        
        return service;
        ////////////////
        function getMessages() { 
            return loadJSON('/json/messages.json');
        }

        function loadJSON(jsonFile){
            return $http.get(jsonFile).then(function(response){
                return response.data;
            },function(error){
                console.log("FAIL TO LOAD",error);
            });
        }
    }
})();