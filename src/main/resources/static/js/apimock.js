
apimock = (function () {

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
            name: "bike",
            points: [
                {
                    x: 30,
                    y: 45
                },
                {
                    x: 40,
                    y: 45
                }
            ]
        }
    ];

    return {
        getBlueprintByAuthor: function (name, callback) {
            callback(
                mockdata[name]
            );
        }
    }

})();