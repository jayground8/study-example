# Firebase Messaging Web Example

## 추가해야 할 파일들

`service-account.json`
```json
{
  "type": "service_account",
  "project_id": "...",
  "private_key_id": "...",
  "private_key": "...",
  "client_email": "...",
  "client_id": "...",
  "auth_uri": "https://accounts.google.com/o/oauth2/auth",
  "token_uri": "https://oauth2.googleapis.com/token",
  "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
  "client_x509_cert_url": "..."
}
```

`firebase-config.json`
```json
{
  "apiKey": "...",
  "authDomain": "...",
  "projectId": "...",
  "storageBucket": "...",
  "messagingSenderId": "...",
  "appId": "...",
  "measurementId": "..."
}
```

```env
REGISTRATION_TOKEN=...
PORT=8080
VAPID_KEY=...
```

## 실행

### service worker에 firebase config 정보 주입

```bash
node buildConfig.js
```

### express app 실행

```bash
node app.js
```

### 브라우저 접속

`http://localhost:8080`

### push message

```
node sendMessage
```