define([
    "dojo/_base/declare",
    "dijit/form/Button",
    "dojo/on",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/text!./templates/Pageable.html",
    "dojo/domReady!"],
    function(declare, Button, on, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, template) {

    return declare("demo.Pageable", [_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
      templateString: template,
      widgetsInTemplate: true,
      store: undefined,
      type: undefined,
      pageSize: 10,
      page: 0,
      query: {
             start: this.page * this.pageSize,
             count: this.pageSize-1,
             sort: this.sort
           },
      postCreate: function(){
        // Next
        on (this.nextNode, "click", dojo.hitch(this, function(event) {
          this.page++;
          this.onPageChange();
        }));

        // Previous
        on (this.prevNode, "click", dojo.hitch(this, function(event) {
          this.page--;
        }));
      },
      onPageChange: function(){
      }
    });
});

