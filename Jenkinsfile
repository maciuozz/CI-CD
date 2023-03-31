pipeline {
    agent any
    stages {
        stage('Clean') {
            agent { label 'agent_11' }
            steps {
                sh 'make clean'
            }
        }
        stage('Build') {
            agent { label 'agent_22' }
            steps {
                sh 'make build'
            }
        }
    }
}

