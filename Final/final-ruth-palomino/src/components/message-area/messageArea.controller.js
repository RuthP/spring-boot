(function() {
'use strict';

    angular
        .module('chat')
        .controller('messageAreaController', MessageAreaController);

    MessageAreaController.inject = ['$scope'];
    function MessageAreaController($scope) {
        $scope.displayMessageArea = false;
    }
})();