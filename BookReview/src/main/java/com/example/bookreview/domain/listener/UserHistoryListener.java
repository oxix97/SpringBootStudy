package com.example.bookreview.domain.listener;

import com.example.bookreview.domain.entity.UserInfo;
import com.example.bookreview.domain.entity.UserHistory;
import com.example.bookreview.domain.repository.UserHistoryRepository;
import com.example.bookreview.util.BeanUtils;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;

public class UserHistoryListener {
    @PostPersist
    @PostUpdate
    public void postPersistAndPostUpdate(Object obj) {
        UserHistoryRepository repository = BeanUtils.getBean(UserHistoryRepository.class);
        UserInfo userInfo = (UserInfo) obj;
        UserHistory history = new UserHistory();
        history.setUserId(userInfo.getId());
        history.setName(userInfo.getName());
        history.setUserInfo(userInfo);
        repository.save(history);
    }
}
