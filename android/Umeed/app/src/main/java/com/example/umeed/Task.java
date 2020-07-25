package com.example.umeed;

public class Task {
    private String mTask;
    private int mCount;
    private boolean mVerify;

    public Task(String task, int count, boolean verify) {
        mTask = task;
        mCount = count;
        mVerify = verify;
    }

    private boolean isVerified(){
        return mVerify;
    }

    private void changeVerified(boolean verify){
        //TODO: change verify;
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

    public boolean ismVerify() {
        return mVerify;
    }

    public void setmVerify(boolean mVerify) {
        this.mVerify = mVerify;
    }

}
