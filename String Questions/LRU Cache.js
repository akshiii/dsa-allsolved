// LRU(Least Recently Used) Cache

// A map will have 5 items only, if we want to add new item then remove the least recently used item from map.
//  the least recently used item from map will be the oldest one added, and if u read/access any element then shift that to top of map

class LRU {
  constructor(max) {
    this.max = max;
    this.cache = new Map();
  }

  set(key, value) {
    if (this.cache.has(key)) this.cache.delete(key);
    else if (this.cache.size === this.max) {
      this.cache.delete(this.first());
    }

    this.cache.set(key, value);
  }

  first() {
    console.log("This first item is :", this.cache.keys().next().value);
    return this.cache.keys().next().value;
  }

  get(key) {
    let item = this.cache.get(key);

    if (item) {
      this.cache.delete(key);
      this.cache.set(key, item);
    }

    return item;
  }
}

let LRUcache = new LRU(3);
LRUcache.set("name", "akshi");
LRUcache.set("age", "27");
LRUcache.set("gender", "female");

console.log(LRUcache.cache);

LRUcache.get("name");
console.log(LRUcache.cache);

LRUcache.set("address", "cuttack");
console.log(LRUcache.cache);
