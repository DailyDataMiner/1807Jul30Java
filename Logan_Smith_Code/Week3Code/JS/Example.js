
function Person() {
    let name = "";
    let address = "";
    let secret = "I am a dog.";
    this.setName = function(newName) { this.name = newName }
    this.getName = function() { return name; }
    this.getRealName = function() {return this.name; }
    this.setAddress = function(newAddress) { this.address = newAddress }
    this.tellSecret = function() { return secret }
 }
  
 var a = new Person("Max", "1965 SW 35th St.");
  
 a.name; //> “Max”
 a.setName("Oliver");
 a.name; //> “Oliver”
 a.getName(); //>"Max"
 a.getRealName(); //>"Oliver"
  
 a.address; //> "1965 SW 35th St.”
 a.setAddress("6743 Addie Triplet Lane");
 a.address; //> "6743 Addie Triplet Lane"

a.secret; //> Undefined
a.tellSecret(); //> "I am a dog."