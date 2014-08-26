define([
    "dojo/_base/declare",
    "dojo/dom-construct",
    "dojo/dom",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dojo/text!./templates/Presenter.html",
    "dojo/domReady!"],
    function(declare, domConstruct, dom, _WidgetBase, _TemplatedMixin, template) {

    return declare("demo.Presenter", [_WidgetBase, _TemplatedMixin], {
      templateString: template,
      store: undefined,
      type: undefined,
      query: {},
      queryAttr: "year=2012",
      sort: [{ attribute: "partNumber", descending: true }],

      create: function(){
         this.inherited(arguments);
      },
  
      update: function(){
        if(this.type){
          require([this.type], dojo.hitch(this, function(type){
          domConstruct.empty(this.contentNode);

						if(this.store){
							var results = this.store.query(this.queryAttr, this.query);
							results.forEach(dojo.hitch(this, function(result, i){
									 var div = domConstruct.create("div", null, this.contentNode);
										new type({json:result}).placeAt(div);
							}));
						}
					}));
        } 
      }
    });
});

