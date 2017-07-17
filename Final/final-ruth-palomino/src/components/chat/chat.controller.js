(function(){
    'use strict';
    angular
    .module('chat')
    .controller('chatController',chatController);

    chatController.inject = ['$scope', '$rootScope','groupService','$http','$state'];
    function chatController($scope, $rootScope,groupService,$http,$state){
        var vm = this;
        
        vm.userName = "";
        vm.message = '';
        vm.connectToChat = connectToChat;
        vm.disconnect = disconnect;
        vm.sendUserName = sendUserName;
        vm.usersGroupName = localStorage.getItem("GroupName");
        vm.usersIdChat= localStorage.getItem("IdUser");
        vm.GroupId= localStorage.getItem("IdGroup");
        vm.userChat='';
        console.log("GROUP NAME",vm.usersGroupName);
        console.log("IDCHAT",vm.usersIdChat);

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

        vm.group = function(groupName) {
         console.log("UserLogin",groupName);   
         //localStorage.setItem("GroupName", groupName);
         localStorage.setItem("GroupId", vm.GroupId);
         localStorage.setItem("IdUser", vm.idUser);
         $state.go('group');
        };

        vm.$onInit = function (){
          //vm.getUser = function(idUser){
          return $http.get("http://localhost:9090/users/"+vm.usersIdChat).then(function(response){
                console.log("getUser",response);
                vm.userChat=response.data;
                //vm.seeUsers(id);
            }, function error(response) {
                console.log("ERROR",response);    
            });
         //};
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
           console.log("message",message);
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
           //console.log("SEND",vm.userName);
            stompClient.send("/app/hello", {}, JSON.stringify({'name': vm.userName}));
       }

    }
})();