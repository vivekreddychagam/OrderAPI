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
}
