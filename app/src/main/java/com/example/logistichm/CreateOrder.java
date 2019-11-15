package com.example.logistichm;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CreateOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    public void showCommentWindow() {
//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        dialog.setTitle("Комментарий");
//        //dialog.setMessage("Введите данные для входа");
//
//        LayoutInflater inflater = LayoutInflater.from(this); //Объект для получения необходимого шаблона
//        View comment_window = inflater.inflate(R.layout.comment_to_order, null); //Получение шаблона comment_window.xml
//        dialog.setView(comment_window);
//
//        final EditText comment = comment_window.findViewById(R.id.comment);
//
//        //Кнопка на всплывающем окне
//        dialog.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss(); //Скрыть окно
//            }
//        });
//        dialog.setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                String text = comment.getText().toString();
//                if (TextUtils.isEmpty(text)) {
//                    return;
//                }
//            }
//        });
//
//        dialog.show();
//    }
}
