const fs = require('fs');

const firebaseConfig = require('./firebase-config.json');

fs.writeFileSync('./public/firebaseConfig.js', 
`
const firebaseConfig = ${JSON.stringify(firebaseConfig)}
`)