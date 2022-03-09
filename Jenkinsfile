node() {

    def repoURL = 'https://github.com/richab21/Z-Hunting.git'

//     stage("Prepare Workspace") {
//         cleanWs()
//         env.WORKSPACE_LOCAL = sh(returnStdout: true, script: 'pwd').trim()
//         env.BUILD_TIME = sh(returnStdout: true, script: 'date +%F-%T').trim()
//         echo "Workspace set to:" + env.WORKSPACE_LOCAL
//         echo "Build time:" + env.BUILD_TIME
//
//     }
                 stage('Build') {
                         sh 'mvn clean verify'
                 }
    stage('Checkout Self') {
        git branch: 'master', credentialsId: '', url: repoURL
    }
    stage('Cucumber Tests') {
        withMaven(maven: 'maven35') {
            sh """
			cd ${env.WORKSPACE_LOCAL}
			mvn clean test
		"""
        }
    }
    stage('Expose report') {
        archive "**/cucumber.json"
        cucumber '**/cucumber.json'
    }
}