'use strict';

// import express and initialise router
const express = require('express');
const router = express.Router();

// import controllers
const start = require('./controllers/start.js');
const userpage = require('./controllers/userpage.js');
const items = require('./controllers/items.js');
const shelf = require('./controllers/shelf.js');
const aboutus = require('./controllers/aboutus.js');



// connect routes to controllers
router.get('/', start.index);
router.get('/userpage',userpage.index);
router.get('/shelf',shelf.index);
router.get('/aboutus',aboutus.index);


router.get('/items/:id', items.index);



router.get('/userpage/deleteUser/:id', userpage.deleteUser);
router.get('/shelf/deleteShelf/:id', shelf.deleteShelf);

router.get('/items/:id/deleteItem/:itemid', items.deleteItem);
router.post('/items/:id/additem',items.addItem);
router.post('/shelf/addshelf',shelf.addShelf);
router.post('/userpage/adduser',userpage.addUser);


// export router module
module.exports = router;

