node() {

    checkout scm
    def a = load('a.groovy')
    def repoURL = 'https://github.com/richab21/Z-Hunting.git'


    stage('Checkout Self') {
        git branch: 'master', credentialsId: '', url: repoURL
    }
    stage('Cucumber Tests') {
            bat """
			cd ${env.WORKSPACE_LOCAL}
			mvn clean test
		"""
    }
    stage('Expose report') {
        archive "target/cucumber.json"
        cucumber 'target/cucumber.json'
    }
	stage('Import results to Xray') {

		def description = "[BUILD_URL|${env.BUILD_URL}]"
		def labels = '["regression","automated_regression"]'
		def environment = "DEV"
		def testExecutionFieldId = 10008
		def testEnvironmentFieldName = "customfield_10132"
		def projectKey = "HUN"
		def xrayConnectorId = '0cc58c81-1099-483d-9141-0f8e2e2e2f9c'
		def info = '''{
				"fields": {
					"project": {
					"key": "''' + projectKey + '''"
				},
				"labels":''' + labels + ''',
				"description":"''' + description + '''",
				"summary": "Automated Regression Execution @ ''' + env.BUILD_TIME + ' ' + environment + ''' " ,
				"issuetype": {
				"id": "''' + testExecutionFieldId + '''"
				},
				"''' + testEnvironmentFieldName + '''" : [
				"''' + environment + '''"
				]
				}
				}'''

			echo info

			step([$class: 'XrayImportBuilder', endpointName: '/cucumber/multipart', importFilePath: 'target/cucumber.json', importInfo: info, inputInfoSwitcher: 'fileContent', serverInstance: xrayConnectorId])
		}
}