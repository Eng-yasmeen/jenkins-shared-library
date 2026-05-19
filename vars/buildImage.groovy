def call(String registryUrl, String credentialsId, String imageName) {
    echo " Start building..."
     
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "echo $PASS | docker login $registryUrl -u $USER --password-stdin"
        

        sh "docker build -t $registryUrl/$imageName:${BUILD_NUMBER} ."
        
     
        sh "docker push $registryUrl/$imageName:${BUILD_NUMBER}"
    }
    
    echo "Image uploaded successfullu: $registryUrl/$imageName:${BUILD_NUMBER}"
}
