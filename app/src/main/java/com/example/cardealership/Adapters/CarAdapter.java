package com.example.cardealership.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cardealership.CarActivity;
import com.example.cardealership.DataModels.CarModel;
import com.example.cardealership.R;

import java.util.List;

/** Адаптер, соединяющий коллекцию автомобилей со списком на экране  */
public class CarAdapter extends ArrayAdapter<CarModel> {

    /** Контекст */
    private Context mContext;

    /** Коллекция объектов */
    private List<CarModel> mCarsList;

    /**
     * Инициализирует экземпляр класса
     * @param context Контекст
     * @param cars Список машин
     */
    public CarAdapter(@NonNull Context context, List<CarModel> cars) {
        super(context, 0, cars);
        mContext = context;
        mCarsList = cars;
    }

    /**
     * Получает макет пункта списка, и заполняет его данными
     * @param position Индекс в коллекции, на котором находится элемент
     * @param convertView Старый макет для повторного использования (по возможности)
     * @param parent Родительский компонент, с которым связан макет
     * @return Заполненный пункт списка
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Получаем автомобиль, находящийся на определённой позиции в списке
        final CarModel carModel = getItem(position);

        // Инициализируем rootView - макет пункта списка,
        // который будет отображаться на экране и содержать данные об этом автомобиле.
        View rootView = LayoutInflater.from(getContext()).
                inflate(R.layout.item_car, parent, false);

        // Получаем из макета первый элемент TextView
        // и устанавливаем ему текст - название Автомобиля
        TextView headingTextView = rootView.findViewById(R.id.text_view_heading);
        String name = carModel.getName();
        headingTextView.setText(name);

        // Получаем из макета второй элемент TextView
        // и устанавливаем ему текст
        TextView subheading1TextView = rootView.findViewById(R.id.text_view_subheading1);
        String year = String.valueOf(carModel.getYear());
        String volume = carModel.getVolume() + " ";
        String gearType = "";

        switch (carModel.getGearType()){
            case MANUAL:
                gearType = "MT ";
                break;
            case AUTOMATIC:
                gearType = "AT ";
                break;
            case ROBOTIC:
                gearType = "AMT ";
                break;
        }

        String power = carModel.getPower() + " л.с.";

        String subheading1 = volume + gearType + "(" + power + ") " + year;
        subheading1TextView.setText(subheading1);

        // Получаем из макета второй элемент TextView
        // и устанавливаем ему текст
        TextView subheading2TextView = rootView.findViewById(R.id.text_view_subheading2);
        String subheading2 = carModel.getPrice() + " р.";
        subheading2TextView.setText(subheading2);

        // Получаем из макета ImageView для отображения картинки
        ImageView imageView = rootView.findViewById(R.id.image_view);
        imageView.setImageDrawable(mContext.getDrawable(carModel.getPreviewId()));

        // Назначаем обработчик нажатия на пункт списка
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создаём интент
                Intent intent = new Intent(mContext, CarActivity.class);

                // Помещаем в интент автомобиль, по которому щёлкнул пользователь
                intent.putExtra("car", carModel);

                // Запускаем операцию
                mContext.startActivity(intent);
            }
        });

        return rootView;
    }

}
