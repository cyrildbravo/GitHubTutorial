import java.util.*;
import javax.swing.*;
import java.awt.*;

public class KNNUI{
	private static JFrame mainFrame = new JFrame("KNN");
	private static JPanel mainPanel = new JPanel(new BorderLayout());
	private static JPanel canvasPanel = new JPanel(new BorderLayout());
	private static JPanel buttonPanel = new JPanel();
	private static KNNLogic logic;
	private static CustomCanvas canvas;
	private static JTextField xBox = new JTextField();
	private static JTextField yBox = new JTextField();

	public KNNUI(KNNLogic logic)
	{
		this.logic = logic;
		canvas = new CustomCanvas(logic);
		initMainFrame();
		initComponents();
	}

	//initialize values for the frame and add to the main panel
	private void initMainFrame()
	{
		mainFrame.setMinimumSize(new Dimension(700,500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.add(mainPanel);
	}
	
	private void initComponents()
	{
		canvas.setBackground(Color.BLACK);
		canvasPanel.add(canvas);
		//canvasPanel.setBackground(Color.BLACK);
		canvasPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		mainPanel.add(canvasPanel,BorderLayout.CENTER);
		canvasPanel.revalidate();
		canvasPanel.repaint();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
		//use an empty border to add some padding to the panel
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		JLabel xBoxLabel = new JLabel("X : ");
		buttonPanel.add(xBoxLabel);
		
		xBox.setMaximumSize(new Dimension(175,30));
		//xBox.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		buttonPanel.add(xBox);
		
		JLabel yBoxLabel = new JLabel("Y : ");
		buttonPanel.add(yBoxLabel);
		
		yBox.setMaximumSize(new Dimension(175,30));
		buttonPanel.add(yBox);
		
		ClassifyButton classifyButton = new ClassifyButton(logic,canvas);
		buttonPanel.add(classifyButton);
		
		buttonPanel.revalidate();
		buttonPanel.repaint();
		mainPanel.add(buttonPanel,BorderLayout.EAST);
	}
	
	public static void main(String[] args)
	{
		KNNLogic knn_logic = new KNNLogic();
		KNNUI ui = new KNNUI(knn_logic);
	}

	public static JTextField getXBox()
	{
		return xBox;
	}

	public static JTextField getYBox()
	{
		return yBox;
	}
}

