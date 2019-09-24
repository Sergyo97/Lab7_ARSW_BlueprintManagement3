var apimock = (function () {

    var mockdata = [];

    mockdata["JohnConnor"] = [
        {
            author: "JohnConnor",
            name: "house",
            points: [
                {
                    x: 10,
                    y: 20
                },
                {
                    x: 15,
                    y: 25
                }
            ]
        },
        {
            author: "JohnConnor",
            name: "gear",
            points: [
                {
                    x: 30,
                    y: 45
                },
                {
                    x: 40,
                    y: 55
                }
            ]
        }
    ];

    return {
        getBlueprintsByAuthor: function (author, callback) {
            callback(null, mockdata[author]);
        },

        getBlueprintsByNameAndAuthor: function (author, name, callback) {
            callback(null, mockdata[author].find(function(blueprint) {
                return blueprint.name === name;
            }))
        }
    }

})();