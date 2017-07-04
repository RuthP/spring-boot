(function() {
'use strict';
    angular
    .module('messageArea')
    .directive('messageAreaForm',MessageAreaDirective);

    MessageAreaDirective.inject = [];
    function MessageAreaDirective(){
        
    var directive = {
        bindToController: true,
        controller:'messageAreaController',
        controllerAs: 'vm',
        templateUrl:'html/messageArea.html',
        link:link,
        restrict: 'E',
        $scope:{

        }

    };
    return directive;
    function link(scope, element, attrs){
        }
  }
})();