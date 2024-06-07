# Gemini AI Chat Example App

This project demonstrates a simple implementation of the Vertex AI Gemini Chat model using Vaadin Flow. The application allows users to enter a prompt and receive a generated response from the AI model.

## Getting Started

### Prerequisites

Ensure you have the following installed:
- Java Development Kit (JDK) 11 or later
- Maven
- Google Cloud SDK

### Environment Setup

1. **Set Environment Variables**:
    - Create a `.env` file in the root directory of your project or set the environment variables directly in your terminal.
    - Add the following lines to the `.env` file (replace with your actual project ID and location):
      ```sh
      GOOGLE_CLOUD_PROJECT_ID=your-project-id
      GOOGLE_CLOUD_LOCATION=your-location
      GOOGLE_APPLICATION_CREDENTIALS=/path/to/your/service-account-file.json
      ```

2. **Load Environment Variables**:
    - For MacOS/Linux, run the following command in your terminal to load the environment variables:
      ```sh
      export $(cat .env | xargs)
      ```

### Running the Application

This is a standard Maven project. To run it from the command line:

1. **Build and Run**:
   ```sh
   ./mvnw clean install
   ./mvnw spring-boot:run
2. **Import to IDE:**
    - You can also import the project to your IDE of choice as you would with any Maven project.

### Deploying to Production
To create a production build:
1. **Build:**
    ```sh
   ./mvnw clean package -Pproduction
   ```
    - This will build a JAR file with all dependencies and front-end resources, ready to be deployed. The file can be found in the target folder after the build completes.
2. **Run**
   ```sh
   java -jar target/your-app-1.0-SNAPSHOT.jar


### Project Structure
    - GeminiView.java: The main view component where users can enter prompts and see responses.
    - application.properties: Configuration file where you can set various properties like project ID and location.

### Useful Links
- [Vertex AI Documentation](https://cloud.google.com/vertex-ai/docs)
- [Vaadin Documentation](https://vaadin.com/docs)
- [Spring AI Documentation](https://spring.io/projects/spring-ai)
- [Google Cloud SDK Installation](https://cloud.google.com/sdk/docs/install)
- [Vaadin Start Page](https://start.vaadin.com/)
- [Vaadin GitHub Repository](https://github.com/vaadin)
