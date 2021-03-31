package by.epam.lapenok.model.entity;

public class User {
    private long userId;
    private String name;
    private String surname;
    private int age;

    public User() {
    }

    public User(int userId, String name, String surname, int age) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        User other = (User) object;

        if (userId != other.userId) {
            return false;
        }

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }

        if (surname == null) {
            if (other.surname != null) {
                return false;
            }
        } else if (!surname.equals(other.surname)) {
            return false;
        }

        if (age != other.age) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;

        result = PRIME * result + (int) (userId ^ (userId >>> 32));
        result = PRIME * result + ((name == null) ? 0 : name.hashCode());
        result = PRIME * result + ((surname == null) ? 0 : surname.hashCode());
        result = PRIME * result + age;

        System.out.println(result);

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nID: ").append(userId);
        builder.append(" name: ").append(name);
        builder.append(" surname: ").append(surname);
        builder.append(" age: ").append(age);

        return builder.toString();
    }
}
