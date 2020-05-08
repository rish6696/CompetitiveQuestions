#include<iostream>
using namespace std;


int main(){
int a = 20;
int *p = &a;

int **x =&p;
//*p++;
cout<<**x<<endl;
return 0;
}