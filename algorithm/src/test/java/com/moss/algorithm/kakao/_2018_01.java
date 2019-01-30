package com.moss.algorithm.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class _2018_01 {

    @Test
    public void test() {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        List<History> historyList = new ArrayList<History>();
        Map<String, String> nickNameMap = new HashMap<String, String>();
        for (String item : record) {
            String[] items = item.split(" ");
            History history = new History();
            String action = items[0];
            history.setAction(action);
            history.setUid(items[1]);
            if (items.length > 2) {
                history.setNickName(items[2]);
            }
            
            if ("Enter".equals(action) || "Change".equals(action)) {
                nickNameMap.put(history.getUid(), history.getNickName());
            }
            if ("Enter".equals(action) || "Leave".equals(action)) {
                historyList.add(history);
            }
        }
        
        List<String> answer = new ArrayList<String>();
        for (History history : historyList) {
          if ("Enter".equals(history.getAction())) {  
              answer.add(nickNameMap.get(history.getUid()) + "님이 들어왔습니다.");
          } else {
              answer.add(nickNameMap.get(history.getUid()) + "님이 나갔습니다.");
          }
        }
        System.out.println(answer);
        //return answer.toArray(new String[answer.size()]);
    }
    
    public static class History {
        String action;
        String uid;
        String nickName;
        public String getAction() {
            return action;
        }
        public void setAction(String action) {
            this.action = action;
        }
        public String getUid() {
            return uid;
        }
        public void setUid(String uid) {
            this.uid = uid;
        }
        public String getNickName() {
            return nickName;
        }
        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }
}
