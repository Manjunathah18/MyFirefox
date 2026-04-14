pipeline {
    agent any

    tools {
        jdk 'JDK'          // ✅ ADDED (required)
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Dhanwin007/MyMavenFirefox.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Setup Driver') {     // ✅ ADDED (required for Linux Jenkins)
            steps {
                sh 'chmod +x drivers/geckodriver'
            }
        }

        stage('Run Application') {
            steps {
                sh 'mvn exec:java -Dexec.mainClass="com.example.App"'
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
