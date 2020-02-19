pipeline {
    agent any

    stages {
        stage('Building') {
            steps {
                git credentialsId: '6fec2fda-af94-40c8-96f8-db7af78a9b53', url: 'https://github.com/zycon/echo-app'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}