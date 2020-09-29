'use strict';

// import all required modules
const logger = require('../utils/logger');
const usersStore = require('../models/users-store.js');
const uuid = require('uuid');

// create dashboard object
const userpage = {

  // index method - responsible for creating and rendering the view
  index(request, response) {

    // display confirmation message in log
    logger.info('userpage rendering');

    // create view data object (contains data to be sent to the view e.g. page title)
    const viewData = {
      title: 'Users page',
      users: usersStore.getAllUsers(),
      
    };

    // render the dashboard view and pass through the data
    logger.info('about to render', viewData.users);
    response.render('userpage', viewData);
    
  },
  deleteUser(request, response) {
    const userId = request.params.id;
    
    logger.debug(`Deleting user ${userId}`);
    usersStore.removeUser(userId);
    response.redirect('/userpage');
  },
    addUser(request, response) {
    const newUser = {
      id: uuid(),
      nick: request.body.nick,
      
      
    };
    usersStore.addUser(newUser);
    response.redirect('/userpage');
  },
  
};

// export the dashboard module
module.exports = userpage;