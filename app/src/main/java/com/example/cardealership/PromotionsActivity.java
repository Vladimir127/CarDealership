package com.example.cardealership;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.cardealership.Adapters.PromotionAdapter;
import com.example.cardealership.DataModels.PromotionModel;

import java.util.ArrayList;

/** Экран списка акций */
public class PromotionsActivity extends AppCompatActivity {

    /** Коллекция акций */
    private ArrayList<PromotionModel> mPromotionsList;

    /** Адаптер, соединяющий коллекцию акций со списком на экране */
    PromotionAdapter mPromotionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);

        // Инициализируем список акций
        initializeListView();

        // Настраиваем панель приложения и устанавливаем ей заголовок
        initializeActionBar();
    }

    /**
     * Инициализирует список акций
     */
    private void initializeListView() {
        mPromotionsList = new ArrayList<PromotionModel>();
        mPromotionsList.add(new PromotionModel(R.drawable.promotion1));
        mPromotionsList.add(new PromotionModel(R.drawable.promotion2));
        mPromotionsList.add(new PromotionModel(R.drawable.promotion3));
        mPromotionsList.add(new PromotionModel(R.drawable.promotion4));
        mPromotionsList.add(new PromotionModel(R.drawable.promotion5));

        // Находим элемент ListView - список, в котором будут отображаться акции на экране
        ListView promotionsListView = findViewById(R.id.promotionListView);

        // Инициализируем Адаптер, который будет связывать данные со списком ListView на экране
        mPromotionAdapter = new PromotionAdapter(this, mPromotionsList);

        // Назначаем списку этот адаптер
        promotionsListView.setAdapter(mPromotionAdapter);
    }

    /**
     * Добавляет на панель действий иконку "Назад" и заголовок
     */
    private void initializeActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Акции");
        setSupportActionBar(toolbar);

        // Для отображения стрелки назад на панели приложения
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
