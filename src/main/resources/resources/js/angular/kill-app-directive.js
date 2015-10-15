WeatherApp
    .directive('killapp', function () {
        return {
            restrict:'E',
            controller: 'KillAppController',
            template: "<a class='btn btn-lg btn-primary' ng-click='kill()'>Exit</a>"
        };
    });
