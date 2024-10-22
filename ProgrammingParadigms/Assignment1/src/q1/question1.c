#include <stdio.h>
/*
 * Oisin Mc Laughlin
 * 22441106
 *
 * Question 1
*/

int main(void) {
    // Declare variables
    int typeInt;
    int *typeIntPointer;
    long typeLong;
    double *typeDoublePointer;
    char **typeCharPointerPointer;

    // Use sizeof() to get the size of each variable in bytes
    printf("\n");
    printf("Size of int: %zu bytes\n", sizeof(typeInt));
    printf("Size of int*: %zu bytes\n", sizeof(typeIntPointer));
    printf("Size of long: %zu bytes\n", sizeof(typeLong));
    printf("Size of double*: %zu bytes\n", sizeof(typeDoublePointer));
    printf("Size of char**: %zu bytes\n", sizeof(typeCharPointerPointer));
}
