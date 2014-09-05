define([
    "dojo/_base/declare"],
    function(declare) {
    return declare("demo.AutoJsonTemplatedMixin", [], {
      imageBaseUrl: undefined,
      postCreate: function(){
         this.inherited(arguments);

         for(var key in this.json){
           var property = key + "Node";
           if(this.hasOwnProperty(property))
             var node = this[property];
             switch(node.tagName){
               case "IMG":
                 if(this.json[key]){
                   var url = this.imageBaseUrl;
                   url += this.json[key];
                   node.src = url;
                 }
                 break; 
               default:
                 node.innerHTML = key + ":" + this.json[key];
             }
         }
      }
    });
});

