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
      sort: [
        { descending: true }
      ],

      create: function(){
         this.inherited(arguments);
      },
  
      _update: function(){
         domConstruct.empty(this.contentNode);
         if(this.store){
           var results = this.store.query(this.query);
           results.forEach(dojo.hitch(this, function(result, i){
             if(this.type){
               require([this.type], dojo.hitch(this, function(type){
                 var div = domConstruct.create("div", null, this.contentNode);
                 new type({json:result}).placeAt(div);
               }));
             } 
           }));
         }
      }
    });
});

