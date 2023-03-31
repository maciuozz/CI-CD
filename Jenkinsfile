pipeline {
  agent none
  stages {
    stage('Clean') {
      agent {
        label 'agent_11'
      }
      steps {
        sh 'make clean'
      }
    }

    stage('Build') {
      agent {
        label 'agent_22'
      }
      steps {
        sh 'make build'
      }
    }

    stage('Test') {
      agent {
        label 'agent_11'
      }
      steps {
        sh 'make test'
      }
    }

    stage('Find file') {
      agent {
        label 'agent_22'
      }
      steps {
        sh 'make check_files'
      }
    }

    stage('Run') {
      agent {
        label 'agent_22'
      }
      steps {
        sh 'make exec'
      }
    }
  }
}
