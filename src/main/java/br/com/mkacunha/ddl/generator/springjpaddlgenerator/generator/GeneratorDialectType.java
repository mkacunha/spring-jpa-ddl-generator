package br.com.mkacunha.ddl.generator.springjpaddlgenerator.generator;

public enum GeneratorDialectType {

    POSTGRES("org.hibernate.dialect.PostgreSQLDialect", "postgres-ddl.sql"),
    ORACLE("org.hibernate.dialect.Oracle12cDialect", "oracle-ddl.sql"),
    MYSQL("org.hibernate.dialect.MySQLDialect", "mysql-ddl.sql"),
    SQLSERVER("org.hibernate.dialect.SQLServerDialect", "sqlserver-ddl.sql");

    private String dialect;

    private String outputFileName;

    GeneratorDialectType(String dialect, String outputFileName) {
        this.dialect = dialect;
        this.outputFileName = outputFileName;
    }

    public String getDialect() {
        return dialect;
    }

    public String getOutputFileName() {
        return outputFileName;
    }
}
