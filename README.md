# Hotel Scheduling Application
## Overview
This project is a backend solution for the Landon Hotel scheduling application, using the Spring Framework and Angular. It includes multithreading, language translation, time zone messaging, currency exchange display, and containerization with Docker for cloud deployment.

## Competencies
**Writes Multithreaded Code:** Develops multithreaded, object-oriented code using Java frameworks.

**Deploying Applications with Cloud Services:** Deploys software applications using cloud services.

## Introduction
This project involves modifying a Spring application to include multithreading for language translation, time zone messaging, and currency exchange. The application is containerized using Docker for deployment.

## Scenario
You are tasked with updating the Landon Hotel scheduling application to meet new requirements, including localization, currency display, and time zone messaging.

## Requirements
### Setup
**GitLab Integration:**
Clone the project to the IDE.
Commit and push changes regularly.
Submit the GitLab repository URL and the repository branch history.

## Implementation
### Localization and Internationalization 

- **Resource Bundles:**
Create resource bundles for English and French.
- **Welcome Message:** Display welcome messages in both languages using different threads.

### Currency Display

- Display reservation prices in USD, CAD, and EUR.

### Time Zone Messaging

- **Time Conversion:** Convert times between ET, MT, and UTC.
- **Display Message:** Show the time for an online live presentation in ET, MT, and UTC.

## Docker and Cloud Deployment
### Dockerfile Creation

- Build a Dockerfile to create a single image with all code modifications.
- Commit and push the final Dockerfile to GitLab.

### Testing Docker

- Create a Docker image of the multithreaded Spring application.
- Run the Docker image in a container.
