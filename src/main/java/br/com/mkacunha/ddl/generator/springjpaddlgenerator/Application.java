package br.com.mkacunha.ddl.generator.springjpaddlgenerator;

import br.com.mkacunha.ddl.generator.springjpaddlgenerator.generator.Generator;
import br.com.mkacunha.ddl.generator.springjpaddlgenerator.generator.GeneratorDialectType;

public class Application {

    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.generate(GeneratorDialectType.MYSQL, Application.class.getPackage().getName());
        generator.generate(GeneratorDialectType.ORACLE, Application.class.getPackage().getName());
        generator.generate(GeneratorDialectType.POSTGRES, Application.class.getPackage().getName());
        generator.generate(GeneratorDialectType.SQLSERVER, Application.class.getPackage().getName());
    }
}
