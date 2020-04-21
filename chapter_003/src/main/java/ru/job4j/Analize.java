package ru.job4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        int changed = 0;
        int deleted = 0;

        Map<Integer, String> currentMap = current.stream().collect(Collectors.toMap(user -> user.id, user -> user.name));
        for (User previousUser : previous) {
            String name = currentMap.get(previousUser.id);
            if (name == null) {
                deleted++;
            } else if (!name.equals(previousUser.name)) {
                changed++;
            }
        }

        int added = current.size() - previous.size() + deleted;
        return new Info(added, changed, deleted);
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }

}
