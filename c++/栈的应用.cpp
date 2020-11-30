#include<bits/stdc++.h>
//这里用了stl库的stack 
using namespace std;
int main(){
	stack<char>s;
	int n;
	char str;
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>str;
		if(s.empty()){
			s.push(str);
		}
		else if(s.top()=='(' && str==')'||s.top()=='{' && str=='}'||s.top()=='[' && str==']' ){
			s.pop();
		}
		else{
			s.push(str);
		}
	}
	if(s.empty()){
			printf("YES");
	}
	else{
		printf("NO");
	}

	return 0;
}

