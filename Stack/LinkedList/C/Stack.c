#include "Stack.h"
#include <stdlib.h>

Element* createElement(int data, Element *prev){
  Element *e = (Element*) malloc(sizeof(Element));
  e->data = data;
  e->prev = prev;
  return e;
}

Stack* createStack(){
  Stack *stack = (Stack*) malloc(sizeof(Stack));
  stack->head = NULL;
  stack->size = 0;
}

void push(Stack *stack, int data){
  Element *newE;
  if(stack->head == NULL){
    newE = createElement(data, NULL);
  }else{
    newE = createElement(data, stack->head);
  }
  stack->head = newE;
  stack->size++;
}

int pop(Stack *stack){
  if(stack->head == NULL){
    return -1;
  }
  int ret = stack->head->data;
  stack->head = stack->head->prev;
  stack->size--;
  return ret;
}

int returnSize(Stack *stack){
    return stack->size;
}

int isEmpty(Stack *stack){
  return stack->size == 0;
}
