#include <stdio.h>
#include "genericLinkedList.h"

/*
 * Oisin Mc Laughlin
 * 22441106
 *
 * Question 3
*/

int main() {
 // Create empty list
  listElement *l = NULL;

 // Push an int
 int num = 12;
 printf("\nPushing %d\n", num);
 push(&l, &num, sizeof(int), printInt);

 // Push a string
 char string[] = "Hello World!";
 printf("Pushing %s\n", string);
 push(&l, string, sizeof(string), printStr);

 // Push a float
 float fl = 3.14;
 printf("Pushing %f\n", fl);
 push(&l, &fl, sizeof(float), printFloat);

 // Traverse and print list
 printf("\nTraversing list\n");
 traverse(l);
}
