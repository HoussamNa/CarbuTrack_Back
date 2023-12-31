# CarbuTrack Backend

Welcome to the backend repository of CarbuTrack, an energy consumption tracking and management application designed to efficiently manage vehicle data and support user accounts. This backend component, built using Spring Boot, plays a crucial role in handling user data, vehicle information, and microservices integration.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Microservices](#microservices)
   - [Car Microservice](#car-microservice)
   - [Client Microservice](#client-microservice)
4. [Consul Server Integration](#consul-server-integration)
5. [Development](#development)
   - [Running the Backend](#running-the-backend)
   - [Code Structure](#code-structure)
6. [API Documentation](#api-documentation)
7. [Further Help](#further-help)

## Introduction <a name="introduction"></a>

The CarbuTrack backend is a critical component that supports the CarbuTrack application's functionality. It manages user data, vehicle information, and facilitates communication between microservices, making it possible for the frontend to provide users with a seamless experience.

## Features <a name="features"></a>

The backend of CarbuTrack offers the following features:

- User account management, including user registration, login, and profile updates.
- Vehicle information management, allowing users to add and edit vehicle details.
- Integration with microservices for efficient data handling.
- Communication with the Consul server for service discovery and configuration management.

## Microservices <a name="microservices"></a>

CarbuTrack's backend consists of the following microservices:

### 1. Car Microservice <a name="car-microservice"></a>

The Car Microservice manages vehicle information, including storage, retrieval, and updates.

### 2. Client Microservice <a name="client-microservice"></a>

The Client Microservice handles user account management, authentication, and user profile data.

## Consul Server Integration <a name="consul-server-integration"></a>

The backend integrates with a Consul server, a service discovery and configuration management tool, to ensure seamless communication between microservices and dynamic configuration updates.

## Development <a name="development"></a>

### Running the Backend <a name="running-the-backend"></a>

To run the CarbuTrack backend locally, follow these steps:

1. Clone this repository to your local machine.

2. Navigate to the project's root directory.

3. Run the backend using the Spring Boot command:
   
./mvnw spring-boot:run


4. The backend will start at `http://localhost:8080`.

### Code Structure <a name="code-structure"></a>

The backend code is structured to separate concerns and provide modularity. Key components include controllers, services, repositories, and configuration files. Microservices are organized in their respective packages.

## API Documentation <a name="api-documentation"></a>

For detailed API documentation and endpoints, refer to the documentation provided in the respective microservices' README files.

## Further Help <a name="further-help"></a>

If you need assistance or have questions about the CarbuTrack backend, please consult the specific microservices' README files or reach out to the development team for further guidance.

Thank you for your contribution to CarbuTrack's backend development.
