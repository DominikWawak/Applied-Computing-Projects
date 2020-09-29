'use strict';
const _ = require('lodash');
const JsonStore = require('./json-store');

const userStore = {

 store: new JsonStore('./models/users-store.json', { users: [] }),
  collection: 'users',

  // function to get all of the playlists
  getAllUsers() {
    return this.store.findAll(this.collection);
  },
  getUser(id) {
    return this.store.findOneBy(this.collection, { id: id });
  },
  addUser(user){
    this.store.add(this.collection,user);
  },
   /*removeItem(id, itemId) {
    const user = this.getUser(id);
    _.remove(user.items, { id: itemId });
  },*/
  
  removeUser(id) {
    const user = this.getUser(id);
    this.store.remove(this.collection,user);
  
},

};

// export the playlistStore object so it can be used elsewhere
module.exports = userStore;