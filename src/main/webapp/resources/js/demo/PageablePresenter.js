define([
    "dojo/_base/declare",
    "demo/Presenter",
    "demo/Pageable",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/domReady!"],
    function(declare, presenter, pageable, _WidgetsInTemplateMixin) {

    return declare("demo.PageablePresenter", [pageable, presenter, _WidgetsInTemplateMixin], {
      templateString: '<div>' + presenter.prototype.templateString + pageable.prototype.templateString + '</div>',
      widgetsInTemplate: true,
      pageSize: 1,
      create: function(){
        this.inherited(arguments);
        this._update();
      },
      onPageChange: function(){
        this._update(); 
      }
    });
});

