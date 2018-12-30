#ifndef STACK_H
#define STACK_H

typedef struct element {
  int data;
  struct element *prev;
} Element;

typedef struct stack {
  Element *head;
  int size;
} Stack;

Element* createElement(int data, Element *prev);

void createStack();
Element* push(Stack *stack, int data);
int pop(Stack *stack);
int returnSize(Stack *stack);
int isEmpty(Stack *stack);

#endif
