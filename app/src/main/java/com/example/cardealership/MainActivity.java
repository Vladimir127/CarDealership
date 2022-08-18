package com.example.cardealership;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cardealership.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeButtons();
    }

    /* Инициализирует кнопки и назначает им обработчики нажатия */
    private void initializeButtons() {

        // Инициализируем кнопку "Каталог" и назначаем ей обработчик нажатия
        Button catalogButton = findViewById(R.id.button_catalog);
        catalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создаём интент
                Intent intent = new Intent(getApplicationContext(), CatalogActivity.class);

                // Запускаем операцию
                startActivity(intent);
            }
        });

        // Инициализируем кнопку "Тест-драйв" и назначаем ей обработчик нажатия
        Button testDriveButton = findViewById(R.id.button_test_drive);
        testDriveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Инициализируем кнопку "Акции" и назначаем ей обработчик нажатия
        Button promotionsButton = findViewById(R.id.button_promotions);
        promotionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PromotionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
