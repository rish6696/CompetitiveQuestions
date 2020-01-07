#include<iostream>
#include<vector>
using namespace std;

bool isPrime(int n){
    for(int i=2;i<=n-1;i++){
        if(n%i==0){
            return false;
        }
        return true;
    }
}
vector<int>& getPrimeNumbers(int from,int to){
    vector<int> values;
    for(int i=from ;i<=to;i++){
        if(isPrime(i)){
            values.push_back(i);
        }
    }
    return values;
 
}
int main(){ 
    int from =2;
    int to=20;
    vector<int> primes=getPrimeNumbers(from,to);

    
    return 0;
 }