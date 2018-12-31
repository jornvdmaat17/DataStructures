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
  Node *newN= (Node*) malloc(sizeof(Node));
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
  // printf("%d\n", this->head->data);
  Node *ret = this->head;
  this->head = this->head->next;
  return ret->data;
}

int main(){
  Queue q;
  q.enqueue(7);
  q.enqueue(8);
  std::cout << q.dequeue() << std::endl;
  q.enqueue(9);
  std::cout << q.dequeue() << std::endl;
  return 0;
}
