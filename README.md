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

<img width="1792" alt="Screenshot 2023-04-01 at 12 53 05" src="https://user-images.githubusercontent.com/118285718/229328930-4d732b24-cc67-47dd-851b-3d96ea0af3d0.png">
<img width="1790" alt="Screenshot 2023-04-01 at 12 51 07" src="https://user-images.githubusercontent.com/118285718/229328949-f1e258a7-b158-4e3c-9535-f05118b86635.png">
<img width="1792" alt="Screenshot 2023-04-01 at 12 50 49" src="https://user-images.githubusercontent.com/118285718/229328952-ef3105db-f74a-4d4f-9b5b-323af89025ae.png">
<img width="1791" alt="Screenshot 2023-04-01 at 12 44 27" src="https://user-images.githubusercontent.com/118285718/229328962-be4bb864-92cf-4ccb-925c-533b52acb0fc.png">
<img width="1790" alt="Screenshot 2023-04-01 at 12 48 20" src="https://user-images.githubusercontent.com/118285718/229328955-0f5f3880-0b0b-4e08-b529-2995c3b79cf8.png">

Download the artifact by accessing the "Artifacts" section in the Jenkins interface:  

<img width="1792" alt="Screenshot 2023-04-02 at 14 38 54" src="https://user-images.githubusercontent.com/118285718/229353309-61370a6f-f69c-43e7-b4ce-58b8bb3cf559.png">

Run the following command:  

    java -jar myapp-0.0.1.jar <path/to-the/text-file.txt>
    
Below is an example of running the application after downloading the artifact to a different environment, showcasing 3 different scenarios:

1. The application is executed with no text file argument provided.
2. The application is executed with a valid text file argument.
3. The application is executed with a non-valid text file argument.

<img width="1396" alt="Screenshot 2023-04-03 at 13 06 20" src="https://user-images.githubusercontent.com/118285718/229492344-768b0d82-6cdf-4d5f-8cbc-7ce15b8569d5.png">










