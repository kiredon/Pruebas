

app.controller("testCtrl", function ($scope, $timeout,cfpLoadingBar,MensajesService) {

            var nameList = ['Pierre', 'Pol', 'Jacques', 'Robert', 'Elisa'];
            var familyName = ['Dupont', 'Germain', 'Delcourt', 'bjip', 'Menez'];

            $scope.isLoading = false;
            $scope.rowCollection = [];
            

            function createRandomItem() {
                var
                    firstName = nameList[Math.floor(Math.random() * 4)],
                    lastName = familyName[Math.floor(Math.random() * 4)],
                    age = Math.floor(Math.random() * 100),
                    email = firstName + lastName + '@whatever.com',
                    balance = Math.random() * 3000;

                return {
                    firstName: firstName,
                    lastName: lastName,
                    age: age,
                    email: email,
                    balance: balance
                };
            }

            function getAPage() {
                var data = [];
                for (var j = 0; j < 20; j++) {
                    data.push(createRandomItem());
                }
                return data;
            }

            var lastStart = 0;
            var maxNodes = 40;

            $scope.callServer = function getData(tableState) {

                //here you could create a query string from tableState
                //fake ajax call
                $scope.isLoading = true;

                $timeout(function () {

                    //if we reset (like after a search or an order)
                    if (tableState.pagination.start === 0) {
                        $scope.rowCollection = getAPage();
                    } else {
                        //we load more
                        $scope.rowCollection = $scope.rowCollection.concat(getAPage());

                        //remove first nodes if needed
                        if (lastStart < tableState.pagination.start && $scope.rowCollection.length > maxNodes) {
                            //remove the first nodes
                            $scope.rowCollection.splice(0, 20);
                        }
                    }

                    lastStart = tableState.pagination.start;

                    $scope.isLoading = false;
                }, 1000);

            };

            $scope.rowCollection = getAPage();

        }
    );