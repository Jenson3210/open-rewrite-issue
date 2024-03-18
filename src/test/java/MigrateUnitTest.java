import org.junit.jupiter.api.Test;
import org.openrewrite.InMemoryExecutionContext;
import org.openrewrite.java.JavaParser;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

class MigrateUnitTest implements RewriteTest {

    @Test
    void migrate() {
        rewriteRun(
          spec -> spec
            .parser(JavaParser.fromJavaVersion()
                              .classpathFromResources(new InMemoryExecutionContext(), "demo-1.0"))
            .recipe(new MigrateRecipe()),
          //language=java
          java("""
               import packagenamea.StringMapper;
               
               class Test {
                   public String get(String s) {
                       return StringMapper.valueOf(s);
                   }
               }
               """, """
               class Test {
                   public String get(String s) {
                       return s;
                   }
               }
               """
          )
        );
    }
}
