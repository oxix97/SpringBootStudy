package org.example.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean("helloJob")
    public Job helloJob(Step step) {
        return jobBuilderFactory.get("helloJob")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @JobScope
    @Bean("helloStep")
    public Step helloStep(Tasklet tasklet) {
        return stepBuilderFactory.get("helloStep")
                .tasklet(tasklet)
                .build();
    }

    @StepScope
    @Bean
    public Tasklet tasklet() {
        return (contribution, chunkContext) -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Tasklet" + i);
            }
            return RepeatStatus.FINISHED;
        };
    }
}
