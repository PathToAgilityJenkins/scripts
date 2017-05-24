def call(String project)
{
	node
	{
		echo "Running common pipeline for ${project}."
		
		stage('Checkout')
		{
			checkout scm
		}
		
		stage('Build')
		{
			dir(project)
			{
				withMaven(maven: 'Maven 3.5.0')
				{
					sh 'mvn package'
				}
			}
		}
		
		stage('Deploy')
		{
			echo "Do something useful to deploy ${project}."
		}
		
		stage('Test')
		{
			echo "Do something useful to test ${project}."
		}
	}
}