package ddwu.mobile.week10.customadaptertest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//상속받아서 추상클래스다. 메소드를 정의해줘야 한다.
public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    //생성자 추가
    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //메소드 재정의
    @Override
    public int getCount() {
        //화면 몇 개 만들지 물어볼 때 호출하는 메소드
        //원본 데이터 사용하면 된다. 그것의 개수 반환하는 코드 구현
        return myDataList.size();
    }

    @Override
    public Object getItem(int i) {
        //원본 데이터에서 특정 항목을 꺼낸다.
        //int i는 몇 번째 인지 position이다.
        //반환 타입이 최상위 객체다. 어떤 객체든 반환 가능하다.
        return myDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        //그 항목의 id값. 식별자를 반환하는 메소드
        //식별자를 long 타입으로 해놨다. 우리는 타입 변환할 필요 없다.
        return myDataList.get(i).get_id();
    }

    //화면 만들고 채워주고 반환한다.
    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        //젤 중요한 화면을 만드는 메소드
        //내가 갖고 있는 원본 데이터와 레이아웃을 결합해서 반환한다.
        //몇 번째 만드는 것인지 순서가 i에 들어간다. 맨 처음엔 당연히 i값에 0. 그럼 원본 데이터 0번째 꺼내면 된다. ->pos
        //강의자료와 이름 같게 설정한다.

        //리스트뷰의 position 위치를 저장 -> onClick 내부에서 사용하기 위해 상수 선언
        //매개변수로 들어오는 pos는 지역변수로 받기 때문에 리스너에서 사용하기 위해 멤버 변수나 상수로 만들어 보관한다.
        final int position = pos;

        //getView가 실행될 때 보관 객체 만들어 논다.
        ViewHolder viewHolder;

        //convertView는 끼워 넣어지는 view
        //처음에는 빈 화면. 빈 화면을 전달 받았다면, 실제 자바 객체로 화면 하나를 만든다.
        //화면에 레이아웃 정의해 놓은 것으로 자바 객체가 만들어지고, 그 객체가 빈 화면에 들어간다.
        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);
            //Log.d(TAG, "Created!");
            viewHolder = new ViewHolder();
            viewHolder.textNo = convertView.findViewById(R.id.tvNo);
            viewHolder.textName = convertView.findViewById(R.id.tvName);
            viewHolder.textPhone = convertView.findViewById(R.id.tvPhone);
            viewHolder.btnCheck = convertView.findViewById(R.id.btnCheck); //static 객체라서 없어지지 않고 계속 유지된다.
            convertView.setTag(viewHolder); //convertView의 화면 요소들이니까 여기에 이 객체를 보관한다.
            //convertView가 빈 화면으로 들어오면 화면 요소 다 만들어서 보관해놓는다.
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            //한 번이라도 만들었다면, 이미 보관해 놨던 객체 가져와서 쓴다.
        }

        //convertView. 이 화면 안에 있는 이름, 번호 등을 찾는 것이다.
        //지금 기본 화면은 activity_main이다. 그냥 find하면 기본 레이아웃 항목을 찾는다.
        //그래서 이 view 안에서 찾는 것이다.
        /*TextView tvNo = convertView.findViewById(R.id.tvNo);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvPhone = convertView.findViewById(R.id.tvPhone);
        Button btnCheck = convertView.findViewById(R.id.btnCheck);*/

        viewHolder.btnCheck.setFocusable(false); //button만 터치 및 클릭을 처리하지 않도록

        //listview를 클릭 구현하면 마우스가 클릭하는 것을 다 받아들인다.
        //true가 default인데 이때는 눌렀더니 동작하지 않는다. 무조건 클릭을 버튼이라고 받아들인다.
        //focus가 버튼에만 있으면 안 된다. 마우스가 클릭하는 위치로 갔을 때도 focus가 가도록하는 코드.

        //id 타입은 setText에 바로 숫자로 넣으면 안된다. 그럼 R 파일에 id 값으로 인식하기 때문에 오류난다.
        //그래서 숫자 쓸 때는 String으로 바꿔서 찍어준다.
        viewHolder.textNo.setText(String.valueOf(myDataList.get(position).get_id())); //id를 문자열로 반환
        viewHolder.textName.setText(myDataList.get(position).getName());
        viewHolder.textPhone.setText(myDataList.get(position).getPhone());
        viewHolder.btnCheck.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(position).getPhone() + "선택", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    //static 클래스 선언
    static class ViewHolder {
        //보관할 화면 요소들
        TextView textNo;
        TextView textName;
        TextView textPhone;
        Button btnCheck;
    }
}
