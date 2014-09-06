<p>
  Widget - Declarative
  <div data-dojo-id="catalogStore" data-dojo-type="dojo/store/JsonRest"
       data-dojo-props="target: '/mongoDojoPagination/ajax/example-paging?', idAttribute: 'partNumber'"></div>
  <div data-dojo-type="demo/PageablePresenter" data-dojo-props="store:catalogStore, type:'demo/CatalogLineItem', page:0, pageSize:6"></div>
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
           "demo/Presenter",
           "dojo/domReady!"], function(dom, catalogLineItem, Presenter){
  });
</script>
