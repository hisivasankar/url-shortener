FROM node:lts-alpine3.10

LABEL version=1.0
LABEL name="url-shortener-ui"

WORKDIR /usr/src/app
COPY package*.json ./

RUN npm install

COPY . .
RUN npm run build-prod

CMD [ "node", "server.js" ]
EXPOSE 8080