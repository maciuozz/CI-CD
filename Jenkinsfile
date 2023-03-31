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

  }
  
  agent {
    node {
      label 'agent_22'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'make build'
      }
    }

  }
}
