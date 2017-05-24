def call(int times, Closure body)
{
	for (int i = 0; i < times; i++)
	{
		body()
	}
}