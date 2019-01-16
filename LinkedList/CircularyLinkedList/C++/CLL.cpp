#include <iostream>

class Node{
    
    public:
        int value;
        Node *next;

        Node() = default;
};

class CLL{

    private:
        Node *head;
        Node *tail;
        int size;

    public:
        CLL(){
            head = tail = nullptr;
            size = 0;
        }

        void insertFirst(int value){
            Node *newNode = new Node;
            newNode->value = value;
            if(head == nullptr){
                head = tail = newNode;
                head->next = head;
            }else{
                newNode->next = head;
                head = newNode;
                tail->next = head;
            }
            size++;
        }

        void insertLast(int value){
            if(head == nullptr){
                insertFirst(value);
            }else{
                Node *newNode = new Node;
                newNode->value = value;
                tail->next = newNode;
                tail = newNode;
                tail->next = head;
                size++;
            }
        }

        void removeFirst(){
            if(head == nullptr){
                return;
            }
            if(head->next == head){
                head = nullptr;
                return;
            }
            head = head->next;
            tail->next = head;
            size--;
        }

        void printList(){
            if(head != nullptr){
                Node *current = head;
                while(true){
                    std::cout << current->value << " ";
                    current = current->next;
                    if(current == head){
                        break;
                    }
                }
            }            
            std::cout << std::endl;
        }

        int getSize(){
            return size;
        }     

};

int main(){
    CLL l;
    l.insertFirst(2);
    l.insertFirst(1);
    l.insertLast(3);
    l.removeFirst();
    l.removeFirst();
    l.removeFirst();
    l.removeFirst();
    l.printList();

    return 0;
}
