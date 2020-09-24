pipeline {
    agent { 
        node { 
            label 'jenkins_slave'
        }
    }
    environment {
        AZ_DOCKER_KEY_ID     = 'jenkins-user-for-docker-repository'
        REPOSITORY           = 'hansleolml/reto_tecnico'
        AZ_K8S_KEY_ID        = 'jenkins-user-for-k8s-azure'
    }
    stages {
        stage('Git Clone'){
            steps {
                git credentialsId: 'jenkins-user-for-git-repository', url: 'https://github.com/hansleolml/retobase_prueba.git'
            }
        }
        stage('Prueba login') {
            steps {
                sh("hostname")
                sh("az --version")
                sh("ls -la")
            }
        }
        stage('Docker Build') {
            steps {
                script{
                    customImage = docker.build(REPOSITORY+":${env.BUILD_ID}")
                }
            }
        }
        stage('Push Docker') {
            steps {
                script {
                    docker.withRegistry('',AZ_DOCKER_KEY_ID) {
                        customImage.push()
                        customImage.push('latest')
                        sh "docker rmi -f ${env.REPOSITORY}:${env.BUILD_ID} ${env.REPOSITORY}:latest"
                    }
                }
            }
        }
        stage('deploy k8s') {
            steps {
                withCredentials([azureServicePrincipal(AZ_K8S_KEY_ID)]) {
                    sh 'az login --service-principal -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET -t $AZURE_TENANT_ID'
                    sh 'az aks get-credentials --resource-group kubernetesGroup --name nameAKSCluster'
                    sh 'kubectl get nodes'
                    //sh 'kubectl delete namespaces springibm'
                    sh 'kubectl apply -f kubernetes/kuber_namespace.yaml'
                    sh 'kubectl get ns' 
                    sh 'kubectl apply -n springibm -f kubernetes/kuber_deploy_loadba.yaml'  
                    sh 'kubectl -n springibm get pods' 
                    sh 'kubectl -n springibm get svc' 
                }                   
            }
        }
    }
    post { 
        always { 
            cleanWs()
        }
    }
}
