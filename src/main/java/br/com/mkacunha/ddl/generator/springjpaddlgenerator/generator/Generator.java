package br.com.mkacunha.ddl.generator.springjpaddlgenerator.generator;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import javax.persistence.Entity;
import java.util.EnumSet;
import java.util.Set;

public class Generator {

    public void generate(GeneratorDialectType dialect, String basePackage) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
                .applySetting("hibernate.dialect", dialect.getDialect())
                .build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        getEntities(basePackage).stream().forEach(beanDefinition -> metadataSources.addAnnotatedClassName(beanDefinition.getBeanClassName()));
        Metadata metadata = metadataSources.buildMetadata();
        new SchemaExport()
                .setOutputFile(dialect.getOutputFileName())
                .setFormat(true)
                .setDelimiter(";")
                .create(EnumSet.of(TargetType.SCRIPT), metadata);
        metadata.buildSessionFactory().close();
    }

    private Set<BeanDefinition> getEntities(String basePackage){
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        return scanner.findCandidateComponents(basePackage);
    }

}
