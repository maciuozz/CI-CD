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
        sh '@mvn compile'
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

    stage('Exec') {
      steps {
        sh 'make exec'
      }
    }

    stage('Package & Save') {
      steps {
        sh 'mvn jar:jar'
        archiveArtifacts 'target/*.jar'
      }
    }

  }
}