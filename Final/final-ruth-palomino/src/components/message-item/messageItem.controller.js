(function() {
'use strict';

    angular
        .module('chat')
        .controller('messageItemController', MessageItemController);

    MessageItemController.inject = ['$scope', '$rootScope'];
    function MessageItemController($scope, $rootScope) {
        var vm = this;
        $scope.displayMessageItem = false;
        vm.messageItem = '';

        $rootScope.$on('messageChat', function(evt, message){
            console.log(message);
            vm.messageItem = message;
            console.log("------>"+vm.messageItem);
            $scope.$apply();
        });
    }


})();