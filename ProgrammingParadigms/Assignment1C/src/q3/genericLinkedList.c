#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "genericLinkedList.h"

/*
    * Oisin Mc Laughlin
    * 22441106
    *
    * Question 3
*/

// Modified to work with void (any data type) and print Func
listElement *createEl(void *data, size_t size, printFunction print) {
    listElement *e = malloc(sizeof(listElement));
    if (e == NULL) {
        return NULL;
    }

    e->data = data;
    e->size = size;
    e->next = NULL;
    e->printFunction = print;
    return e;
}

// Modified to work with void (any data type)
void traverse(listElement *start) {
    listElement *current = start;

    while (current != NULL) {
        // Print current element of any data type
        current->printFunction(current->data);
        current = current->next;
    }
}


// Returns the number of elements in a linked list
int length(listElement *list) {
    int length = 0;

    // Start at head of list
    listElement *current = list;

    // Traverse the list until no more next element
    while (current != NULL) {
        // Increment count for each element
        length++;
        // Move to next element
        current = current->next;
    }

    return length;
}

// Push and Pop functions (LIFO)

// Adds new element to head of the list
void push(listElement **list, void *data, size_t size, printFunction print) {
    // Create element
    listElement *newElement = createEl(data, size, print);

    // Set new element's next pointer to head of list
    newElement->next = *list;

    // Update head of list to new element
    *list = newElement;
}

// Removes and returns the node at the head of the list
listElement *pop(listElement **list) {
    // Check if list is empty
    if (*list == NULL) {
        return NULL;
    }

    // Get current head of list
    listElement *head = *list;

    // Set next node to be new head of list
    *list = head->next;

    // Remove head from list
    head->next = NULL;

    return head;
}

// Enqueue and Dequeue functions (FIFO)

// Adds element to the head of list
void enqueue(listElement **list, void *data, size_t size, printFunction print) {
    // Create element
    listElement *newElement = createEl(data, size, print);

    newElement->next = *list;

    *list = newElement;
}

// Removes and returns the last element in the list
listElement *dequeue(listElement *list) {
    // Check if the list is empty
    if (list == NULL) {
        return NULL;
    }

    // If the list has only one element
    if ((list->next) == NULL) {
        return list;
    }

    // For a list with more than one element, find the last element
    listElement *current = list;
    listElement *prev = NULL;

    // Traverse the list to the last element
    while (current->next != NULL) {
        prev = current;
        current = current->next;
    }

    // Disconnect the last element from the list (make the previous element the last element)
    prev->next = NULL;

    return current;
}


// Create print functions for different data types
void printInt(void *data) {
    printf("%d\n", *(int *) data);
}

void printStr(void *data) {
    printf("%s\n", data);
}

void printFloat(void *data) {
    printf("%f\n", *(float *) data);
}
