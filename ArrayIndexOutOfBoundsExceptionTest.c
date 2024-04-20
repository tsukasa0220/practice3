#include <stdio.h>

int main(void) {
    int a[] = {1, 2, 3};
    int i; 
    for (i = 0; i <= sizeof(a) / sizeof(a[0]); i++) {
        printf("%d\n", a[i]);
    }

    return 0;  
}