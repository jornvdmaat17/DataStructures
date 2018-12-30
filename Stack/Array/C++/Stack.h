#ifndef STACK_H
#define STACK_H

class Stack{

public:
  int size;
  int capacity;
  int *array;

  Stack();
  void push(int data);
  int pop();
  int returnSize();
  int returnCapacity();
  bool isEmpty();
};

#endif
