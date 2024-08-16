package resours;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Credential {
    public static final String EMAIL = "Barsik" + new Random().nextInt(999) + "-data@yandex.ru";
    public static final String PASSWORD = "12345" + new Random().nextInt(999);
    public static final String NAME = "Barsik" + new Random().nextInt(999);
    public static final String RANDOM = String.valueOf(new Random().nextInt(999));
}
