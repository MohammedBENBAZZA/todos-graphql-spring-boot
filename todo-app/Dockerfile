
# Stage 1: Build the Angular application
FROM node:21-alpine as build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2: Serve the application with Nginx
FROM nginx:alpine
COPY --from=build /app/dist/todo-app/browser /usr/share/nginx/html
