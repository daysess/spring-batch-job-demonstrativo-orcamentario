package br.com.daysesoares.demonstrativoorcamentario.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

import br.com.daysesoares.demonstrativoorcamentario.dominio.Lancamento;

@Component
public class LancamentoRodapeCallback implements FlatFileFooterCallback {

	private Double valorTotal = 0.0;
	
	@Override
	public void writeFooter(Writer writer) throws IOException {
		writer.append("----------------------------------\n");
		writer.append("TOTAL: "+valorTotal );
		writer.append("\n----------------------------------\n");
		
	}
	
	@BeforeWrite
	public void beforeWrite(List<Lancamento> lancamentos) {
		for(Lancamento lanc : lancamentos) {
			valorTotal += lanc.getValorLancamento();
		}
	}

}
