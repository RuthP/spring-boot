(function(){
    'use strict';
    angular
    .module('chat')
    .controller('chatController',chatController);

    chatController.inject = ['$scope'];
    function chatController($scope){
        $scope.displayMessage = false;

        $scope.areEmptyFields = function(){
            console.log('click on login');
            if(!$scope.email ||  !$scope.password){
                $scope.displayMessage = true;
                return true;
            }
            $scope.displayMessage = false;
            return false;
        };
    }
})();