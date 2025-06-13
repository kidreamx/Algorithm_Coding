#include <stdio.h>
int collect1(int a)
{
	int b, c = 0, d = 0;
	if (a % 3 != 0 && a % 5 != 0)
	{
		if (a >= 5)
		{
			while (a >= 3)
			{
				a = a - 3;
				c++;
				if (a % 5 == 0)
				{
					d = a / 5;
					for (int i = 0; i < d; i++)
					{
						a = a - 5;
						c++;
					}
					return c;
				}
				else if (a < 3)
				{
					return -1;
				}

			}
		}
		else
			return -1;
	}

	else
	{
		if (a % 5 == 0)
		{
			c = a / 5;
			return c;
		}
		else
		{
			if (a > 15)
			{
				while (a > 15)
				{
					a = a - 15;
					c = c + 3;
				}
				c = c + a / 3;
				return c;
			}
			else
			{
				c = a / 3;
				return c;
			}
		}

	}

}

int main()
{
	int N, a, b;
		scanf("%d", &N);
		printf("%d", collect1(N));
	
	return 0;
}