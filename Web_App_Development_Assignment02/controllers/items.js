'use strict';

const logger = require('../utils/logger');
const shelvesStore = require('../models/shelf-store');
const uuid = require('uuid');

const shelf = {
  index(request, response) {
    const shelfId = request.params.id;
    logger.debug('shelfid = ' + shelfId);
    const viewData = {
      title: 'items',
      items: shelvesStore.getShelf(shelfId),
    };
    response.render('items', viewData);
  },
    deleteItem(request, response) {
    const shelfId = request.params.id;
    const itemId = request.params.itemid;
    logger.debug(`Deleting Item ${itemId} from shelf ${shelfId}`);
    shelvesStore.removeItem(shelfId, itemId);
    response.redirect('/items/' + shelfId);
  },
  addItem(request,response){
    const shelfId = request.params.id;
    const shelf = shelvesStore.getShelf(shelfId);
    const newItem = {
      id: uuid(),
      name: request.body.name,
      value: request.body.value,
      description: request.body.description,
    
    };
    shelvesStore.addItem(shelfId,newItem);
    response.redirect('/items/ ' + shelfId);
  }
};

module.exports = shelf;