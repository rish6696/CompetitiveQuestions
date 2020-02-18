#include<iostream>
#include<vector>
#include<stack>
using namespace std;

class Node {
    public:
    int val ;
    vector<Node*> childrens;

    Node(){

    }

    Node(int val){
        this->val=val;
    }

};


Node* getTail(Node* node){
    while(node->childrens.size()!=0){
        node =node->childrens[0];
    }
    return node;
}


Node* getTailOptimize(Node* node){
  
  while( node->childrens.size()!=0 ){
    node= node->childrens[node->childrens.size()-1];
  }
  return node;

}


void serialLize(Node * node){
    if(node->childrens.size()==0)return ;
    vector<Node*> tails(node->childrens.size()-1);
    for(int i=0;i<node->childrens.size();i++){
        if(i<=node->childrens.size()-2){
            tails[i]=getTailOptimize(node->childrens[i]);
        }
        serialLize(node->childrens[i]);
    }
    

    for(int i=node->childrens.size()-1;i>=1;i--){
        Node* tail =tails[i-1];
        tail->childrens.push_back(node->childrens[i]);

        node->childrens.pop_back();

    }



}

Node* createTree(vector<int>&arr){
 stack <Node *> st;
 for (int  i = 0; i < arr.size()-1; i++)
 {
    if(arr[i]!=-1){
       Node * newNode =new Node(arr[i]);
       st.push(newNode);
    }else{
        Node* prev =st.top();
        st.pop();
        st.top()->childrens.push_back(prev);
         
    }
 }
 return st.top();
 
}



void display(Node* node){
    cout<<node->val<<"=>";
    for(Node* c:node->childrens){
       cout<<c->val<<" ";
    }
    cout<<endl;
    for(Node* c:node->childrens){
       display(c);
    }
}


int main(){
    vector<int> order ={100,20,80,-1,50,-1,60,-1,-1,30,10,-1,15,-1,18,-1,-1,40,44,-1,34,-1,45,-1,-1,-1};

   // vector<int> order={10,20,30,-1,40,-1,-1,-1};

   // vector<int> order={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, -1, -1};
    Node * node =createTree(order);
    display(node);
    cout<<"********************************************"<<endl;
    serialLize(node);
    
    display(node);
    return 0;
}
