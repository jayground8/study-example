const express = require('express');
const app = express();

function timeout(seconds) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("success")
    }, seconds * 1000)
  })
}

app.get('/hello', async (req, res) => {
  // await timeout(4)
  res.send('world!')
});

app.listen(3000, () => {
  console.log("started");
});