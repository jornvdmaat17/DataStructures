#ifndef STACK_H
#define STACK_H

typedef struct stack{
  int size;
  int capacity;
  int *array;
}Stack;

Stack* createStack();
void push(int data, Stack *stack);
int pop(Stack *stack);
int returnSize(Stack *stack);
int returnCapacity(Stack *stack);
int isEmpty(Stack *stack);

#endif
