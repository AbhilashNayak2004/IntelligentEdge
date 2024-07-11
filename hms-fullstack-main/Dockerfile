# # Use an official Node.js runtime as a parent image
# FROM node:14

# # Set the working directory
# WORKDIR /app

# # Copy package.json and package-lock.json
# COPY package*.json ./

# # Install dependencies
# RUN npm install

# # Copy the rest of the application code
# COPY . .

# # Build the application
# RUN npm run build

# # Install serve to serve the build
# RUN npm install -g serve

# # Command to run the application
# CMD ["serve", "-s", "build"]

# # Expose the port the app runs on
# EXPOSE 5000
# Use an official Node runtime as a parent image
FROM node:14

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . .

# Install dependencies and build the project
RUN npm install && npm run build

# Expose the port the app runs on
EXPOSE 3000

# Serve the application
CMD ["npm", "start"]
