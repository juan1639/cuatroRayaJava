/*
 * package com.ejemplo.juan1639.main;
 * 
 * import java.awt.Color; import java.awt.Dimension; import java.awt.Font;
 * import java.awt.FontMetrics; import java.awt.Image; import
 * java.awt.event.ActionEvent; import java.awt.event.ActionListener; import
 * java.awt.event.MouseEvent; import java.awt.event.MouseListener;
 * 
 * import javax.swing.BorderFactory; import javax.swing.ButtonGroup; import
 * javax.swing.ImageIcon; import javax.swing.JButton; import javax.swing.JFrame;
 * import javax.swing.JLabel; import javax.swing.JPanel; import
 * javax.swing.JRadioButton;
 * 
 * import main.java.tablero.Board;
 * 
 * public class MainMenu extends JFrame { private static final long
 * serialVersionUID = -974581707010951766L;
 * 
 * private JPanel panel; private JLabel titulo; private JLabel fondoImg; private
 * JButton botonJugar; private JRadioButton opcion1; private JRadioButton
 * opcion2;
 * 
 * private final static Integer ANCHO_JFRAME = Settings.TILE_X *
 * Settings.COLUMNAS; private final static Integer ALTO_JFRAME = Settings.TILE_Y
 * * Settings.FILAS;
 * 
 * public MainMenu() { Settings.setPreJuego(true);
 * 
 * settingsJFrame(); crearPanel(); crearEtiquetas(); crearRadioButton();
 * crearBotonJugar(); botonJugar.addMouseListener(eventoBotonJugar()); }
 * 
 * public void settingsJFrame() { setSize(ANCHO_JFRAME, ALTO_JFRAME);
 * setTitle(" CONECTA-4 | By Juan Eguia | Menu Principal");
 * setLocationRelativeTo(null); setResizable(false); setMinimumSize(new
 * Dimension(300, 200)); setVisible(true); //
 * this.getContentPane().setBackground(Color.BLUE);
 * setDefaultCloseOperation(EXIT_ON_CLOSE); }
 * 
 * public void crearPanel() { panel = new JPanel(); panel.setLayout(null);
 * 
 * // panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
 * panel.setBackground(Color.LIGHT_GRAY);
 * 
 * this.getContentPane().add(panel); }
 * 
 * public void crearEtiquetas() { String txt = "CONECTA 4"; int x = (int)
 * (ANCHO_JFRAME / 2);
 * 
 * titulo = new JLabel(txt); Font fuente = new Font("verdana", Font.BOLD, 55);
 * titulo.setFont(fuente);
 * 
 * FontMetrics fm = titulo.getFontMetrics(fuente); int txtWidth =
 * fm.stringWidth(txt);
 * 
 * // titulo.setHorizontalAlignment(SwingConstants.CENTER);
 * 
 * titulo.setBounds(x - (int) (txtWidth / 2), (int) (ALTO_JFRAME / 20), (int)
 * (ANCHO_JFRAME / 2), (int) (ALTO_JFRAME / 7));
 * 
 * titulo.setForeground(Settings.Colores.AZUL); // etiquetaGO.setOpaque(true);
 * 
 * panel.add(titulo);
 * 
 * crearFondoImg(); }
 * 
 * private void crearFondoImg() { fondoImg = new JLabel();
 * 
 * ImageIcon icono = new ImageIcon("media/board-game-connect4.png"); Image
 * imagen = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
 * 
 * fondoImg.setIcon(new ImageIcon(imagen));
 * 
 * double posX = Settings.COLUMNAS * Settings.TILE_X / 2.6;
 * fondoImg.setBounds((int) posX, 200, 150, 150);
 * 
 * panel.add(fondoImg); }
 * 
 * private void crearRadioButton() { opcion1 = new
 * JRadioButton("Comienza Jugador"); opcion2 = new JRadioButton("Comienza IA");
 * 
 * opcion1.setBounds(400 - (int) (80 / 2), (int) (ALTO_JFRAME / 4), (int)
 * (ANCHO_JFRAME / 5), (int) (ALTO_JFRAME / 20));
 * 
 * opcion2.setBounds(200 - (int) (80 / 2), (int) (ALTO_JFRAME / 4), (int)
 * (ANCHO_JFRAME / 5), (int) (ALTO_JFRAME / 20));
 * 
 * opcion1.setBackground(Color.LIGHT_GRAY);
 * opcion2.setBackground(Color.LIGHT_GRAY);
 * 
 * opcion1.setSelected(true);
 * 
 * // Agrupar los botones para que solo uno pueda estar seleccionado ButtonGroup
 * grupo = new ButtonGroup(); grupo.add(opcion1); grupo.add(opcion2);
 * 
 * ActionListener listener = new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { // listener para
 * detectar cambio en quien comienza... } };
 * 
 * opcion1.addActionListener(listener); opcion2.addActionListener(listener);
 * 
 * panel.add(opcion1); panel.add(opcion2); }
 * 
 * public void crearBotonJugar() { botonJugar = new JButton("Nueva Partida");
 * 
 * botonJugar.setFont(new Font("verdana", Font.BOLD, 24)); //
 * botonNG.setSize((int) (goX / 1.3), (int) (goY / 8));
 * botonJugar.setFocusable(false); botonJugar.setBorder(null); //
 * botonJugar.setMargin();
 * botonJugar.setBorder(BorderFactory.createEmptyBorder((int) (ALTO_JFRAME /
 * 12), 0, (int) (ALTO_JFRAME / 12), 0));
 * 
 * // botonJugar.requestFocus(); //
 * botonNG.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1, true));
 * 
 * botonJugar.setBounds((int) (ANCHO_JFRAME / 3.5), (int) (ALTO_JFRAME / 1.5),
 * (int) (ANCHO_JFRAME / 2.5), (int) (ALTO_JFRAME / 7));
 * 
 * // botonNG.setOpaque(true);
 * botonJugar.setForeground(Settings.Colores.AZUL_CLARO);
 * 
 * // panel.add(botonJugar); panel.add(botonJugar); }
 * 
 * public MouseListener eventoBotonJugar() { MouseListener jugar = new
 * MouseListener() {
 * 
 * @Override public void mouseClicked(MouseEvent e) { dispose();
 * 
 * Board tablero = new Board(opcion1.isSelected()); tablero.setVisible(true); }
 * 
 * @Override public void mousePressed(MouseEvent e) { }
 * 
 * @Override public void mouseReleased(MouseEvent e) { }
 * 
 * @Override public void mouseEntered(MouseEvent e) {
 * botonJugar.setForeground(Settings.Colores.AMARILLO); }
 * 
 * @Override public void mouseExited(MouseEvent e) {
 * botonJugar.setForeground(Settings.Colores.AZUL_CLARO); } };
 * 
 * return jugar; } }
 */
