package com.example.cardealership;

import android.content.Intent;
import android.os.Bundle;

import com.example.cardealership.DataModels.CarModel;
import com.google.android.material.appbar.AppBarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class CarActivity extends AppCompatActivity {

    /** Автомобиль, информация о котором отображается на экране */
    private CarModel car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        car = intent.getParcelableExtra("car");

        initializeActionBar();

        fillTextViews();
    }

    /** Настраивает панель приложения и устанавливает ей заголовок */
    private void initializeActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(car.getName());
        setSupportActionBar(toolbar);

        // Для отображения стрелки назад на панели приложения
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView expandedImageView = findViewById(R.id.expanded_image);
        expandedImageView.setImageResource(car.getImageId());

        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener(){

            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
            }
        });
    }

    /** Заполняет текстовые надписи информацией о машине */
    private void fillTextViews() {
        TextView priceTextView = findViewById(R.id.text_view_price);
        priceTextView.setText(car.getPrice() + " р.");

        TextView yearTextView = findViewById(R.id.text_view_year);
        yearTextView.setText(String.valueOf(car.getYear()));

        TextView volumeTextView = findViewById(R.id.text_view_volume);
        volumeTextView.setText(car.getVolume() + " л.");

        TextView gearTypeTextView = findViewById(R.id.text_view_gear_type);

        String gearType = "";
        switch (car.getGearType()){
            case MANUAL:
                gearType = "Ручная";
                break;
            case AUTOMATIC:
                gearType = "Автоматическая";
                break;
            case ROBOTIC:
                gearType = "Роботизированная";
                break;
        }

        gearTypeTextView.setText(gearType);

        TextView powerTextView = findViewById(R.id.text_view_power);
        powerTextView.setText(car.getPower() + " л.с.");
    }

    /**
     * Вызывается при выборе пункта меню
     * @param item Выбранный пункт меню
     * @return True в случае успешной обработки, иначе False
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
