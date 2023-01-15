require('dotenv').config();
const express = require('express');
const path = require('path');

const firebaseConfig = require("./firebase-config.json");


const app = express();
const port = process.PORT || 8080;

app.use(express.static(path.join(__dirname, 'public')));
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
  res.render('pages/index', {
    ...firebaseConfig,
    vapidKey: process.env.VAPID_KEY
  });
});

app.listen(port, () => {
  console.log(`lisening to port ${port}`);
});