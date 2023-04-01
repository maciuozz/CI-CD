<h2>DOCKER AGENTS</h2>  
You must be logged in as the jenkins user. Then you can run the script to create 2 containers that represent 2 agents/2 jenkins nodes:  


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
