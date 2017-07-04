(function() {
'use strict';

    angular
        .module('chat')
        .controller('userItemController', UserItemController);

    UserItemController.inject = ['$scope'];
    function UserItemController($scope) {
        $scope.displayMessageUserItem = false;
    }
})();