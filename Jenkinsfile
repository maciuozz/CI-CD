pipeline {
  agent any
  stages {
    stage('Clean') {
      steps {
        node(label: 'agent_11') {
          sh 'make clean'
        }

      }
    }

  }
}