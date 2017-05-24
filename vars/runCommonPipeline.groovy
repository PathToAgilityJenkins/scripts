def call(String project, String stagePrefix='')
{
	def prefix = (stagePrefix.length() == 0) ? stagePrefix : "${stagePrefix} - "

	node
	{
		echo "Running common pipeline for ${project}."
		
		stage("${prefix}Checkout")
		{
			checkout scm
		}
		
		stage("${prefix}Build")
		{
			dir(project)
			{
				withMaven(maven: 'Maven 3.5.0')
				{
					sh 'mvn package'
				}
			}
		}
		
		stage("${prefix}Deploy")
		{
			echo "Do something useful to deploy ${project}."
		}
		
		stage("${prefix}Test")
		{
			echo "Do something useful to test ${project}."
		}
	}
}