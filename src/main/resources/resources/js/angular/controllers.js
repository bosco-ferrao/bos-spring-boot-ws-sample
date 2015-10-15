'use strict';

function stringEmpty(str) {
    return str.length === 0 || !str.trim();
}

WeatherApp.controller('LookupDataController', function ($scope, $state, LookupDataResource) {

    $scope.barcode = '';
    $scope.submit = function () {

        if (!stringEmpty($scope.countryName)) {
            LookupDataResource.get({cityName: $scope.cityName, countryName: $scope.countryName},
                function (data) {
            	var x2js = new X2JS();
            	console.log("Response was: " + JSON.stringify(x2js.xml_str2json(data.getWeatherResult)));
            	$scope.CurrentWeather = x2js.xml_str2json(data.getWeatherResult).CurrentWeather;
//            	$scope.CurrentWeather = x2js.xml_str2json(data.getWeatherResult);
//            	$scope.jsonData = x2js.xml_str2json(data);
//                    console.log("Response was: " + );
//                    $scope.data2 = {
//                        'status': data.actionState,
//                    };
                },
                function (err) {
                    if (err.status == 404) {
                        $state.go("index.data-not-found");
                        console.log('Get Failed: ', err.status);
                    } else {
                        $state.go("index.something-went-wrong");
                        console.log('Oops: ', err.status);
                    }
                });
        }
    }
});


WeatherApp.controller('KillAppController', function ($scope, KillService) {
    $scope.kill = function() {
        KillService.kill();
    };

});