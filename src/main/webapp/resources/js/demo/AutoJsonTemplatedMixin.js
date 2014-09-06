define([
    "dojo/_base/declare"],
    function(declare) {
    return declare("demo.AutoJsonTemplatedMixin", [], {
      imageBaseUrl: undefined,
      postCreate: function(){
         this.inherited(arguments);

         for(var key in this.json){
           var property = key + "Node";
           if(this.hasOwnProperty(property)){
             var node = this[property];
             switch(node.tagName){
               case "IMG":
                 var url = this.json[key];
                 if(url && url != "NULL"){
                   node.src = this.imageBaseUrl + url;
                 }
                 break; 
               default:
                 node.innerHTML = key + ":" + this.json[key];
             }
           }
         }
      }
    });
});

