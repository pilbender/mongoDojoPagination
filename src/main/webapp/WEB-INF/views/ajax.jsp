<p>
  Widget - Declarative
  <div data-dojo-id="catalogStore" data-dojo-type="dojo/store/JsonRest"
       data-dojo-props="target: '/mongoDojoPagination/ajax/example-paging?', idAttribute: 'partNumber'"></div>
  <div data-dojo-type="demo/PageablePresenter" data-dojo-props="store:catalogStore, type:'demo/CatalogLineItem', page:1, pageSize:3"></div>
</p>

<p>
  Widget - CatalogLine Item Programmatic
  <div id="catalogLineItemWidgetId"></div>
  <div id="presenterWidgetId"></div>
</p> 

<script data-dojo-config="async: 1, dojoBlankHtmlUrl: '/blank.html',
   packages: [ {
     name: 'demo',
     location: location.pathname.replace(/\/[^/]+$/, '') + '/resources/js/demo'
   } ]"
   src="//ajax.googleapis.com/ajax/libs/dojo/1.9.2/dojo/dojo.js">
</script>

<script>
  require(["dojo/dom",
           "demo/CatalogLineItem",
           "dojo/domReady!"], function(dom, CatalogLineItem) {
    catalogLineItemDijit = new CatalogLineItem({
      json:{ 
          img: "resources/images/51515.jpg",
          line: "fram",
          partNumber: "ph8a",
          list: "$11.00",
          cost: "$5.75",
          productNameInfo: "Dimensions: Panel; Height: 1.188 In.; Outside Length: 9.25 In.; Outside Width: 7.5 In." 
      }}).placeAt(dom.byId("catalogLineItemWidgetId"));
  });
</script>

<script>
  require(["dojo/dom",
           "demo/Presenter",
           "dojo/domReady!"], function(dom, Presenter){
    restfullPresenter =  new Presenter().placeAt(dom.byId("presenterWidgetId"));
  });
</script>
