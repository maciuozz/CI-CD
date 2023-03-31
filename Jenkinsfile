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

    stage('Find specified file') {
      steps {
        sh 'make check_files'
      }
    }

  }
}