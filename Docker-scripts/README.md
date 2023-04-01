You must be logged in as the jenkins user. Then you can run the scipt to create 2 containers:

        sudo chmod +x run.sh
    sudo ./run.sh


job('Make-test-30') {
    triggers {
      cron('*/30 * * * *')
    }
    scm {
        git {
            remote {
                url('https://github.com/maciuozz/ci-cd-private.git')
                credentials('ci-cd-private')
            }
            branch('main')
        }
    }
    steps {
        shell('make test')
    }
}
