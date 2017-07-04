(function() {
    'use strict';

    angular
        .module('userList')
        .directive('userListForm', UserListDirective);

    UserListDirective.inject = [];
    function UserListDirective() {
        var directive = {
            bindToController: true,
            controller: 'userListController',
            controllerAs: 'vm',
            templateUrl:'html/userList.html',
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