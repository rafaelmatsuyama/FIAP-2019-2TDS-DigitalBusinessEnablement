import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.ws.axis2.EstoqueBOStub;
import org.apache.ws.axis2.EstoqueBOStub.ConsultarProduto;
import org.apache.ws.axis2.EstoqueBOStub.ConsultarProdutoResponse;
import org.apache.ws.axis2.EstoqueBOStub.ProdutoTO;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TelaConsulta {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaConsulta window = new TelaConsulta();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(270, 303);
		shell.setText("Loja FIAP Run");

		Label lblDigiteOCdigo = new Label(shell, SWT.NONE);
		lblDigiteOCdigo.setBounds(50, 39, 159, 15);
		lblDigiteOCdigo.setText("Digite o c\u00F3digo do produto:");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(86, 70, 76, 21);

		Label label = new Label(shell, SWT.NONE);
		label.setBounds(49, 132, 160, 15);

		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					EstoqueBOStub stub = new EstoqueBOStub();
					ConsultarProduto consulta = new ConsultarProduto();
					int codigo = Integer.parseInt(text.getText());
					consulta.setCodigo(codigo);
					ConsultarProdutoResponse response = stub.consultarProduto(consulta);
					ProdutoTO produto = response.get_return();
					label.setText(produto.getDescricao());
				} catch (AxisFault e1) {
					label.setText("Produto não encontrado!");
				} catch (RemoteException e1) {
					label.setText("Sistema fora do ar!");
				}
			}
		});
		btnOk.setBounds(86, 188, 75, 25);
		btnOk.setText("OK");

	}

}
