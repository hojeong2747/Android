package ddwu.mobile.week10.lab02;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    DataManager dataManager = new DataManager();
    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return myDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return myDataList.get(i).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;
        ViewHolder viewHolder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.textNo = convertView.findViewById(R.id.tvNo);
            viewHolder.textName = convertView.findViewById(R.id.tvName);
            viewHolder.textPhone = convertView.findViewById(R.id.tvPhone);
            viewHolder.btnCheck = convertView.findViewById(R.id.btnCheck);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.btnCheck.setFocusable(false);

        viewHolder.textNo.setText(String.valueOf(myDataList.get(position).get_id())); //id를 문자열로 반환
        viewHolder.textName.setText(myDataList.get(position).getName());
        viewHolder.textPhone.setText(myDataList.get(position).getPhone());

        // 추가
        // onClick? onTouch?
        viewHolder.textNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, String.valueOf(myDataList.get(position).get_id()), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.textName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.textPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(position).getPhone(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(position).getPhone() + "선택", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView textNo;
        TextView textName;
        TextView textPhone;
        Button btnCheck;
    }
}
