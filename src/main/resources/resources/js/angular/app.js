'use strict';

var WeatherApp = angular.module('WeatherApp', ['ngRoute', 'ngResource', 'ui.router', 'ngMessages']);

WeatherApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('app', {
            abstract: true,
        })
        .state('index', {
            url: '/',
            parent: "app",
            views: {
                'content@': {
                    templateUrl: 'partials/input-city-country-data',
                    controller: 'LookupDataController'
                }
            }
        })
        .state('index.something-went-wrong', {
            parent: 'index',
            url: 'something-went-wrong',
            views: {
                'content@': {
                    templateUrl: 'partials/something-went-wrong.html'
                }
            }
        })
        .state('index.data-not-found', {
            parent: 'index',
            url: 'data-not-found',
            views: {
                'content@': {
                    templateUrl: 'partials/data-not-found',
                    controller: 'LookupDataController'
                }
            }
        });
})