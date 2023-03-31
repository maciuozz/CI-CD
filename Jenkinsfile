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
        node(label: 'agent_11') {
          sh 'make build'
        }

      }
    }

  }
}