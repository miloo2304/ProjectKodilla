package com.kodilla.stream.Project_7_4;

import java.util.stream.Collectors;
import java.util.*;

    public final class ForumUser {
        private final String username;
        private final String realName;
        private final String location;
        private final Set<ForumUser> friends = new HashSet<>();

        public ForumUser(final String username, final String realName, final String location) {
            this.username = username;
            this.realName = realName;
            this.location = location;
        }

        public void addFriend(ForumUser user) {
            friends.add(user);
        }

        public boolean removeFriend(ForumUser user) {
            return friends.remove(user);
        }

        public String getUsername() {
            return username;
        }

        public String getRealName() {
            return realName;
        }

        public String getLocation() {
            return location;
        }

        public Set<ForumUser> getFriends() {
            return friends;
        }

        @Override
        public String toString() {
            // A more readable toString method for debugging
            return String.format("ForumUser{username='%s', realName='%s', location='%s'}", username, realName, location);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ForumUser)) return false;
            ForumUser forumUser = (ForumUser) o;
            return username.equals(forumUser.username);
        }

        @Override
        public int hashCode() {
            return Objects.hash(username); // Only hash based on 'username'
        }

        // Returns a set of unique locations from user's friends
        public Set<String> getLocationsOfFriendsOfFriends() {
            return friends.stream()                               // [1]
                    .flatMap(user -> user.getFriends().stream())       // [2]
                    .filter(user -> user != this)                      // [3]
                    .map(ForumUser::getLocation)                       // [4]
                    .collect(Collectors.toSet());                      // [5]
        }

        // Additional method: To return the number of friends
        public int getFriendCount() {
            return friends.size();
        }
    }