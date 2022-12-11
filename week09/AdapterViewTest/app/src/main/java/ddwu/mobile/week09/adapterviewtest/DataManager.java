package ddwu.mobile.week09.adapterviewtest;

import java.util.ArrayList;

public class DataManager {

    ArrayList<String> subjectList;

    public DataManager() {
        subjectList = new ArrayList<String>();
        subjectList.add("모바일소프트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍2");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    public void addDate(String subject) {
        subjectList.add(subject);
    }

    public void removeDate(int idx) {
        subjectList.remove(idx);
    }

    //set은 idx를 data로 바꿔준다.
    public void updateDate(int idx, String data) {
        subjectList.set(idx, data);
    }
}
