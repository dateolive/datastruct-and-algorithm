'''
稀疏数组
Author: 张壬丰
'''
class SparseArray(object):
    #打印二维数组
    def print_array(self,array):
        for row_item in array:
            for data in row_item:
                print("%d" % data,end="\t")
            print("\n")
    #二维数组转化为稀疏数组
    def change_to_sparse(self,array):
        if array=="":
            return
        sum=0
        for row_num in range(len(array)):
            for col_num in range(len(array[0])):
                if array[row_num][col_num]!=0:
                    sum+=1
        sparse_arrar=[[0 for i in range(3)] for j in range(sum+1)]
        sparse_arrar[0][0]=len(array)
        sparse_arrar[0][1]=len(array[0])
        sparse_arrar[0][2]=sum
        flag=0
        for row_index,row_item in enumerate(array):
            for col_index,col_item in enumerate(row_item):
                if col_item:
                    flag+=1
                    sparse_arrar[flag][0]=row_index
                    sparse_arrar[flag][1]=col_index
                    sparse_arrar[flag][2]=col_item
        return sparse_arrar
    #将稀疏数组转化成二维数组
    def change_to_Two_dimension_array(self,array):
        tow_dimension_array=[[0 for i in range(array[0][0])] for j in range(array[0][1])]
        for index,item in enumerate(array):
            if index==0:
                continue
            tow_dimension_array[item[0]][item[1]]=item[2]
        return  tow_dimension_array

if __name__=="__main__":
    row=11  #行数
    col=11 #列数
    #创建二维数组
    array1=[[0 for i in range(col)] for j in range(row)]
    array1[1][2]=1
    array1[2][3]=2
    obj=SparseArray()
    obj.print_array(array1)
    sparse_Arr=obj.change_to_sparse(array1)
    obj.print_array(sparse_Arr)
    tow_dimension_Arrar=obj.change_to_Two_dimension_array(sparse_Arr)
    obj.print_array(tow_dimension_Arrar)


