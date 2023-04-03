# Practica CI-CD Paolo Scotto Di Mase

There are 3 more README files: one for the ***src/main/java/WordCounter*** repository, another for the ***src/test/java/WordCounter*** repository and a third one for the ***DockerAgents-JenkinsNodes-Job*** repository.  
For this project I utilized a virtual machine running Ubuntu 22.04 as the environment for Jenkins. I used 2 Docker agents that connect to 2 Jenkins nodes.
The pipeline runs on agent_22, while agent_11 is designated for the job that exclusively runs the tests. I created the VM with the Vagrant script below: 

    Vagrant.configure("2") do |config|
        config.vm.define "cicd-vm" do |cicd|
            cicd.vm.box = "ubuntu/jammy64"
            cicd.vm.hostname = "cicd"
            cicd.vm.box_check_update = false
            cicd.vm.network "forwarded_port", guest: 8080, host: 8081
            cicd.vm.provider "virtualbox" do |vb|
                vb.name = "ubuntu_cicd"
                vb.memory = "4096"
                vb.cpus = 2
            end
        end
    end
    
In the Makefile there are 5 targets: ***clean, build, test, check_files, exec***. It is possible to try the application locally and execute all targets using a single command:

    make all
    
The presence of 2 files named ***texto.txt*** with different paths, serves to demonstrate the calculation of the FILE_PATH variable in situations where multiple files share the same name.  

The Jenkins file displays all the steps involved in building the pipeline. Note that the ***deploy*** step is intended solely for illustrative purposes and its function is limited to printing a message. Here are some pictures:  

<img width="1783" alt="Screenshot 2023-04-03 at 13 29 43" src="https://user-images.githubusercontent.com/118285718/229496877-042b2467-bfd2-42ed-8f51-d2e9c993519e.png">

<img width="1792" alt="Screenshot 2023-04-03 at 13 23 26" src="https://user-images.githubusercontent.com/118285718/229496366-86f486b4-6bed-41ab-8961-e6ff5575e25c.png">

<img width="1791" alt="Screenshot 2023-04-01 at 12 44 27" src="https://user-images.githubusercontent.com/118285718/229328962-be4bb864-92cf-4ccb-925c-533b52acb0fc.png">
<img width="1790" alt="Screenshot 2023-04-01 at 12 48 20" src="https://user-images.githubusercontent.com/118285718/229328955-0f5f3880-0b0b-4e08-b529-2995c3b79cf8.png">

Download the artifact by accessing the "Artifacts" section in the Jenkins interface:  

<img width="1792" alt="Screenshot 2023-04-02 at 14 38 54" src="https://user-images.githubusercontent.com/118285718/229353309-61370a6f-f69c-43e7-b4ce-58b8bb3cf559.png">

Run the following command:  

    java -jar myapp-0.0.1.jar <text-file.txt>
    
Below is an example of running the application after downloading the artifact to a different environment, showcasing 4 different scenarios:

1. The application is run without providing any text file argument.
2. The application is run with a valid text file argument.
3. The application is run with a valid text file argument that exists in multiple paths.
4. The application is run with an invalid text file argument.

<img width="1397" alt="Screenshot 2023-04-03 at 13 09 57" src="https://user-images.githubusercontent.com/118285718/229493010-4ef442b9-8786-4274-b95b-760a179fe939.png">












