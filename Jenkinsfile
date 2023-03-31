pipeline {
  agent any
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

    stage('Find file') {
      steps {
        sh 'make check_files'
      }
    }

    stage('Run') {
      steps {
        node(label: 'agent_22') {
          sh 'make exec'
          sh 'make exec'
        }

      }
    }

  }
}