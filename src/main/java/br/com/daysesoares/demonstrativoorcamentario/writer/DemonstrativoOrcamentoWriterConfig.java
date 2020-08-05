package br.com.daysesoares.demonstrativoorcamentario.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.daysesoares.demonstrativoorcamentario.dominio.Lancamento;

@Configuration
public class DemonstrativoOrcamentoWriterConfig {
//	@Bean
//	public ItemWriter<Lancamento> impressaoContaWriter() {
//		
//		return lancamentos -> lancamentos.forEach(
//				item -> System.out.println(item)
//				);
//	}
	
	@StepScope
	@Bean
	public FlatFileItemWriter<Lancamento> arquivoContaWriter(
			@Value("#{jobParameters['lancamentos']}") Resource lancamentoResource,
			LancamentoRodapeCallback rodapeCallback){
		return new FlatFileItemWriterBuilder<Lancamento>()
				.name("arquivoContaWriter")
				.resource(lancamentoResource)
				.lineAggregator(lineAggregator())
				.headerCallback(cabecalhoCallback())
				.footerCallback(rodapeCallback)
				.build();
		
	}

	private FlatFileHeaderCallback cabecalhoCallback() {
		return new FlatFileHeaderCallback() {
			
			@Override
			public void writeHeader(Writer writer) throws IOException {
				writer.append("-------------------------------------\n");
				writer.append(String.format("LANCAMENTOS\n"));
				writer.append("-------------------------------------");
				
			}
		};
	}

	private LineAggregator<Lancamento> lineAggregator() {
		return new LineAggregator<Lancamento>() {
			@Override
			public String aggregate(Lancamento lancamento) {
				String formatLancamento = String.format("[Código: %s] - [Descrição: %s]", lancamento.getCodigoNaturezaDespesa(), lancamento.getDescricaoNaturezaDespesa());
				return formatLancamento;
			}
		};
	}
}
