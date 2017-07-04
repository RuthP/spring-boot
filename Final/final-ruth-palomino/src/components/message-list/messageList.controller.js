(function() {
'use strict';

    angular
        .module('chat')
        .controller('messageListController', MessageListController);

    MessageListController.inject = ['messageService'];
    function MessageListController(messageService) {
        var vm= this;
        vm.messages = [];

        vm.$onInit = function (){
            vm.messages = messageService.getMessages().then(function(data){
                vm.messages=data.messages;
                console.log("MESSAGES",vm.messages);
            });
        };
    }
})();