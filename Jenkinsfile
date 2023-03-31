pipeline {
  agent any
  stages {
    stage('Clean') {
      steps {
        sh 'make clean'
      }
    }

    stage('Buil') {
      steps {
        sh 'make build'
      }
    }

  }
}