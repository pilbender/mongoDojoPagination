define([
    "dojo/_base/declare",
    "dijit/form/Button",
    "dijit/form/NumberSpinner",
    "dojo/on",
    "dijit/_WidgetBase",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/text!./templates/Pageable.html",
    "dojo/domReady!"],
    function(declare, Button, NumberSpinner, on, _WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin, template) {

    return declare("demo.Pageable", [_WidgetBase, _TemplatedMixin, _WidgetsInTemplateMixin], {
      templateString: template,
      widgetsInTemplate: true,
      pageSize: 10,
      page: undefined,
      postCreate: function(){

        // NumberSpinner
        this.pageSpinnerNode.set("intermediateChanges", true);
        this.pageSpinnerNode.set("constraints", {min:0, max: 3});
        this.pageSpinnerNode.set("value", this.page);
        this.watch("page", function(attr, oldVal, newVal){
          this.pageSpinnerNode.set("value", newVal, false);
        });
        on(this.pageSpinnerNode, "change", dojo.hitch(this, function(value){
          this.onChange(value);
        }));

        // Next
        on (this.nextNode, "click", dojo.hitch(this, function(event) {
          this.set("page", this.page + 1);
        }));

        // Previous
        on (this.prevNode, "click", dojo.hitch(this, function(event) {
          this.set("page", this.page - 1);
        }));
      
        if(!this.page)
          this.set("page", 0);
      },
      onChange: function(page){
        if(page != this.page && page >= 0){
          this._set("page", page);
          this.query = {
             start: this.page * this.pageSize,
             count: this.pageSize,
             sort: this.sort
          };
          this.update();
        }
      },
      _setPageAttr: function (page){
        this.onChange(page);
      }
    });
});

