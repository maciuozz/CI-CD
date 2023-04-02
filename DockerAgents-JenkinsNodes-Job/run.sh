#!/bin/bash

set -o nounset

export JENKINS_CONTAINER_NAME1=jenkins_agent11
export JENKINS_CONTAINER_NAME2=jenkins_agent22
export JENKINS_AGENT_SSH_PUBKEY="$(cat ~/.ssh/id_rsa.pub)"

docker-compose -f docker-compose.yaml up --build -d

sleep 10

docker exec $JENKINS_CONTAINER_NAME1 bash -c "apt update -y -q && apt install -y -q sudo && apt upgrade -y -q && apt install -y -q git python3 python3-venv maven make"
docker exec $JENKINS_CONTAINER_NAME2 bash -c "apt update -y -q && apt install -y -q sudo && apt upgrade -y -q && apt install -y -q git python3 python3-venv maven make"

docker exec $JENKINS_CONTAINER_NAME1 bash -c "echo 'jenkins ALL=(ALL) NOPASSWD: ALL' >> /etc/sudoers"
docker exec $JENKINS_CONTAINER_NAME2 bash -c "echo 'jenkins ALL=(ALL) NOPASSWD: ALL' >> /etc/sudoers"
