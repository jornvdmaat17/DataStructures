#include <iostream>

class Node{

    public:
        int value;
        Node *next;

        Node() = default;
};


class SLL{

    public:
        Node *head;

        SLL(){
            head = nullptr;
        }

        void insert(int value){
            Node *newNode = new Node;
            newNode->value = value;
            newNode->next = head;
            head = newNode;
        }

        void remove(){
            if(head == nullptr){
                return;
            }
            Node *tmp = head;
            head = tmp->next;
            delete tmp;
        }
        
        void printList(){
            Node *current = head;
            while(current != nullptr){
                std::cout << current->value << " ";
                current = current->next;
            }
            std::cout << std::endl;
            free(current);
        }        
};
