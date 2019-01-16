#include "Queue.h"
#include <stdlib.h>
#include <iostream>

Node::Node(int data, Node *next){
    this->data = data;
    this->next = next;
}

Queue::Queue(){
  this->head = nullptr;
  this->tail = nullptr;
}

void Queue::enqueue(int data){
  Node *newN= new Node;
  newN->data = data;
  newN->next = nullptr;
  if(this->head == nullptr){
    this->head = this->tail = newN;
  }else{
    this->tail->next = newN;
    this->tail = newN;
  }
}

int Queue::dequeue(){
  if(this->head == nullptr){
    this->tail = nullptr;
    return -1;
  }
  int ret = this->head->data;
  this->head = this->head->next;
  return ret;
}
