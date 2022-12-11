package ddwu.mobile.week11.dialogtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int selectedItem = 0;
    boolean[] selectedItems = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        //커스텀 대화상자에서 xml을 인플레이션해서 객체로 만들기 위한 코드
        final ConstraintLayout orderLayout =
                (ConstraintLayout)View.inflate(this,R.layout.order_layout, null);

        switch (v.getId()) {
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("대화상자 제목")
                        
                        //1. 메시지만 표시하는 방법
                //.setMessage("대화상자 메시지")

                        //2. 목록만 표시하는 방법
//                .setItems(R.array.foods, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String[] foods = getResources().getStringArray(R.array.foods);
//                        Toast.makeText(MainActivity.this, foods[i], Toast.LENGTH_SHORT).show();
//                    }
//                }) // xml에서 만든 문자 배열 가져온다.
                        
                        //3. 라디오 버튼 목록을 표시하는 방법
//                .setSingleChoiceItems(R.array.foods, selectedItem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        selectedItem = i;
//                    }
//                })

                        //4.체크박스 목록을 표시하는 방법
//                .setMultiChoiceItems(R.array.foods, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                        selectedItems[i] = b;
//                    }
//                })

                        //5. 내가 만든 레이아웃 목록 표시하는 방법
                .setView(orderLayout)
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false) // 대화상자 확인 눌렀을 때만 dialog 닫힌다.back만 누른다고 닫히지 x.
                .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //1) 라디오 버튼
//                        String[] foods = getResources().getStringArray(R.array.foods);
//                        String food = foods[selectedItem];
//                        Toast.makeText(MainActivity.this, food, Toast.LENGTH_SHORT).show();

                        //2) 체크박스
//                        String[] foods = getResources().getStringArray(R.array.foods);
//                        String rslt = "";
//                        for (int idx=0; idx<foods.length; idx++) {
//                            if (selectedItems[idx]) { //true인 값만 rslt에 넣어준다.
//                                rslt += foods[idx] + " ";
//                            }
//                        }
//                        Toast.makeText(MainActivity.this,rslt,Toast.LENGTH_SHORT).show();
                        
                        //3) 커스텀
                        EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                        String product = etProduct.getText().toString();

                        Toast.makeText(MainActivity.this,product,Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("대기버튼",null)
                .setNegativeButton("취소버튼", null)
                .show();

//                Dialog dlg = builder.create();
//                dlg.setCancleOnTouchOutside(false); // 외부 누르면 안 닫히고, back 버튼이나 확인 버튼 누르면 닫힌다.
//                dlg.show();
//                builder.show(); // 위의 2줄
                break;
        }
    }
}