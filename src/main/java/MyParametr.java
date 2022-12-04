public class MyParametr {
    String name;
    String secondName;
    String surname;
    String data1;
    String data2;
    String profession;

    public MyParametr(String name, String secondName, String surname, String data1, String data2, String profession) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.data1 = data1;
        this.data2 = data2;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "MyParametr{" +
                 ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", data1='" + data1 + '\'' +
                ", data2='" + data2 + '\'' +
                ", profession ='" + profession + '\'' +
                '}';
    }

}
