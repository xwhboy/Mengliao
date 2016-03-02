package com.init.domain.face_module;

/**
 * Created by zoson on 5/12/15.
 */
public class Limit {
    private int count;   //阀值的个数
    private float[] limit;
    private Data[] dataInLimit;//阀值内的数据
    public Limit(int c, int maxSize){
        count = c;
        dataInLimit =new Data[c+1];
        limit = new float[c];
        for(int i=0;i<dataInLimit.length;i++){
            dataInLimit[i] = new Data(maxSize);
            if(i<limit.length)
                limit[i] = 0;     //初始化为0
        }
    }
    public void insert(int index, float d){
        if(index<0||index>=dataInLimit.length)
            return;
        dataInLimit[index].insert(d);
        if(index>=1)
            limit[index-1] = findLimit(index);
        if(index+1<dataInLimit.length)
            limit[index] = findLimit(index+1);
    }
    //更新阀值
    private float findLimit(int index){
        if(dataInLimit[index-1].getSize()==0||dataInLimit[index].getSize()==0)
            return 0;
        int i_1 = dataInLimit[index-1].getSize()-1;
        int i_2 = 0;
        while(dataInLimit[index-1].getIndex(i_1)>dataInLimit[index].getIndex(0)){
            i_1--;
            if(i_1<0)
                break;
        }
        int temp = dataInLimit[index-1].getSize()-1;
        while(dataInLimit[index].getIndex(i_2)<dataInLimit[index-1].getIndex(temp)){
            i_2++;
            if(i_2>dataInLimit[index].getSize())
                break;
        }
        return (dataInLimit[index-1].getIndex(i_1)+dataInLimit[index].getIndex(i_2))/(float)2.0;
    }
    public float getIndex(int index){
        if(index>=0&&index<limit.length)
            return limit[index];
        return -1;
    }
    public int returnIndex(float d){
        int i;
        boolean isEmpty = true;
        for(i=0;i<limit.length;i++){
            if(limit[i]!=0&&d>=limit[i]) {
                isEmpty = false;
                break;
            }
        }
        if(isEmpty)
            return 0;
        else
            return i;
    }

    //part指示是那个部位的数据，显示是在文本框中
    public void out(String part){
        System.out.print(part);
        for(int i=0;i<dataInLimit.length;i++){
            System.out.print(dataInLimit[i].sum()+"  ");
        }
        System.out.println();
    }

}

