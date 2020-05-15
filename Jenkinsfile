node {
	stage ('Tests_running'){
		git "https://github.com/Kovalchm/Allegro_TC_MKovalch.git"
		}
	stage ('Build'){
    	dir("commontest") {
	   sh "mvn clean install"
       }
       	dir("commontest/target") {
	   sh "java -jar com.test-1.0-SNAPSHOT.jar"
       }
		}
   stage('Reports') {
       allure([
    includeProperties: false,
       jdk: '',
          properties: [],
      reportBuildPolicy: 'ALWAYS',
      results: [[path: 'target/allure-results']])
   }
}
