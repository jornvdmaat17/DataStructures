#include "Stack.h"
#include <iostream>

Element::Element(int data, Element* prev){
  this->data = data;
  this->prev = prev;
}

Stack::Stack(){
  this->head = nullptr;
  this->size = 0;
}

void Stack::push(int data){
  Element *newE = (Element*) malloc(sizeof(Element));
  if(this->head == nullptr){
    newE->prev = nullptr;
  }else{
    newE->prev = this->head;
  }
  newE->data = data;
  this->head = newE;
  size++;
}

int Stack::pop(){
  if(this->head == nullptr){
    return -1;
  }
  int ret = this->head->data;
  this->head = this->head->prev;
  size--;
  return ret;
}
int Stack::returnSize(){
  return this->size;
}

bool Stack::isEmpty(){
  return this->size == 0;
}
