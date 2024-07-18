package next.cesar.school.Spring_funcionarios.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import lombok.AllArgsConstructor;
import next.cesar.school.Spring_funcionarios.FuncionarioProcessParam;
import next.cesar.school.Spring_funcionarios.entity.Funcionario;
import next.cesar.school.Spring_funcionarios.repo.FuncionarioRepository;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Bean
	public FlatFileItemReader<Funcionario> funcionarioReader() {
		FlatFileItemReader<Funcionario> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource(FuncionarioProcessParam.arquivoCsv));
		itemReader.setName("csv-reader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}

	private LineMapper<Funcionario> lineMapper() {

		DefaultLineMapper<Funcionario> lineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "salario", "ano", "funcao");

		BeanWrapperFieldSetMapper<Funcionario> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Funcionario.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}

	@Bean
	public FuncionarioProcessor funcionarioProcessor() {
		return new FuncionarioProcessor();
	}

	@Bean
	public RepositoryItemWriter<Funcionario> funcionarioWriter() {

		RepositoryItemWriter<Funcionario> writer = new RepositoryItemWriter<>();
		writer.setRepository(funcionarioRepository);
		writer.setMethodName("save");

		return writer;
	}
	
	
	@Bean
	public Step step() {
		return stepBuilderFactory.get("step-1").<Funcionario, Funcionario>chunk(10)
						  .reader(funcionarioReader())
						  .processor(funcionarioProcessor())
						  .writer(funcionarioWriter())
						  .taskExecutor(taskExecutor())
						  .build();
	}
	
	@Bean
	public Job job() {
		return jobBuilderFactory.get("funcionario-import")
								.flow(step())
								.end()
								.build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(10);
		return taskExecutor;
	}
	
	
	
}







