package skr.com.day02.utils;

import android.os.AsyncTask;

public class MyTask<T> extends AsyncTask<T,T,String> {
    String mPath;
    String mRam;
    private TaskListeners taskListeners;

    public MyTask(String mPath, String mRam) {
        this.mPath = mPath;
        this.mRam = mRam;
    }
    public MyTask setTaskListener(TaskListeners taskListener){
        this.taskListeners=taskListener;
        return this;
    }

    @Override
    protected String doInBackground(T... ts) {
        return HttpUrlUtils.getHttpCon(mPath,mRam);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s!=null){
            taskListeners.result(s);
        }
    }

    @Override
    protected void onProgressUpdate(T... values) {
        super.onProgressUpdate(values);
    }
    public interface TaskListeners{
        void result(String t);
    }
}
