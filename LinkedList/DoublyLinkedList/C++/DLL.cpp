#include <iostream>

class Node {

    public:
        int value;
        Node *prev;
        Node *next;

        Node() = default;

        Node(int value, Node *prev, Node *next){
            this->value = value;
            this->prev = prev;
            this->next = next;
        }
};

class DLL {


    public:
        Node *head;
        Node *tail;
        int size;

    public:
        DLL(){
            head = tail = nullptr;
            size = 0;
        }

        void insertFirst(int value){
            Node *newNode = new Node;
            newNode->value = value;
            newNode->next = head;
            if(head == nullptr){
                tail = newNode;
            }else{
                head->prev = newNode;
            }   
            head = newNode;
            size++;
        }

        void insertLast(int value){
            Node *newNode = new Node;
            newNode->value = value;
            newNode->prev = tail;
            if(tail == nullptr){
                head = newNode;
            }else{
                tail->next = newNode;
            }
            tail = newNode;
            size++;
        }

        void insertAtPos(int value, int pos){
            if(pos <= 1){
            insertFirst(value);
            return;
            }
            if(pos >= size){
                insertLast(value);
                return;
            }
            Node *current = head;
            for(int i = 2; i < pos; i++){
                current = current->next;
            }
            Node *tmp = current->next;
            Node *newNode = new Node;
            newNode->value = value;
            newNode->prev = current;
            newNode->next = tmp;
            current->next = newNode;
            tmp->prev = newNode;    
            free(tmp);    
            size++;
        }

        void printList(){
            Node *current = head;
            while(current != nullptr){
                std::cout << current->value << " ";
                current = current->next;
            }
            std::cout << std::endl;
        }


        int getSize(){
            return size;
        }

        bool isEmpty(){
            return size == 0;
        }


        void removeFirst(){
            if(head != nullptr){
                head = head->next;
                if(head != nullptr){
                    head->prev = nullptr;
                }
                size--;
            }        
        }

        void removeLast(){
            if(tail != nullptr){
                tail = tail->prev;
                if(tail != nullptr){
                    tail->next = nullptr;
                }
                size--;
            }       
        }

        void removeAtPos(int pos){
            if(pos <= 1){
                removeFirst();
                return;
            }
            if(pos >= size){
                removeLast();
                return;
            }
            Node *current = head->next;
            for(int i = 2; i < pos; i++){
               current = current->next;
            }
            Node *p = current->prev;
            Node *n = current->next;
            p->next = n;
            n->prev = p;     
            size--;
        }
};
