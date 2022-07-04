package ac.id.unikom.observer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView helloWorld;
    private MutableLiveData<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloWorld = findViewById(R.id.hello_world);
        data = new MutableLiveData<>();

        data.observe(this, data -> {
            helloWorld.setText(data);
        });

        new Handler().postDelayed(() -> {
            data.postValue("Cuaca hari ini cerah ya?");
        }, 1000);

        new Handler().postDelayed(() -> {
            data.postValue("Kamu suka ga?");
        }, 2000);

        new Handler().postDelayed(() -> {
            data.postValue("Cerah gini enaknya ngapain yah?");
        }, 3000);
    }
}