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
                    <td><button class='btn btn-primary'>Open</button></td>
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

    return {
        getBlueprintsByAuthor: getBlueprintsByAuthor
    }

})();