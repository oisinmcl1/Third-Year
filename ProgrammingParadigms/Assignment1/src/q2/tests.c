#include <stdio.h>
#include "tests.h"
#include "linkedList.h"

void runTests() {
    printf("Tests running...\n");
    listElement *l = createEl("Test String (1).", 30);
    //printf("%s\n%p\n", l->data, l->next);
    //Test create and traverse
    traverse(l);
    printf("\n");

    //Test insert after
    listElement *l2 = insertAfter(l, "another string (2)", 30);
    insertAfter(l2, "a final string (3)", 30);
    traverse(l);
    printf("\n");

    // Test delete after
    deleteAfter(l);
    traverse(l);
    printf("\n");

    printf("\nTests complete.\n");
}

/*
 * Oisin Mc Laughlin
 * 22441106
 *
 * Question 2
 */


void testPushAndPop() {
    // Create init empty list
    listElement *l = NULL;

    // Test push
    printf("\nTesting Push\n");

    // Push element to list
    char el1[] = "Test String (1)";
    char el2[] = "Test String (2)";
    char el3[] = "Test String (3)";

    printf("\nPushing elements:"
           "\n%s"
           "\n%s"
           "\n%s"
           "\n\n"
           , el1, el2, el3);

    push(&l, el1, 30);
    push(&l, el2, 30);
    push(&l, el3, 30);

    printf("After push:\n");
    traverse(l);


    // Test pop
    printf("\n\nTesting Pop\n\n");

    // Pop top element
    listElement *popped = pop(&l);
    printf("Popped element: \n%s\n", popped -> data);

    printf("\nAfter pop:\n");
    traverse(l);
}


void testEnqueueAndDequeue() {
    // Create init empty list
    listElement *l = NULL;

    // Test enqueue
    printf("\nTesting Enqueue\n");

    // Enqueue element to list
    char el1[] = "Test String (1)";
    char el2[] = "Test String (2)";
    char el3[] = "Test String (3)";

    printf("\nEqueuing elements:"
           "\n%s"
           "\n%s"
           "\n%s"
           "\n\n"
           , el1, el2, el3);

    enqueue(&l, el1, 30);
    enqueue(&l, el2, 30);
    enqueue(&l, el3, 30);

    printf("After enqueue:\n");
    traverse(l);


    // Testing dequeue
    printf("\n\nTesting Dequeue\n\n");

    // Dequeue element
    listElement *dequeued = dequeue(l);
    printf("Dequeued element: \n%s\n", dequeued -> data);

    printf("\nAfter dequeue:\n");
    traverse(l);
}
