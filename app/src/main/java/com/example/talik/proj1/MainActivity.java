package com.example.talik.proj1;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Spanned;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.view.KeyEvent;
import  android.view.View.OnKeyListener;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.server.converter.StringToIntConverter;

import static android.R.attr.id;
import static com.example.talik.proj1.R.*;

public class MainActivity extends AppCompatActivity {
    //private final static String FILENAME = "code.txt"; // имя файла
    FileOutputStream fos;

    final String LOG_TAG = "myLogs";

    final String FILENAME = "code.txt";

    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "code";
    int index = 0;
    Boolean state = true;

    Button buttonSend;
    EditText textTo;

    Timer timer;
    TimerTask mTimerTask;

    //EditText textSubject;
    EditText textMessage;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        buttonSend = (Button) findViewById(R.id.buttonSend);
        textTo = (EditText) findViewById(R.id.editTextTo);
        // textSubject = (EditText) findViewById(R.id.editTextSubject);
        textMessage = (EditText) findViewById(R.id.editTextMessage);

        timer = new Timer();
        mTimerTask = new MyTimerTask();
        timer.schedule(mTimerTask, 600000, 600000);
//        textMessage.setOnEditorActionListener(new TextView.OnEditorActionListener(){
//
//            @Override
//            public boolean onEditorAction(TextView v,  int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.KEYCODE_ENTER) {     //actionId == KeyEvent.KEYCODE_ENTER
//                    long date = System.currentTimeMillis();
//                SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
//                String dateString = sdf.format(date);
//                    textMessage.append(dateString);
//                    //добавление даты
//                    return true; }
//                return false; }
//        });




        textMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable text) {
                // Прописываем то, что надо выполнить после изменения текста
//                long date = System.currentTimeMillis();
//                SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
//                String dateString = sdf.format(date);

//                if (text.length() > 5) {
//                    text.append(dateString);
//                    char s = text.charAt(1);
//                    text.append(text.append("8"));
////                    DateFormat.getDateInstance().format(new Date())
//                }
//                int last = text.length();
//                String last = ""+last;
//                if(text.length() != 0){
//                String singlechar = "" + text.charAt(0);
//                    if (singlechar == "\\n") {
//                        text.append(dateString);
//                    }
//                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
                String dateString = sdf.format(date);
                String  strBefore=String.valueOf(s.charAt(s.length()-1));
//                if((s.length() > 10)  && state){
//                    state = false;
//                    String cnt = String.valueOf(s.length());
//                    textMessage.append(cnt);
//                    textMessage.setSelection(s.length());
////                    index = 0;
//                }
                if(strBefore.equals(" ")){
//                    String strAfter = s.toString().replace(" ", "/n");
//                    strAfter = dateString;
//                    textMessage.setText(textMessage.getText());
                    textMessage.append(dateString);
//                    textMessage.setSelection(s.length());
                    textMessage.setSelection(textMessage.getText().length());
                }
//                if(strBefore.equals(" ")) {
//                    state = true;
//                }

//                if(s == "7"){
//                    Toast.makeText(getApplicationContext(), "Maximum Limit Reached", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        textMessage.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
                String dateString = sdf.format(date);
                if( keyCode == KeyEvent.KEYCODE_ENTER ) {
                    if( event.getAction() == KeyEvent.ACTION_UP ) {
                        textMessage.append(dateString);
                    }
                    return true;

                }
                return false;
            }
        });


        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String to = textTo.getText().toString();
                //String subject = textSubject.getText().toString();
                String message = textMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                //email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //для того чтобы запросить email клиент устанавливаем тип
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Выберите email клиент :"));

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    class MyTimerTask extends TimerTask {
        @Override
        public void run() {

            // Берем дату и время с системного календаря:
//            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss a");

            // Преобразуем информацию в строковые данные:
//            final String strDate = simpleDateFormat.format(calendar.getTime());
            runOnUiThread(new Runnable(){

                // Отображаем информацию в текстовом поле count:
                @Override
                public void run() {
//                    textMessage.append("1");
                    saveFile(FILENAME);
                }});
        }
    }

    public void onDestroy() {
        moveTaskToBack(true);

        super.onDestroy();

        System.runFinalizersOnExit(true);
        System.exit(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        switch (item.getItemId()) {
            case R.id.action_delete:
                //openFile(FILENAME);
                textMessage.setText(" ");
                return true;
            case R.id.action_save:
                saveFile(FILENAME);
                return true;
            default:
                return true;
        }


        //return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    // Метод для сохранения файла
    private void saveFile(String fileName) {
//        try {
//            OutputStream outputStream = openFileOutput(fileName, 0);
//            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
//            osw.write(textMessage.getText().toString());
//            osw.close();
//        } catch (Throwable t) {
//            Toast.makeText(getApplicationContext(),
//                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
//        }


//        try {
//            //EditText textBox = (EditText) findViewById(R.id.save_text);
//            //String text = textBox.getText().toString();
//            String text = textMessage.getText().toString();
//
//            fos = openFileOutput("content.txt", MODE_APPEND);
//            fos.write(text.getBytes());
//            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
//            //Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
//        }
//        catch(IOException ex) {
//
//            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//        finally{
//            try{
//                if(fos!=null)
//                    fos.close();
//            }
//            catch(IOException ex){
//
//                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }


        // проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "SD-карта не доступна", Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        String text = textMessage.getText().toString();
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // создаем каталог
        sdPath.mkdirs();
        // формируем объект File, который содержит путь к файлу
        long date = System.currentTimeMillis();
//        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        SimpleDateFormat sdf = new SimpleDateFormat("d_MMM_yyyy__HH_mm_ss");
        String dateString = sdf.format(date);

        File sdFile = new File(sdPath, dateString + ".txt");



        try {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            // пишем данные


            bw.write(dateString + "\n");
            bw.append(text);
            // закрываем поток
            bw.close();
            textMessage.setText(" ");
            Toast.makeText(this, "Сохранен в " + sdFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            // отрываем поток для записи
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
//                    openFileOutput(FILENAME, MODE_APPEND)));
//            // пишем данные
//            bw.write("Содержимое файла");
//            // закрываем поток
//            bw.close();
//            Log.d(LOG_TAG, "Файл записан");
//            Toast.makeText(this, "Сохранен", Toast.LENGTH_SHORT).show();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
