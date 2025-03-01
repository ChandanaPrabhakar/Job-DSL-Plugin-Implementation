pipeline {
    agent any
    stages {
        stage('Generate Jobs') {
            steps {
                jobDsl targets: 'jobs/**/*.groovy'
            }
        }
        stage('Checkout') {
            steps {
                git 'https://github.com/example/repository.git'
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
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }
    }
}

