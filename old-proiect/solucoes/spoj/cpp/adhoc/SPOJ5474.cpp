#include <stdio.h>
#include <stdlib.h>
int main()
{
    int ih, im, fh, fm;
    while (scanf("%d %d %d %d", &ih, &im, &fh, &fm) && (ih || im || fh || fm) ) {
        int i = ih * 60 + im, f = fh * 60 + fm;
        printf("%d\n", i > f ? 1440 - (i - f) : f - i);
    }
    return 0;
}