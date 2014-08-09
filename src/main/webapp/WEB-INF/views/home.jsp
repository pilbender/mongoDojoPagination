<div id="myAutoRotator1" class="rotator"></div>

<button onclick="dojo.publish('myAutoRotator1/rotator/control', ['prev']);">Prev</button>
<button onclick="dojo.publish('myAutoRotator1/rotator/control', ['go', 0]);">Go 1</button>
<button onclick="dojo.publish('myAutoRotator1/rotator/control', ['go', 1]);">Go 2</button>
<button onclick="dojo.publish('myAutoRotator1/rotator/control', ['go', 2]);">Go 3</button>
<button onclick="dojo.publish('myAutoRotator1/rotator/control', ['next']);">Next</button>

    <%--<script src="//ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/dojo.js" data-dojo-config="async: true" ></script> --%>

    <!-- blank.html is not yet defined in this application -->
<script data-dojo-config="async: 1, dojoBlankHtmlUrl: '/blank.html', parseOnLoad: false,
        packages: [ {
            name: 'demo',
            location: location.pathname.replace(/\/[^/]+$/, '') + '/resources/js/demo'
        } ]"
<%-- This is the compressed version for speed --%>
        src="//ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/dojo.js"></script>
            <%-- This is the uncompressed version for debugging --%>
            <%--src="//ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/dojo.js.uncompressed.js"></script>--%>
<script>
    require(["dojo/dom", "dojox/widget/AutoRotator", "dojox/widget/rotator/Pan",
        "dojo/domReady!"], function (dom, AutoRotator, Pan) {
        new dojox.widget.AutoRotator(
                {
                    transition: "dojox.widget.rotator.pan",
                    transitionParams: "quick:true,continuous:true",
                    duration: 2500,
                    panes: [
                        { className: "pane pane0", innerHTML: "<h3>Dojo</h3><p>Tons of features like CSS-based queries, event handling, animations, Ajax, class-based programming, and a package system</p>" },
                        { className: "pane pane1", innerHTML: "<h3>Dijit</h3><p>Dojo's themeable, accessible, easy-to-customize UI Library</p>" },
                        { className: "pane pane2", innerHTML: "<h3>DojoX</h3><p>Dojo eXtensions</p>" }
                    ]

                },
                dom.byId("myAutoRotator1")
        );
    });

</script>

