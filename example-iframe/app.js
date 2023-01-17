const express = require('express');
const path = require('path');
const app = express();
app.use(express.json());
app.use(express.urlencoded({extended: false}));

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

app.get('/landing', (req, res) => {
  res.sendFile(path.join(__dirname, 'landing.html'));
});

app.post('/one', (req, res) => {
  console.log(`one: ${JSON.stringify(req.body)}`);
  res.sendFile(path.join(__dirname, 'one.html'));
});

app.post('/two', (req, res) => {
  console.log(`two: ${JSON.stringify(req.body)}`);
  res.sendFile(path.join(__dirname, 'two.html'));
})

app.post('/three', (req, res) => {
  console.log(`three: ${JSON.stringify(req.body)}`);
  res.sendFile(path.join(__dirname, 'three.html'));
})

app.listen(8088, () => {
  console.log("started!")
})