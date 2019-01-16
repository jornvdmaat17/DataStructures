#ifndef STACK_H
#define STACK_H

class Element{

public:
  int data;
  Element* prev;

  Element(int data, Element* prev);
  Element() = default;
};

class Stack{

public:
  Element* head;
  int size;

  Stack();
  void push(int data);
  int pop();
  int returnSize();
  bool isEmpty();
};

#endif
