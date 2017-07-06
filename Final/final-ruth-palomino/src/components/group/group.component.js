(function() {
'use strict';

    // Usage:
    // 
    // Creates:
    // 

    angular
        .module('chat')
        .component('group', {
            //template:'htmlTemplate',
            templateUrl: 'components/group/group.html',
            controller: 'groupController',
            bindings: {
                //Binding: '=',
            },
        });

})();