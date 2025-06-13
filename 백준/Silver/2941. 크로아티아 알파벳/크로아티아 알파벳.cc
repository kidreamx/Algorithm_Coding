#include<stdio.h>
int main()
{
	char a[1000];
	int sum = 0;
	scanf("%s", a);
	for (int i = 0; a[i] != '\0'; i++)
	{
		if (a[i] == 'l')
		{
			if (a[i + 1] == 'j')
			{
				sum++;
				i = i + 1;
			}
			else
				sum++;
		}
		else if (a[i] == 'c')
		{
			if (a[i + 1] == '=')
			{
				sum++;
				i = i + 1;
			}
			else if (a[i + 1] == '-')
			{
				sum++;
				i = i + 1;
			}
			else
				sum++;
		}
		else if (a[i] == 'd')
		{
			if (a[i + 1] == 'z')
			{
				if (a[i + 2] == '=')
				{
					sum++;
					i = i + 2;
				}
				else
				{
					sum += 2;
					i = i + 1;
				}
			}
			else if (a[i + 1] == '-')
			{
				sum++;
				i = i + 1;
			}
			else
				sum++;

		}
		else if (a[i] == 'n')
		{
			if (a[i + 1] == 'j')
			{
				sum++;
				i = i + 1;
			}
			else
				sum++;
		}
		else if (a[i] == 's')
		{
			if (a[i + 1] == '=')
			{
				sum++;
				i = i + 1;
			}
			else
				sum++;
		}
		else if (a[i] == 'z')
		{

			if (a[i + 1] == '=')
			{
				sum++;
				i = i + 1;
			}
			else
				sum++;
		}
		else 
		{
			sum++;
		}
	}
	printf("%d", sum);
}
