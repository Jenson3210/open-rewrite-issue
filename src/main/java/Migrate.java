import com.google.errorprone.refaster.Refaster;
import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;
import org.openrewrite.java.template.RecipeDescriptor;

@RecipeDescriptor(name = "Migrate Code", description = "This recipe will remove unnecessary StringMappers across multiple library versions.")
public class Migrate {

    @BeforeTemplate
    public String before1(String key) {
        return packagenamea.StringMapper.valueOf(key);
    }

    @BeforeTemplate
    public String before2(String key) {
        return packagenameb.StringMapper.valueOf(key);
    }

    @AfterTemplate
    public String self(String key) {
        return key;
    }
}
