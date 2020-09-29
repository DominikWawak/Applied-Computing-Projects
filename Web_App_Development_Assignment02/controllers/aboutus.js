'use strict';

// import all required modules
const logger = require('../utils/logger');


// create dashboard object
const aboutus = {

  // index method - responsible for creating and rendering the view
  index(request, response) {

    // display confirmation message in log
    logger.info('aboutpage rendering');

    // create view data object (contains data to be sent to the view e.g. page title)
    const viewData = {
      title: 'About page',
      
      
    };

    // render the dashboard view and pass through the data
    logger.info('about to render', viewData);
    response.render('aboutus', viewData);
    
  },
 
  
};

// export the dashboard module
module.exports = aboutus;