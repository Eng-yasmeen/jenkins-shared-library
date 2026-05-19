def call() {
    echo "Image building..."
    sh 'docker build -t my-app:${BUILD_NUMBER} .'
}
