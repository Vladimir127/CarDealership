package com.example.cardealership;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.cardealership.Adapters.CarAdapter;
import com.example.cardealership.DataModels.CarModel;
import com.example.cardealership.DataModels.GearType;

import java.util.ArrayList;

/** Экран списка автомобилей */
public class CatalogActivity extends AppCompatActivity {

    /** Коллекция автомобилей */
    private ArrayList<CarModel> mCarsList;

    /** Адаптер, соединяющий коллекцию машин со списком на экране */
    CarAdapter mCarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Определяем макет пользовательского интерфейса
        setContentView(R.layout.activity_catalog);

        // Инициализируем список
        initializeListView();

        // Настраиваем панель приложения и устанавливаем ей заголовок
        initializeActionBar();
    }

    /**
     * Инициализирует список машин
     */
    private void initializeListView() {
        mCarsList = new ArrayList<CarModel>();
        mCarsList.add(new CarModel("BMW 320 xDrive", 2019, 2.0, GearType.AUTOMATIC, 184, 2100000, R.drawable.bmw_320_xdrive_preview, R.drawable.bmw_320_xdrive));
        mCarsList.add(new CarModel("BMW X5M", 2016, 4.4, GearType.AUTOMATIC, 575, 4750000, R.drawable.bmw_x5m_preview, R.drawable.bmw_x5m));
        mCarsList.add(new CarModel("BMW 530i", 2018, 2.0, GearType.AUTOMATIC, 249, 2710000, R.drawable.bmw_530i_preview, R.drawable.bmw_530i));
        mCarsList.add(new CarModel("BMW M2 F87", 2019, 3.0, GearType.ROBOTIC, 410, 4950000, R.drawable.bmw_m2_f87_preview, R.drawable.bmw_m2_f87));
        mCarsList.add(new CarModel("BMW M850", 2020, 4.4, GearType.AUTOMATIC, 530, 9500000, R.drawable.bmw_m850_preview, R.drawable.bmw_m850));
        mCarsList.add(new CarModel("BMW M5 Competition", 2019, 4.4, GearType.AUTOMATIC, 625, 6900000, R.drawable.bmw_m5_competition_preview, R.drawable.bmw_m5_competition));
        mCarsList.add(new CarModel("Audi A4", 2015, 2.0, GearType.ROBOTIC, 190, 1700000, R.drawable.audi_a4_preview, R.drawable.audi_a4));
        mCarsList.add(new CarModel("Audi A5", 2019, 2.0, GearType.ROBOTIC, 249, 2675000, R.drawable.audi_a5_preview, R.drawable.audi_a5));
        mCarsList.add(new CarModel("Audi A6", 2018, 2.0, GearType.ROBOTIC, 245, 3360000, R.drawable.audi_a6_preview, R.drawable.audi_a6));
        mCarsList.add(new CarModel("Audi RS 7", 2017, 4.0, GearType.AUTOMATIC, 605, 5649000, R.drawable.audi_rs_7_preview, R.drawable.audi_rs_7));
        mCarsList.add(new CarModel("Audi A8", 2019, 3.0, GearType.AUTOMATIC, 340, 7250000, R.drawable.audi_a8_preview, R.drawable.audi_a8));
        mCarsList.add(new CarModel("Mercedes-Benz C-Класс", 2018, 1.6, GearType.AUTOMATIC, 150, 2150000, R.drawable.mercedes_benz_c_class_preview, R.drawable.mercedes_benz_c_class));
        mCarsList.add(new CarModel("Mercedes-Benz CLA", 2016, 1.6, GearType.AUTOMATIC, 150, 1700000, R.drawable.mercedes_benz_cla_preview, R.drawable.mercedes_benz_cla));
        mCarsList.add(new CarModel("Mercedes-Benz CLS", 2018, 2.9, GearType.AUTOMATIC, 249, 4250000, R.drawable.mercedes_benz_cls_preview, R.drawable.mercedes_benz_cls));
        mCarsList.add(new CarModel("Mercedes-Benz E-Класс", 2019, 3.0, GearType.AUTOMATIC, 367, 4699486, R.drawable.mercedes_benz_e_class_preview, R.drawable.mercedes_benz_e_class));
        mCarsList.add(new CarModel("Mercedes-Benz G-Класс AMG", 2015, 5.5, GearType.AUTOMATIC, 544, 5200000, R.drawable.mercedes_benz_g_class_preview, R.drawable.mercedes_benz_g_class));


        // Находим элемент ListView - список, в котором будут отображаться машины на экране
        ListView catalogListView = findViewById(R.id.catalogListView);

        // Инициализируем Адаптер, который будет связывать данные со списком ListView на экране
        mCarAdapter = new CarAdapter(this, mCarsList);

        // Назначаем списку этот адаптер
        catalogListView.setAdapter(mCarAdapter);
    }

    /**
     * Добавляет на панель действий иконку "Назад" и заголовок
     */
    private void initializeActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Каталог");
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
