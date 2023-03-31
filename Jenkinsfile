pipeline {
  agent {
    node {
      label 'agent_11'
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
        node(label: 'agent_22') {
          sh 'make build'
        }

      }
    }

  }
}