import java.io.Serializable;

class User implements Serializable {

    private static final long serialVersionUID = -9038244730107727954L;
    String name;
    transient String password;
}