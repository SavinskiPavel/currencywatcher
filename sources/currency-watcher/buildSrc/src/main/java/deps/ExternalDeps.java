package deps;

public class ExternalDeps {

    public static String postgresql = "org.postgresql:postgresql:" + Versions.postgres;
    public static String sl4jApi = "org.slf4j:slf4j-api:" + Versions.slf4j;
    public static String findBugs = "com.google.code.findbugs:jsr305:" + Versions.findBugs;

    public static class Spring {

        public static String bom =
                "org.springframework.boot:spring-boot-dependencies:" + Versions.springBom;

        public static class Bom {
            public static String springBoot = "org.springframework.boot:spring-boot";
            public static String starterWeb = "org.springframework.boot:spring-boot-starter-web";
            public static String starterDataJpa = "org.springframework.boot:spring-boot-starter-data-jpa";
            public static String flywayCore = "org.flywaydb:flyway-core";
        }
    }

    public static class Versions {

        static String springBom = "2.7.1";
        static String slf4j = "1.7.36";
        static String postgres = "42.4.0";
        static String findBugs = "3.0.2";
    }
}
