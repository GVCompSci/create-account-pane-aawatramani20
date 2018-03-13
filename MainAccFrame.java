import javax.swing.JFrame;

public class MainAccFrame extends JFrame {
	
	public MainAccFrame()
	{
		add(new AccountFrame());
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new MainAccFrame();

	}

}
