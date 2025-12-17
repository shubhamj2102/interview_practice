package practice.lld.payment_gateway.user;

public class UserDao {
    private String  userId;
    private String username;
    private String contactNo;

    public UserDao(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public UserDao(String userId, String username, String contactNo) {
        this.userId = userId;
        this.username = username;
        this.contactNo = contactNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
