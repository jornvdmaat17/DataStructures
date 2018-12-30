#include "Stack.h"
#include <iostream>

Stack::Stack(){
  this->size = 0;
  this->capacity = 1;
  this->array = new int[this->capacity];
}

void Stack::push(int data){
  if(size == capacity / 2){
    this->capacity *= 4;
    int *temp = new int[this->capacity];
    for(int i = 0; i < this->size; i++){
      temp[i] = this->array[i];
    }
    delete [] this->array;
    this->array = temp;
  }
  this->array[size] = data;
  size++;
}

int Stack::pop(){
  int ret = -1;
  if(this->size != 0){
    ret = this->array[this->size - 1];
    this->size--;
  }
  if(this->size < this->capacity / 4){
    this->capacity /= 2;
    int *temp = new int[this->capacity];
    for(int i = 0; i < this->size; i++){
      temp[i] = this->array[i];
    }
    delete [] this->array;
    this->array = temp;
  }
  return ret;
}

int Stack::returnSize(){
  return this->size;
}

int Stack::returnCapacity(){
  return this->capacity;
}

bool Stack::isEmpty(){
  return this->size == 0;
}
