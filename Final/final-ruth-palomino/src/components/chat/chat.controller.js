(function(){
    'use strict';
    angular
    .module('chat')
    .controller('chatController',chatController);

    chatController.inject = ['$scope', '$rootScope'];
    function chatController($scope, $rootScope){
        var vm = this;
        
        vm.userName = "Ruth";
        vm.message = '';
        vm.connectToChat = connectToChat;
        vm.disconnect = disconnect;
        vm.sendUserName = sendUserName;

        $scope.displayMessage = false;

        $scope.areEmptyFields = function(){
            console.log('click on login');
            if(!$scope.email ||  !$scope.password){
                $scope.displayMessage = true;
                return true;
            }
            $scope.displayMessage = false;
            return false;
        };

       function connectToChat(){
           var socket = new SockJS('http://localhost:9090/chat-ws');
           stompClient = Stomp.over(socket);
           console.log(stompClient);
           stompClient.connect({}, function (frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function (greeting) {
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
       }

       function showGreeting(message){
            $rootScope.$broadcast('messageChat', message);
            vm.message = message;
       }

       function disconnect(){
             if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
       }

       function sendUserName(){
            stompClient.send("/app/hello", {}, JSON.stringify({'name': vm.userName}));
       }

    }
})();