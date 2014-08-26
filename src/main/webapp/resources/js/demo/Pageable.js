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
      pageSize: 10,
      page: undefined,
      postCreate: function(){
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

        if(page >= 0){
          this.page = page;
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

