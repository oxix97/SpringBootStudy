package com.example.recentbatch.core.job;

import com.example.recentbatch.core.JobCompletionNotificationListener;
import com.example.recentbatch.core.PlainTextItemProcessor;
import com.example.recentbatch.core.domain.PlainText;
import com.example.recentbatch.core.domain.PlainTextRepository;
import com.example.recentbatch.core.service.PlainTextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class PlainTextJobConfig {
    private final PlainTextRepository plainTextRepository;

    //    private final PlainTextService plainTextService;
    @Bean
    public Job job1(
            JobRepository jobRepository,
            Step step1,
            JobCompletionNotificationListener listener
    ) {
        return new JobBuilder("job1", jobRepository)
                .listener(listener)
                .start(step1)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step step1(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            RepositoryItemReader<PlainText> reader,
            PlainTextItemProcessor processor,
            ItemWriter<PlainText> writer
    ) {
        return new StepBuilder("step1", jobRepository)
                .<PlainText, PlainText>chunk(3, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public RepositoryItemReader<PlainText> itemReader() {
        log.info("itemReader");
        return new RepositoryItemReaderBuilder<PlainText>()
                .name("itemReader")
                .repository(plainTextRepository)
                .methodName("findAll")
                .arguments(List.of())
                .pageSize(3)
                .sorts(Map.of("id", Sort.Direction.ASC))
                .build();
    }

    @Bean
    public PlainTextItemProcessor processor() {
        log.info("processor");
        return new PlainTextItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<PlainText> writer(DataSource dataSource) {
        log.info("=======================================================");
        return new JdbcBatchItemWriterBuilder<PlainText>()
                .sql("INSERT INTO plain_text (text) VALUES (:text)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }
}
