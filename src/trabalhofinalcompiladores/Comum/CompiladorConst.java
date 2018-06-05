package trabalhofinalcompiladores.Comum;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Utilities;

public class CompiladorConst extends JPanel implements CaretListener, DocumentListener {

    private JTextArea jTextArea;

    private Color color;
    private int proximoDigito;
    private int aux;

    public CompiladorConst(JTextArea component) {
        this(component, 3);
    }

    public CompiladorConst(JTextArea component, int minimumDisplayDigits) {
        this.jTextArea = component;
        setFont(component.getFont());
        setColor(Color.BLUE);
        component.getDocument().addDocumentListener(this);
        component.addCaretListener(this);
        setTamanho();
    }

    public Color getColor() {
        return color == null ? getForeground() : color;
    }

    public void setColor(Color currentLineForeground) {
        this.color = currentLineForeground;
    }

    private void setTamanho() {
        Element Element = jTextArea.getDocument().getDefaultRootElement();
        int countLinhas = Element.getElementCount();
        int digito = Math.max(String.valueOf(countLinhas).length(), 3);
        if (proximoDigito != digito) {
            proximoDigito = digito;
            FontMetrics fontMetrics = getFontMetrics(getFont());
            int tamanho = fontMetrics.charWidth('0') * digito;
            Insets insets = getInsets();
            int Width = insets.left + insets.right + tamanho;

            Dimension dimension = getPreferredSize();
            dimension.setSize(Width, Integer.MAX_VALUE - 1000000);
            setPreferredSize(dimension);
            setSize(dimension);
        }
    }

    @Override
    public void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        FontMetrics fontMetrics = jTextArea.getFontMetrics(jTextArea.getFont());
        Insets insets = getInsets();
        int tamanho = getSize().width - insets.left - insets.right;
        Rectangle rectangle = grafico.getClipBounds();
        int linhaComeco = jTextArea.viewToModel(new Point(0, rectangle.y));
        int linhaFim = jTextArea.viewToModel(new Point(0, rectangle.y + rectangle.height));
        while (linhaComeco <= linhaFim) {
            try {
                if (EhALinhaCorrente(linhaComeco)) {
                    grafico.setColor(getColor());
                } else {
                    grafico.setColor(getForeground());
                }
                String numeroLinha = getTextoLinha(linhaComeco);
                int width = fontMetrics.stringWidth(numeroLinha);
                int x = getX(tamanho, width) + insets.left;
                int y = getY(linhaComeco, fontMetrics);
                grafico.drawString(numeroLinha, x, y);
                linhaComeco = Utilities.getRowEnd(jTextArea, linhaComeco) + 1;
            } catch (Exception e) {
                break;
            }
        }
    }

    private boolean EhALinhaCorrente(int rowStartOffset) {
        int caretPosition = jTextArea.getCaretPosition();
        Element element = jTextArea.getDocument().getDefaultRootElement();
        return element.getElementIndex(rowStartOffset) == element.getElementIndex(caretPosition);
    }

    protected String getTextoLinha(int rowStartOffset) {
        Element element = jTextArea.getDocument().getDefaultRootElement();
        int index = element.getElementIndex(rowStartOffset);
        Element linha = element.getElement(index);
        if (linha.getStartOffset() == rowStartOffset) {
            return String.valueOf(index + 1);
        } else {
            return "";
        }
    }

    private int getX(int availableWidth, int stringWidth) {
        return (int) (availableWidth - stringWidth);
    }

    private int getY(int rowStartOffset, FontMetrics fontMetrics) throws BadLocationException {
        Rectangle r = jTextArea.modelToView(rowStartOffset);
        int y = r.y + r.height;
        int descent = fontMetrics.getDescent();
        return y - descent;
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        repaint();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        AlterouCampoTextField();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        AlterouCampoTextField();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        AlterouCampoTextField();
    }

    private void AlterouCampoTextField() {
        try {
            int endPos = jTextArea.getDocument().getLength();
            Rectangle rect = jTextArea.modelToView(endPos);

            if (rect != null && rect.y != aux) {
                setTamanho();
                repaint();
                aux = rect.y;
            }
        } catch (BadLocationException ex) {
        }
    }
}
