// To practice character input
#include <stdio.h>

int main()
{
  char c;
  long count = 0;

  while ((c = getchar()) != EOF) {
    if (c != '\n' && c != '\t')
      ++count;
  }

  printf("The number of characters is: %ld\n", count);

  return 0;
}
