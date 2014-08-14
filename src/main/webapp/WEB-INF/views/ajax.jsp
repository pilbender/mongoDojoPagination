    <p>
        Dynamic content: ${message}
    </p>
    <p>
        <b>Mongo content:</b> partNumber: ${mongo.partNumber} ${mongo.partName}
    </p>
    <p>
        AJAX Message
        <div id="ajaxGet">loading...</div>
    </p>

    <%--<script src="//ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/dojo.js" data-dojo-config="async: true" ></script> --%>

    <!-- blank.html is not yet defined in this application -->
    <script data-dojo-config="async: 1, dojoBlankHtmlUrl: '/blank.html',
        packages: [ {
            name: 'demo',
            location: location.pathname.replace(/\/[^/]+$/, '') + '/resources/js/demo'
        } ]"
            <%-- This is the compressed version for speed --%>
            src="//ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/dojo.js"></script>
            <%-- This is the uncompressed version for debugging --%>
            <%--src="//ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/dojo.js.uncompressed.js"></script>--%>
    <script>
        require(["dojo/dom", "dojo/request", "dojo/json",
            "dojo/_base/array", "dojo/domReady!"], function(dom, request, JSON, arrayUtil){
            // Put the response in the DOM
            var resultDiv = dom.byId("ajaxGet");

            // Request the JSON data from the server
            request.get("ajax/example-data", {
                // Parse data from JSON to a JavaScript object
                handleAs: "json"
            }).then(function(data){
                        // Display the data sent from the server
                        resultDiv.innerHTML = data.status;
                    },
                    function(error){
                        // Display the error returned
                        resultDiv.innerHTML = error;
                    });
        });

        require(["dojo/store/JsonRest"], function(JsonRest){
            var store = new JsonRest({
                target: "/mongoDojoPagination/ajax/example-paging?",
                idProperty: "partNumber"
            });

            // Not used right now.
            // Get an object by identity
            /*store.get(id).then(function(item){
                // item will be the DB item
            });*/

            // Query for objects with options
            store.query("attribute=partNumber", {
                start: 0,
                count: 1,
                sort: [
                    { attribute: "partNumber", descending: true }
                ]
            }).then(function(results){
                // results should contain up to 10 items, sorted by "baz" in descending fashion
            });

            // Not used right now.
            // Store an object identified by identity
            /*store.put({
                foo: "bar"
            }, {
                id: 3
            });*/

            // Not used right now.
            // Remove an object by ID
            /*store.remove(3);*/
        });
    </script>
