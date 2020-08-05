package br.com.daysesoares.demonstrativoorcamentario.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.daysesoares.demonstrativoorcamentario.dominio.Lancamento;
import br.com.daysesoares.demonstrativoorcamentario.writer.LancamentoRodapeCallback;

@Configuration
public class DemonstrativoOrcamentoStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step demonstrativoOrcamentoStep(
			JdbcCursorItemReader<Lancamento> lancamentoReaderJdbc,
			ItemWriter<Lancamento> arquivoLancamentoWriter,
			LancamentoRodapeCallback rodapeCallback
			) {
		return stepBuilderFactory
				.get("demonstrativoOrcamentoStep")
				.<Lancamento, Lancamento>chunk(1)
				.reader(lancamentoReaderJdbc)
				.writer(arquivoLancamentoWriter)
				.listener(rodapeCallback)
				.build();
	}
}
