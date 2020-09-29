'use strict';

// import all required modules
const logger = require('../utils/logger');
const shelfStore = require('../models/shelf-store.js');
const uuid = require('uuid');



// create about object
const shelf = {
  
  // index method - responsible for creating and rendering the view
  index(request, response) {
    
    // display confirmation message in log
    logger.info('about rendering');
    
    // create view data object (contains data to be sent to the view e.g. page title)
    const viewData = {
      title: 'Your shelf',
      shelves: shelfStore.getAllShelves(),
    };
    
    // render the about view and pass through the data
    response.render('shelf', viewData);
  },
    
  deleteShelf(request, response) {
    const shelfId = request.params.id;
    logger.debug(`Deleting shelf ${shelfId}`);
    shelfStore.removeShelf(shelfId);
    response.redirect('/shelf');
  },
  addShelf(request, response) {
    const newShelf = {
      id: uuid(),
      title: request.body.title,
      description: request.body.description,
      items: [],
    };
    shelfStore.addShelf(newShelf);
    response.redirect('/shelf');
  },
};

// export the about module
module.exports = shelf;