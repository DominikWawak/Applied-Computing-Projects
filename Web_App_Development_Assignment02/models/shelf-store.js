'use strict';
const _ = require('lodash');
const JsonStore = require('./json-store');

const shelvesStore = {

store: new JsonStore('./models/shelf-store.json', { shelves: [] }),
  collection: 'shelves',

   getAllShelves() {
    return this.store.findAll(this.collection);
  },

  getShelf(id) {
    return this.store.findOneBy(this.collection, { id: id });
  },

  addShelf(shelf) {
    this.store.add(this.collection, shelf);
  },

  removeShelf(id) {
    const shelf = this.getShelf(id);
    this.store.remove(this.collection, shelf);
  },

  /*removeShelf() {
    this.store.removeAll(this.collection);
  },*/

  addItem(id, item) {
    const shelf = this.getShelf(id);
    shelf.items.push(item);
  },

  removeItem(id, itemId) {
    const shelf = this.getShelf(id);
    const items = shelf.items;
    _.remove(items, { id: itemId});
  },
 
  


};


module.exports = shelvesStore;