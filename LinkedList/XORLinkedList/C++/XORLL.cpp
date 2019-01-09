#include <stdio.h>
#include <cstdlib>
#include <cstdint>

class Node{

public:
    int data;
    Node *XOR;

    Node() = default;
};

Node* returnXOR(Node *a, Node *b){
    return (Node*)((uintptr_t) (a) ^ (uintptr_t) (b));
}

class XORDLL{

    public:
        Node *head;

        XORDLL(){
            head = NULL;
        }

        void addFirst(int data){
            // Make a newNode pointer
            Node *newNode = new Node();

            // Set the variables
            newNode->data = data;
            newNode->XOR = returnXOR(head, NULL);

            // If the head is not empty set the XOR of the head to the next XOR the newNode
            if(head != NULL){
                head->XOR = returnXOR(newNode, returnXOR(head->XOR, NULL));
            }

            // Set the newNode to the head
            head = newNode;
        }

        void removeFirst(){
            // If head is equal to NULL, do nothing
            if(head == NULL){
                return;
            }
            
            // Store current head
            Node *tmp = head;

            // Set head equal to the next address
            if(tmp->XOR != NULL){
                head = returnXOR(tmp->XOR, NULL);
                head->XOR = returnXOR(head->XOR, tmp);
            }else{
                head = NULL;
            }
            
            // Free tmp variable
            delete tmp;
        }

        void printList(){
            Node *current = head;
            Node *prev = NULL;
            Node *next;
            while(current != NULL){
                printf("%d ", current->data);
                next = returnXOR(current->XOR, prev);
                prev = current;
                current = next;
            }
            printf("\n");
        }
};