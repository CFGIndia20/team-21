package com.example.umeed;

public class Task {
    private String mTask;
    private int mCount;
    private boolean mVerify;

    public Task(String task, int count) {
        mTask = task;
        mCount = count;
    }



    public String getmTask() {
        return mTask;
    }

    public void setmTask(String mTask) {
        this.mTask = mTask;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }



}
