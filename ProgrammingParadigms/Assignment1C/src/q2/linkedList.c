#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "linkedList.h"

//Creates a new linked list element with given content of size
//Returns a pointer to the element
listElement *createEl(char *data, size_t size) {
    listElement *e = malloc(sizeof(listElement));
    if (e == NULL) {
        //malloc has had an error
        return NULL; //return NULL to indicate an error.
    }
    char *dataPointer = malloc(sizeof(char) * size);
    if (dataPointer == NULL) {
        //malloc has had an error
        free(e); //release the previously allocated memory
        return NULL; //return NULL to indicate an error.
    }
    strcpy(dataPointer, data);
    e->data = dataPointer;
    e->size = size;
    e->next = NULL;
    return e;
}

//Prints out each element in the list
void traverse(listElement *start) {
    listElement *current = start;
    while (current != NULL) {
        printf("%s\n", current->data);
        current = current->next;
    }
}

//Inserts a new element after the given el
//Returns the pointer to the new element
listElement *insertAfter(listElement *el, char *data, size_t size) {
    listElement *newEl = createEl(data, size);
    listElement *next = el->next;
    newEl->next = next;
    el->next = newEl;
    return newEl;
}


//Delete the element after the given el
void deleteAfter(listElement *after) {
    listElement *delete = after->next;
    listElement *newNext = delete->next;
    after->next = newNext;
    //need to free the memory because we used malloc
    free(delete->data);
    free(delete);
}


/*
 * Oisin Mc Laughlin
 * 22441106
 *
 * Question 2
*/

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
        current = current -> next;
    }

    return length;
}

// Push and Pop functions (LIFO)

// Adds new element to head of the list
void push(listElement **list, char *data, size_t size) {
    // Create element
    listElement *newElement = createEl(data, size);

    // Set new element's next pointer to head of list
    newElement -> next = *list;

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
    *list = head -> next;

    // Remove head from list
    head -> next = NULL;

    return head;
}

// Enqueue and Dequeue functions (FIFO)

// Adds element to the head of list
void enqueue(listElement **list, char *data, size_t size) {
    // Create element
    listElement *newElement = createEl(data, size);

    newElement -> next = *list;

    *list = newElement;
}

// Removes and returns the last element in the list
listElement* dequeue(listElement* list) {
    // Check if the list is empty
    if (list == NULL) {
        return NULL;
    }

    // If the list has only one element
    if ((list -> next) == NULL) {
        return list;
    }

    // For a list with more than one element, find the last element
    listElement* current = list;
    listElement* prev = NULL;

    // Traverse the list to the last element
    while (current -> next != NULL) {
        prev = current;
        current = current -> next;
    }

    // Disconnect the last element from the list (make the previous element the last element)
    prev -> next = NULL;

    return current;
}

