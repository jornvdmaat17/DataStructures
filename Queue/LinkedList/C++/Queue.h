#ifndef QUEUE_H
#define QUEUE_H

class Node{

public:
  int data;
  Node *next;

  Node(int data, Node *next);
};

class Queue{

public:
  Node *head;
  Node *tail;

  Queue();
  void enqueue(int data);
  int dequeue();
};

#endif
