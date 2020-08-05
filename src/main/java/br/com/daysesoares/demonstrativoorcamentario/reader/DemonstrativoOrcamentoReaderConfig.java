package br.com.daysesoares.demonstrativoorcamentario.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.daysesoares.demonstrativoorcamentario.dominio.Lancamento;

@Configuration
public class DemonstrativoOrcamentoReaderConfig {

	@Bean
	public JdbcCursorItemReader<Lancamento> lancamentoReaderJdbc(
			@Qualifier("appDataSource") DataSource dataSource){
		return new JdbcCursorItemReaderBuilder<Lancamento>()
				.name("lancamentoReaderJdbc")
				.dataSource(dataSource)
				.sql("select * from lancamento order by 2")
				.rowMapper(new BeanPropertyRowMapper<Lancamento>(Lancamento.class))
				.build();
	}
	
}
