var app = (function () {

    var getBlueprintsByAuthor = function (author) {
        return apimock.getBlueprintsByAuthor(author, function (err, data) {
            if (err) {
                return new Error("Error obteniendo los blueprints:" + err)
            }
            $('#table-author').html(author + "'s blueprints");
            var table = $('#table')
            table.empty();
            table.append(`
            <thead class="thead-dark">
                <tr>
                    <th>Blueprint name</th>
                    <th>Number of points</th>
                    <th>Open</th>
                </tr>
            </thead>
            `)
            var rows = data.map(function (x) {
                return (
                    `<tr>
                    <td>` + x.name + `</td>
                    <td>` + x.points.length + `</td>
                    <td><button class='btn btn-primary' onClick="app.getBlueprintsByNameAndAuthor('`+ x.author + `', '` + x.name + `')">Open</button></td>
                </tr>`);
            });
            rows.forEach(function (row) {
                table.append(row);
            })
            $('#points-counter').html('Total user points: ' + data.reduce(function (total, blueprint) {
                return total = total + blueprint.points.length;
            }, 0))
        });
    }

    var getBlueprintsByNameAndAuthor = function (author, name) {
        return apimock.getBlueprintsByNameAndAuthor(author, name, function (err, data) {
            if (err) {
                return new Error("Error obteniendo el blueprint:" + err)
            }
            $('#current-name').html("Current blueprint: " + name);
            var canvas = $('#myCanvas');
            var context = canvas[0].getContext("2d");
            context.clearRect(0, 0, canvas[0].width, canvas[0].height);
            context.beginPath();
            context.moveTo(data.points[0].x, data.points[0].y);
            data.points.forEach(function (point) {
                context.lineTo(point.x, point.y);
                context.moveTo(point.x, point.y);
            })
            context.stroke();
        })
    }

    return {
        getBlueprintsByAuthor: getBlueprintsByAuthor,
        getBlueprintsByNameAndAuthor: getBlueprintsByNameAndAuthor
    }

})();