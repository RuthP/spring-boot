(function() {
'use strict';

    angular
    .module('chat')
    .directive('chatForm', ChatDirective);


    ChatDirective.inject = [];
    function ChatDirective() {

        var directive = {
            bindToController: true,
            controller: 'chatController',
            controllerAs: 'vm',
            templateUrl: 'html/chat.html',
            link:link,
            restrict:'E',
            $scope:{

            }

        };
        return directive;
        function link (scope, element, attrs){
        }
    }
})();