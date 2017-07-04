(function() {
'use strict';

    angular
        .module('chat')
        .controller('messageItemController', MessageItemController);

    MessageItemController.inject = ['$scope'];
    function MessageItemController($scope) {
        $scope.displayMessageItem = false;
    }
})();