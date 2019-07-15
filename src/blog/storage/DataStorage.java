package blog.storage;


import blog.model.Category;
import blog.model.Post;
import blog.model.User;

public class DataStorage {

    private User[] users;
    private Post[] posts;

    private int userSize;
    private int postSize;

    public DataStorage(int capacity) {
        users = new User[capacity];
        posts = new Post[capacity];
    }

    public DataStorage() {
        users = new User[16];
        posts = new Post[16];
    }

    public void add(User user) {
        if (users.length == userSize) {
            extendUser();
        }
        users[userSize++] = user;
    }

    private void extendUser() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }

    public void add(Post post) {
        if (posts.length == postSize) {
            extendPost();
        }
        posts[postSize++] = post;
    }

    private void extendPost() {
        Post[] tmp = new Post[posts.length + 10];
        System.arraycopy(posts, 0, tmp, 0, posts.length);
        posts = tmp;
    }

    public void printUsers() {
        for (int i = 0; i < userSize; i++) {
            System.out.println(users[i]);
        }
    }

    public void printPosts() {
        for (int i = 0; i < postSize; i++) {
            System.out.println(posts[i]);
        }
    }

    public void printPostsByCategory(Category category) {
        for (int i = 0; i < postSize; i++) {
            if (posts[i].getCategory() == category) {
                System.out.println(posts[i]);
            }
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        for (int i = 0; i < userSize; i++) {
            if (users[i].getEmail().equals(email) &&
                    users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    public boolean isUserExist(String email) {
        for (int i = 0; i < userSize; i++) {
            if (users[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void printPostsByUserEmail(String email) {
        for (int i = 0; i < postSize; i++) {
            if (posts[i].getAuthor().getEmail().equals(email)) {
                System.out.println(posts[i]);
            }
        }
    }

}
