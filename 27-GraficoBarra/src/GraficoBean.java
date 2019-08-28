import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@ViewScoped
public class GraficoBean implements Serializable {
	private BarChartModel barModel;

	@PostConstruct
	public void init() {
		criarBarModel();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private void criarBarModel() {
		barModel = new BarChartModel();
		barModel.setTitle("Clientes registrados");
		ChartSeries clientes = new ChartSeries();
		clientes.set("Janeiro", 100);
		clientes.set("Fevereiro", 200);
		clientes.set("Março", 50);
		barModel.addSeries(clientes);
		ChartSeries vendas = new ChartSeries();
		vendas.set("Janeiro", 10);
		vendas.set("Fevereiro", 20);
		vendas.set("Março", 5);
		barModel.addSeries(vendas);
		barModel.setShowPointLabels(true);
	}
}