pipeline {
  agent {
    node {
      label 'agent_22'
    }

  }
  stages {
    stage('Clean') {
      steps {
        sh 'make clean'
      }
    }

    stage('Build') {
      steps {
        sh 'make build'
      }
    }

    stage('Test') {
      steps {
        sh 'make test'
      }
    }

  }
}