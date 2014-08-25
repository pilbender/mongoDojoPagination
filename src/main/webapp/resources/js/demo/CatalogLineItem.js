define([
    "dojo/_base/declare",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "demo/LazyFetch",
    "dojo/text!./templates/CatalogLineItem.html"],
    function(declare, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, lazyFetch, template) {
    return declare("demo.CatalogLineItem", [_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
      templateString: template,
      widgetsInTemplate: true,
      postCreate: function(){
         this.inherited(arguments);
         if(this.json.img)
           this.imageNode.src = this.json.img;
         if(this.json.line)
           this.lineNode.innerHTML = this.json.line;
         if(this.json.partNumber)
           this.partnumberNode.innerHTML = this.json.partNumber;
         if(this.json.list)
           this.listNode.innerHTML = this.json.list;
         if(this.json.cost)
           this.costNode.innerHTML = this.json.cost;
         if(this.json.productNameInfo)
           this.productNameInfoNode.innerHTML = this.json.productNameInfo;
         if(this.json.partName)
           this.partNameNode.innerHTML = this.json.partName;
      }
    });
});

