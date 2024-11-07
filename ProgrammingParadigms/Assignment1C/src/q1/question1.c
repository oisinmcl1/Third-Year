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
    printf("Size of int: %ld bytes\n", sizeof(typeInt));
    printf("Size of int*: %ld bytes\n", sizeof(typeIntPointer));
    printf("Size of long: %ld bytes\n", sizeof(typeLong));
    printf("Size of double*: %ld bytes\n", sizeof(typeDoublePointer));
    printf("Size of char**: %ld bytes\n", sizeof(typeCharPointerPointer));
}
