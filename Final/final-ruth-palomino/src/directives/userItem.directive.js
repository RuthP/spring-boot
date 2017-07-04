(function() {
    'use strict';

    angular
        .module('userItem')
        .directive('userItemForm', UserItemDirective);

    UserItemDirective.inject = [];
    function UserItemDirective() {
        var directive = {
            bindToController: true,
            controller: 'userItemController',
            controllerAs: 'vm',
            templateUrl:'html/userItem.html',
            link: link,
            restrict: 'E',
            scope: {
            }
        };
        return directive;
        
        function link(scope, element, attrs) {
        }
    }
})();