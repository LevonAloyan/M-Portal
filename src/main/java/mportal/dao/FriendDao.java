package mportal.dao;

import mportal.domain.Friend;

import java.util.List;

/**
 * Created by RuBen on 09.12.2016.
 */
public interface FriendDao {
    void createFriend(Friend friend);

    void deleteFriend(Friend friend);

    List<Friend> getFriendsList(int id);
}
