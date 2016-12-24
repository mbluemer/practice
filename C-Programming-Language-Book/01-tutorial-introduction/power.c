#include <stdio.h>

int power(int base, int power)
{
  int total = 1;
  for (int i = 1; i <= power; ++i) {
    total *= base;
  }
  return total;
}

int main()
{
  printf("5^9 is : %d\n", power(5, 9));
  return 0;
}
