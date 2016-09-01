package com.ksyunnnn.apiapps;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
    private List<String> titles = new ArrayList<String>();
    private List<String> contents = new ArrayList<String>();
    private List<String> links = new ArrayList<String>();
    private List<String> images = new ArrayList<String>();
    Random rnd = new Random();
    int rand = rnd.nextInt(10);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** ボタン押したらページ遷移する **/
        Button input_btn = (Button) findViewById(R.id.button);
        input_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        AsyncGet asyncGet = new AsyncGet(new AsyncCallback() {



            public void onPreExecute() {
                // do something
            }
            public void onProgressUpdate(int progress) {
                // do something
            }
            public void onPostExecute(String result) {
                // do something
                Log.d("onPostExecute", result);
                try {;
                    parseXml(result);
                } catch (XmlPullParserException | IOException e) {
                    e.printStackTrace();
                }

                if (!titles.get(rand).isEmpty()){

                    ((TextView) findViewById(R.id.title)).setText(titles.get(rand));

                }
                if (!images.get(rand).isEmpty()){
                    ((TextView) findViewById(R.id.content)).setText(contents.get(rand));
                }
                if (!links.get(rand).isEmpty()){
                    Button name_btn = (Button) findViewById(R.id.button2);
                    name_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(links.get(rand)));

                            startActivity(intent);
                        }
                    });
                }
                int i = rand -1 ;
                if (!images.get(i).isEmpty()){
                    //imageを取得
                    ImageView image = (ImageView) findViewById(R.id.back_image);
                    //画像取得スレッド起動
                    ImageGetTask task = new ImageGetTask(image);
                    task.execute(images.get(i));
                }

            }
            public void onCancelled() {
                // do something
            }
        });
        asyncGet.execute("http://wired.jp/rssfeeder/");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void parseXml(String result) throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(result));

        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {

            if (eventType == XmlPullParser.START_TAG) {
                if (parser.getName().equals("title")) {
                    titles.add(parser.nextText()) ;
                }
                if (parser.getName().equals("description")) {
                    contents.add(parser.nextText()) ;
                }
                if (parser.getName().equals("link")) {
                    links.add(parser.nextText()) ;
                }
                if (parser.getName().equals("image")) {
                    images.add(parser.nextText()) ;
                }



            }
            eventType = parser.next();
        }
    }

}

