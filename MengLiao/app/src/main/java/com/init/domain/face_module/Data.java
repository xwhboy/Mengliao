package com.init.domain.face_module;

/**
 * Created by zoson on 5/12/15.
 */
public class Data {
    private int size;
    private int maxSize;
    private float[] data; //数据总是从小到大排列的
    public Data(int s){
        maxSize = s;
        data = new float[maxSize];
        size = 0;
    }
    public int getSize(){ return size;}
    public int getMaxSize(){ return maxSize;}
    public void insert(float d){
        if(size<=maxSize){
            data[size++] = d;
        }else{//如果超出maxSize了就随机挤掉一个数据
            int index = (int)(Math.random()*maxSize);
            data[index] = d;
        }
        sort(data);
    }
    //选择排序
    public void sort(float[] d) {
        for (int i = 0; i < d.length - 1; i++) {
            int min = i;
            for (int j = i; j < d.length; j++) {
                if (d[min] > d[j]) {
                    min = j;
                }
            }
            if (min != i) {
                float temp = d[min];
                d[min] = d[i];
                d[i] = temp;
            }
        }
    }
    public float getIndex(int i){
        if(i>=0&&i<size)
            return data[i];
        else
            return -1;
    }

    //数据求和
    public float sum(){
        float s = 0;
        for(int i=0;i<size;i++){
            s += data[i];
        }
        return s;
    }
}


