require('dotenv').config();
const admin = require("firebase-admin");
const { getMessaging } = require('firebase-admin/messaging')

const serviceAccount = require("./service-account.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount)
});

const registrationToken = process.env.REGISTRATION_TOKEN;

const message = {
  notification: {
    title: "FCM Message",
    body: "This is an FCM Message",
  },
  webpush: {
    notification: {
      body: 'which?',
      icon: "https://www.logoarena.com/contestimages/public_new/9345/12536_1544527702_50501.png"
    },
    fcm_options: {
      link: `http://localhost:${process.env.PORT}/`
    }
  },
  data: {
    custom: "hello"
  },
  token: registrationToken
};

// Send a message to the device corresponding to the provided
// registration token.
getMessaging().send(message)
  .then((response) => {
    // Response is a message ID string.
    console.log('Successfully sent message:', response);
  })
  .catch((error) => {
    console.log('Error sending message:', error);
  });
