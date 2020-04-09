#include<iostream>
#include<vector>
#include<stack>
using namespace std;



      vector<int> ngor(vector<int> &arr)
{
    int n = arr.size();
    vector<int> ans(n, n);
    stack<int> st;

    for (int i=0;i<n;i++)    {
        while (st.size() != 0 && arr[st.top()] < arr[i]) 
        {
            int idx = st.top();
            st.pop();
            ans[idx] = i;
        }

        st.push(i);
    }
    return ans;
}
   
    vector<int> ngol(vector<int> &arr)
{
    int n = arr.size();
    vector<int> ans(n, -1);
    stack<int> st;

    for (int i = n - 1; i >= 0; i--)    {
        while (st.size() != 0 && arr[st.top()] < arr[i]) 
        {
            int idx = st.top();
            st.pop();
            ans[idx] = i;
        }

        st.push(i);
    }
    return ans;
}
      int trap(vector<int> &height) {
        if(height.size()==0) return 0;
        vector<int> right=ngor(height);
        vector<int> left=ngol(height);
        int min_area=0;
        for(int i=0;i<height.size();i++){
           int l = left[i];
           int r  = right[i];
            
           if(l!=-1 && r!=height.size()){
               cout<<"for "<< i  <<"left is "<<height[l]<<"and right is "<<height[r];
               int a = min(height[l],height[r]) - height[i];
               cout<<" cal is "<< a<<endl;
               min_area+=a;
           }     
     }
        return min_area;
    }



 

int main(){ 
    vector<int> a ={0,1,0,2,1,0,1,3,2,1,2,1};
    cout<<trap(a)<<endl;
    return 0;
}