package com.example.cardealership.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cardealership.DataModels.PromotionModel;
import com.example.cardealership.R;

import java.util.List;

public class PromotionAdapter extends ArrayAdapter<PromotionModel> {
    /** Контекст */
    private Context mContext;

    /** Коллекция объектов */
    private List<PromotionModel> mPromotionsList;

    /**
     * Инициализирует экземпляр класса
     * @param context Контекст
     * @param promotions Список акций
     */
    public PromotionAdapter(@NonNull Context context, List<PromotionModel> promotions) {
        super(context, 0, promotions);
        mContext = context;
        mPromotionsList = promotions;
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
        // Получаем акцию, находящуюся на определённой позиции в списке
        final PromotionModel promotionModel = getItem(position);

        // Инициализируем rootView - макет пункта списка,
        // который будет отображаться на экране и содержать данные об этом автомобиле.
        View rootView = LayoutInflater.from(getContext()).
                inflate(R.layout.item_promotion, parent, false);

        // Получаем из макета ImageView для отображения картинки
        ImageView imageView = rootView.findViewById(R.id.image_view_promotion);
        imageView.setImageDrawable(mContext.getDrawable(promotionModel.getImageId()));

        return rootView;
    }
}
