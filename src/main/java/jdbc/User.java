package jdbc;
import jdbc.InputUtil.InputField;
public class User {
    @InputField(title = "用户名",notNull = true,mode = {"注册","登录"})
    private String username;
    @InputField(title = "密码",notNull = true,mode = {"注册","登录"})
    private String password;
    @InputField(title = "昵称",notNull = true,mode = "注册")
    private String nickname;
    @InputField(title = "年龄",regex = "[0-9]{1,2}",regexNotMathTitle = "年龄为1-2位整数",mode = "注册")
    private int age;

    public User() {
    }
    public User(String username, String password, String nickname, int age) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }
}
