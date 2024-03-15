package GPT;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ListDataListener;

public class ListaEnlazadaJList extends JFrame {
    private JList<String> jList;
    private ListaEnlazada<String> listaEnlazada;

    public ListaEnlazadaJList() {
        initComponents();
    }

    private void initComponents() {
        listaEnlazada = new ListaEnlazada<>();
        listaEnlazada.agregar("Elemento 1");
        listaEnlazada.agregar("Elemento 2");
        listaEnlazada.agregar("Elemento 3");

        jList = new JList<>(new ListaEnlazadaModel<>(listaEnlazada));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(jList), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListaEnlazadaJList());
    }

    // Implementación de la lista enlazada simple
    private static class ListaEnlazada<E> {
        private Nodo<E> inicio;

        public void agregar(E elemento) {
            Nodo<E> nuevoNodo = new Nodo<>(elemento);
            if (inicio == null) {
                inicio = nuevoNodo;
            } else {
                Nodo<E> actual = inicio;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
        }
    }

    // Clase Nodo para la lista enlazada
    private static class Nodo<E> {
        E elemento;
        Nodo<E> siguiente;

        public Nodo(E elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }

    // Implementación del modelo de lista personalizado
    private static class ListaEnlazadaModel<E> implements ListModel<E> {
        private ListaEnlazada<E> listaEnlazada;
        private ListaDataListener listaDataListener;

        public ListaEnlazadaModel(ListaEnlazada<E> listaEnlazada) {
            this.listaEnlazada = listaEnlazada;
            this.listaDataListener = new ListaDataListener();
        }

        @Override
        public int getSize() {
            // Obtener el tamaño de la lista enlazada
            int size = 0;
            Nodo<E> actual = listaEnlazada.inicio;
            while (actual != null) {
                size++;
                actual = actual.siguiente;
            }
            return size;
        }

        @Override
        public E getElementAt(int index) {
            // Obtener el elemento en la posición index
            Nodo<E> actual = listaEnlazada.inicio;
            for (int i = 0; i < index; i++) {
                actual = actual.siguiente;
            }
            return actual.elemento;
        }

        @Override
        public void addListDataListener(ListDataListener l) {
            // No es necesario implementar este método para este ejemplo
        }

        @Override
        public void removeListDataListener(ListDataListener l) {
            // No es necesario implementar este método para este ejemplo
        }

        // Clase interna para gestionar los eventos de cambio en la lista
        private class ListaDataListener implements ListDataListener {
            @Override
            public void intervalAdded(javax.swing.event.ListDataEvent e) {
                // Actualizar la vista si se añaden elementos a la lista enlazada
            }

            @Override
            public void intervalRemoved(javax.swing.event.ListDataEvent e) {
                // Actualizar la vista si se eliminan elementos de la lista enlazada
            }

            @Override
            public void contentsChanged(javax.swing.event.ListDataEvent e) {
                // Actualizar la vista si cambia el contenido de la lista enlazada
                
            }
        }
    }
}
