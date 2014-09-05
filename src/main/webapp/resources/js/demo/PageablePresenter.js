define([
    "dojo/_base/declare",
    "demo/Presenter",
    "demo/Pageable",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/domReady!"],
    function(declare, presenter, pageable, _WidgetsInTemplateMixin) {

    return declare("demo.PageablePresenter", [presenter, pageable, _WidgetsInTemplateMixin], {
      templateString: '<div>' + presenter.prototype.templateString + pageable.prototype.templateString + '</div>',
      widgetsInTemplate: true,
      pageSize: 2,
      create: function(){
        this.inherited(arguments);
      }
    });
});

