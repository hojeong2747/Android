package ddwu.mobile.week10.lab02;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<MyData> myDataList;

    public DataManager() {
        myDataList = new ArrayList<MyData>();
        myDataList.add(new MyData(1, "홍길동","012345"));
        myDataList.add(new MyData(2, "전우치","123456"));
        myDataList.add(new MyData(3, "일지매","234567"));
        myDataList.add(new MyData(1, "홍길동","012345"));
        myDataList.add(new MyData(2, "전우치","123456"));
        myDataList.add(new MyData(3, "일지매","234567"));
        myDataList.add(new MyData(1, "홍길동","012345"));
        myDataList.add(new MyData(2, "전우치","123456"));
        myDataList.add(new MyData(3, "일지매","234567"));
        myDataList.add(new MyData(1, "홍길동","012345"));
        myDataList.add(new MyData(2, "전우치","123456"));
        myDataList.add(new MyData(3, "일지매","234567"));
        myDataList.add(new MyData(1, "홍길동","012345"));
        myDataList.add(new MyData(2, "전우치","123456"));
        myDataList.add(new MyData(3, "일지매","234567"));
        myDataList.add(new MyData(1, "홍길동","012345"));
        myDataList.add(new MyData(2, "전우치","123456"));
        myDataList.add(new MyData(3, "일지매","234567"));
        myDataList.add(new MyData(1, "홍길동","012345"));
        myDataList.add(new MyData(2, "전우치","123456"));
        myDataList.add(new MyData(3, "일지매","234567"));
    }

    public ArrayList<MyData> getMyDataList() {
        return myDataList;
    }

    // 삭제
    public void removeData(MyData data) {
        myDataList.remove(data);
    }

    public void removeData2(int i){
        myDataList.remove(i);
    }
}
