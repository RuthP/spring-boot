(function() {
    'use strict';

    angular
        .module('messageItem')
        .directive('messageItemForm', MessageItemDirective);

    MessageItemDirective.inject = [];
    function MessageItemDirective() {
        var directive = {
            bindToController: true,
            controller: 'messageItemController',
            controllerAs: 'vm',
            templateUrl:'html/messageItem.html',
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