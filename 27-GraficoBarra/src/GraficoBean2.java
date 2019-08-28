import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
@ViewScoped
public class GraficoBean2 implements Serializable {
	private LineChartModel lineModel;

	@PostConstruct
	public void init() {
		criarLineModel();
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	private void criarLineModel() {
		lineModel = new LineChartModel();
		lineModel.setLegendPosition("w");
		lineModel.setTitle("Financeiro");
		lineModel.getAxes().put(AxisType.X, new CategoryAxis("Meses"));
		LineChartSeries serie1 = new LineChartSeries();
		serie1.setLabel("Receitas");
		serie1.set("Janeiro", 200);
		serie1.set("Fevereiro", 500);
		serie1.set("Março", 100);
		serie1.set("Abril", 40);
		LineChartSeries serie2 = new LineChartSeries();
		serie2.setLabel("Custos");
		serie2.set("Janeiro", 100);
		serie2.set("Fevereiro", 150);
		serie2.set("Março", 300);
		serie2.set("Abril", 100);
		lineModel.addSeries(serie1);
		lineModel.addSeries(serie2);
	}
}