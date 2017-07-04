(function() {
    'use strict';

    angular
        .module('messageList')
        .directive('messageListForm', MessageListDirective);

    MessageListDirective.inject = [];
    function MessageListDirective() {
        var directive = {
            bindToController: true,
            controller: 'messageListController',
            controllerAs: 'vm',
            templateUrl: 'html/messageList.html',
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