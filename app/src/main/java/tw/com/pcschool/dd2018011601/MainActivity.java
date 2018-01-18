package tw.com.pcschool.dd2018011601;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        String str = getFilesDir().getAbsolutePath();
        Log.d("FILE", str);
        String str1 = getCacheDir().getAbsolutePath();
        Log.d("FILE", str1);
    }
    public void click2(View v)
    {
        File f1 = new File(getFilesDir(), "myFiletext.txt");
        try {
            FileWriter fw1 = new FileWriter(f1);
            fw1.write("Hello,world!");
            fw1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void click3(View v)
    {
        ArrayList<String> mylist1 = new ArrayList<>();
        mylist1.add("Dirk");
        mylist1.add("Kidd");
        mylist1.add("Terry");
        File f1 = new File(getFilesDir(), "myFileList2.txt");
        FileWriter fw1 = null;
        try {
            fw1 = new FileWriter(f1);
            Gson gson = new Gson();
            String data = gson.toJson(mylist1);
            fw1.write(data);
            fw1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clickRead1(View v)
    {
        File f = new File(getFilesDir(),"myFileList2.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("FILE", str);
            Gson gson = new Gson();
            ArrayList<String> mylist = gson.fromJson(str, new TypeToken<ArrayList<String>>(){}.getType());
            for (String s:mylist)
            {
                Log.d("FILE", "myList: " + s);
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    class Student
    {
        public int id;
        public String name;
        public int score;
        public Student(int id, String name, int score)
        {
            this.id = id;
            this.name = name;
            this.score = score;
        }
    }
    public void click4(View v)
    {
        ArrayList<Student> myData1 = new ArrayList<>();
        myData1.add(new Student(1, "Dirk", 100));
        myData1.add(new Student(2, "Irving", 95));
        myData1.add(new Student(3, "Rose", 90));

        File f1 = new File(getFilesDir(), "myFileData3.txt");
        FileWriter fw1 = null;
        try {
            fw1 = new FileWriter(f1);
            Gson gson = new Gson();
            String data = gson.toJson(myData1);
            fw1.write(data);
            fw1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clickRead2(View v)
    {
        File f = new File(getFilesDir(),"myFileData3.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("FILE", str);
            Gson gson = new Gson();
            ArrayList<Student> mydata = gson.fromJson(str, new TypeToken<ArrayList<Student>>(){}.getType());
            for (Student s:mydata)
            {
                Log.d("FILE", "myData: " + "ID:" + s.id + ",姓名:" + s.name + ",分數:" + s.score);
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void click5(View v)
    {
        File f = getExternalFilesDir("data");
        Log.d("FILE", f.getAbsolutePath());
    }
    public void click6(View v)
    {
        File f = Environment.getExternalStorageDirectory();
        Log.d("FILE", f.getAbsolutePath());
    }
}
