'use strict';

WeatherApp.service('DataExchange', function () {
    var dataExchange;

    var addData = function (newObj) {
        dataExchange = newObj;
    };

    var getData = function () {
        return dataExchange;
    };
    return {
        getData: getData,
        addData: addData
    };
});

WeatherApp.factory('LookupDataResource', function ($resource) {
    return $resource('/partials/lookup-data/:cityName/:countryName', {});
});


WeatherApp.service('KillService', function(KillAppResource) {
    this.kill = function() {
        KillAppResource.get();
    };
});

WeatherApp.factory('KillAppResource', function ($resource) {
    return $resource('/partials/stop', {});
});