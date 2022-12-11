package ddwu.mobile.week09.lab02;

import java.util.ArrayList;

public class SubjectManager {
    private ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList();
        subjectList.add("FEEL ME");
        subjectList.add("DEJA VU");
        subjectList.add("DRIVERS LICENSE");
        subjectList.add("GOOD 4 U");
        subjectList.add("LOSE YOU TO LOVE ME");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    //    추가
    public void addData(String newSubject) {
        subjectList.add(newSubject);
    }

    //    삭제
    public void removeData(int idx) {
        subjectList.remove(idx);
    }

    //    수정
    public void modifyData(int idx, String newSubject) {
        subjectList.set(idx, newSubject); //set함수 사용
    }
}
