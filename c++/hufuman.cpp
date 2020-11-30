#include<bits/stdc++.h>
using namespace std;
struct HuffmanTree{
	int value;//权值
	int parent;
	int left;//zuo
	int right; //you
	bool flag;
};
bool cmp(const pair<char,int>& a,const pair<char,int>& b){
	return a.second<b.second;
}
//创建哈夫曼树 
void CreateHuffmanTree(HuffmanTree *&huffman,vector <pair<char,int> > v){
		huffman=new HuffmanTree[2*v.size()-1];
		int n=v.size();//叶子数 
		int cnt=2*v.size()-1;//节点数 
		for(int i=0;i<cnt;i++){
			if(i<n){
				huffman[i].value=v[i].second;	
			}else{
				huffman[i].value=0;
			}
			huffman[i].parent=-1;
			huffman[i].left=-1;
			huffman[i].right=-1;
		}
	int mini1, mini2;  
    int x1, x2;  //记录最小值和次小值位置
    for (int i = 0; i < n-1; i++) {
        mini1 = mini2 = INT_MAX;
        x1 = x2 = 0;
        for (int j = 0; j < n + i; j++) {
            if (huffman[j].value < mini1 && !huffman[j].flag) {
                mini2 = mini1;
                x2 = x1;
                mini1 = huffman[j].value;
                x1 = j;
            } else if (huffman[j].value < mini2 && !huffman[j].flag) {
                mini2 = huffman[j].value;
                x2 = j;
            }
        }
        huffman[n + i].value = mini1 + mini2;
        huffman[n + i].left = x1;
        huffman[n + i].right = x2;
        huffman[x1].parent = n + i;
        huffman[x2].parent = n + i;
        huffman[x1].flag = true;
        huffman[x2].flag = true;
    }


}
//哈夫曼编码 
void CreateHuffmanCode(HuffmanTree *&huffman,vector<string> &code, int index,int p)//创建哈夫曼树编码
{
	while (huffman[p].parent!=-1)
	{
		int temp = huffman[p].parent;
		if (huffman[temp].left == p)//若左，则编码置0，若右，编码置1
			code[index].insert(code[index].begin(), '0');
		else if (huffman[temp].right == p)
			code[index].insert(code[index].begin(), '1');
		p = huffman[p].parent;
	}
}
int main(){
	vector<pair<char,int> >obj;
//统计字符用map 
    map<char,int>mp;
	HuffmanTree* huffman;
	char s[1000] = "The Chinese official said he viewed the Trump Presidency not as 6 an aberration but as the product of a failing political system. This jibes with other accounts. The Chinese leadership believes that the United States, and Western democracies in general, haven't risen to the challenge of a globalized economy, which necessitates big changes in production patterns, as well as major upgrades in education and public infrastructure. In Trump and Trumpism, the Chinese see an inevitable backlash to this failure.";
	for(int i=0;i<strlen(s);i++){
		mp[s[i]]++;
	}
	map<char,int>::iterator it;	
	cout<<"字符频率"<<endl; 
	for(it=mp.begin();it!=mp.end();it++){
		cout<<it->first<<" "<<fixed<<setprecision(2)<<float((it->second)*1.0/mp.size())<<endl;
		obj.push_back(make_pair(it->first,it->second));
	} 
	cout<<"总个数"<<mp.size()<<endl;
	sort(obj.begin(),obj.end(),cmp);
	CreateHuffmanTree(huffman,obj);
	cout << endl << "哈夫曼树如下所示：" << endl;
	cout << "结点i" << setw(8) << "value" << setw(8) << "parent" << setw(8) << "left" << setw(8) << "right" << endl;
	for (int i = 1; i < obj.size()*2-1; i++)
	{
		if (i <= obj.size())
			cout << i << setw(8) << huffman[i].value << setw(8) << huffman[i].parent << setw(8) << huffman[i].left << setw(8) << huffman[i].right << endl;
		else
		cout << i << setw(8) << huffman[i].value << setw(8) << huffman[i].parent << setw(8) << huffman[i].left<< setw(8) << huffman[i].right<< endl;
	}
	vector<string> code(obj.size(), "");
	cout<<endl << "哈夫曼编码：" << endl;
	for (int i = 0; i <obj.size(); i++)
	{
		CreateHuffmanCode(huffman, code, i, i);
		cout<<obj[i].first<<":"<<code[i]<<endl;
	}
	
	 
}
//The Chinese official said he viewed the Trump Presidency not as an aberration but as the product of a failing political system. This jibes with other accounts. The Chinese leadership believes that the United States, and Western democracies in general, haven’t risen to the challenge of a globalized economy, which necessitates big changes in production patterns, as well as major upgrades in education and public infrastructure. In Trump and Trumpism, the Chinese see an inevitable backlash to this failure.
