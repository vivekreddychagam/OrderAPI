node {
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/partsunlimitedmrp/orderAPI.git'
   }
   stage('Build') {
      sh 'docker build -t partsunlimitedmrp/orderapi:${BUILD_ID} .'
   }
   stage('Push') 
   withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'dockerhub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']])
   {
      sh 'docker login --username=$USERNAME --password=$PASSWORD'
      sh 'docker push partsunlimitedmrp/orderapi:${BUILD_ID}'
   }
   stage('Update Breed') {
       sh 'curl -v -X PUT --data-binary @pumrpclientA.yaml -H "Content-Type: application/x-yaml" vamp.vamp.marathon.mesos:12061/api/v1/deployments/pumrpclient'
   }
   stage('Deploy') {
       sh 'curl -v -X POST --data-binary @webdebug_1.1.yaml -H "Content-Type: application/x-yaml" vamp.vamp.marathon.mesos:12061/api/v1/deployments'
   }
}
