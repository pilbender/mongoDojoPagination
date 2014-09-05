define([
    "dojo/_base/declare",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "demo/LazyFetch",
    "demo/AutoJsonTemplatedMixin",
    "dojo/text!./templates/CatalogLineItem.html"],
    function(declare, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, lazyFetch, autoJson, template) {
    return declare("demo.CatalogLineItem", [_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, autoJson], {
      templateString: template,
      widgetsInTemplate: true,
      imageBaseUrl: 'http://images.firstcallonline.com/parts/img/thumb/'
    });
});

