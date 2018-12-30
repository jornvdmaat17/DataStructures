#include "Stack.h"
#include <stdlib.h>

Stack* createStack(){
  Stack *s = (Stack*) malloc (sizeof(Stack));
  s->size = 0;
  s->capacity=1;
  s->array = (int*) malloc (s->capacity * sizeof(int));
  return s;
}

void push(int data, Stack *stack){
  if(stack->size == stack->capacity / 2){
    stack->capacity *= 4;
    stack->array = realloc(stack->array, stack->capacity * sizeof(int));
  }
  *(stack->array + sizeof(int) * stack->size) = data;
  stack->size++;
}

int pop(Stack *stack){
  int ret = -1;
  if(stack->size != 0){
    ret = *(stack->array + sizeof(int) * (stack->size-1));
    stack->size--;
  }
  if(stack->size < stack->capacity / 4){
    stack->capacity/=2;
    stack->array = realloc(stack->array, stack->capacity * sizeof(int));
  }
  return ret;
}

int returnSize(Stack *stack){
  return stack->size;
}

int returnCapacity(Stack *stack){
  return stack->capacity;
}

int isEmpty(Stack *stack){
  return stack->size == 0;
}
