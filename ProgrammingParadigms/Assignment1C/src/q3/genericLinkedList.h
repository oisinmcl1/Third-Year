#ifndef GENERICLINKEDLIST_H
#define GENERICLINKEDLIST_H

/*
 * Oisin Mc Laughlin
 * 22441106
 *
 * Question 3
*/

// Modified struct to store a void pointer instead of a char pointer and also added a function pointer for pint func
typedef struct listElementStruct {
    // Changed char pointer to void pointer
    void *data;

    size_t size;

    struct listElementStruct *next;

    void (*printFunction)(void *);
} listElement;

// Added typedef for print function
typedef void (*printFunction)(void *);

// Modified functions to take a voiid pointer and func pointer for print func
listElement *createEl(void *data, size_t size, printFunction print);

void traverse(listElement *start);

int length(listElement *list);

void push(listElement **list, void *data, size_t size, printFunction print);

listElement *pop(listElement **list);

void enqueue(listElement **list, void *data, size_t size, printFunction print);

listElement *dequeue(listElement *list);

// Print functions for different types of data
void printInt(void *data);

void printStr(void *data);

void printFloat(void *data);


#endif //GENERICLINKEDLIST_H
