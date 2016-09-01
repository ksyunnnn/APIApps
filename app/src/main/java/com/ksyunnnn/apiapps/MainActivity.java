package com.ksyunnnn.apiapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://wired.jp")
                .addConverterFactory(SimpleXmlConverterFactory.create()) // SimpleXmlConverterを指定
                .build();

        Call<Rss> call = retrofit.create(WiredApi.class)
                .wiredGet();

        call.enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                Log.d("AAA", "Successed to request");

                Rss Rss = response.body();


                ((TextView) findViewById(R.id.top_title)).setText("成功");

                /*BookmarkItemAdapter adapter = new BookmarkItemAdapter(MainActivity.this, R.layout.list_item, items);
                mListView.setAdapter(adapter);*/

               /* mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Item item = (Item) parent.getItemAtPosition(position);

                        // リストをクリックするとブラウザへ遷移させる
                        Uri uri = Uri.parse(item.getLink());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });*/
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Log.d("AAA", "Failed to request : " + t.getCause() + ", " + t.getMessage());
                ((TextView) findViewById(R.id.top_title)).setText(t.getCause() + ", " + t.getMessage());
                t.printStackTrace();
            }
        });


    }
}
